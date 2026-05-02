package control;

import dtos.*;
import objetosNegocio.*;
import excepciones.CompraBoletoException;
import excepciones.NegocioException;
import excepciones.PagoException;
import fachada.PagoFachada;
import interfaces.IAsientoBO;
import interfaces.IAsientoEventoBO;
import interfaces.ICategoriaBO;
import interfaces.IEventoBO;
import interfaces.IReservacionBO;
import interfaces.ISeccionBO;
import interfaces.IUsuarioBO;
import interfaz.IControlCompraBoleto;
import interfaz.IPago;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
//import objetosNegocio.EventoBO;

/**
 * Controlador de caso de uso para la compra de boletos. Orquesta la
 * comunicación con los BOs y transforma Entidades a DTOs.
 *
 * * @author Kaleb
 */
public class ControlCompraBoleto implements IControlCompraBoleto {

    // Dependencias a la capa de Negocio (BOs)
    private final IEventoBO eventoBO;
    private final ISeccionBO seccionBO;
    private final IAsientoBO asientoBO;
    private final IAsientoEventoBO asientoEventoBO;
    private final IReservacionBO reservacionBO;
    private final ICategoriaBO categoriaBO;
    private final IUsuarioBO usuarioBO;
    private final IPago controlPago;
    private List<AsientoEventoDTO> asientosPendientesCompra;
    private Long totalPendienteCompra;

    public ControlCompraBoleto() {
        this.eventoBO = EventoBO.getInstance();
        this.seccionBO = SeccionBO.getInstance();
        this.asientoBO = AsientoBO.getInstance();
        this.asientoEventoBO = AsientoEventoBO.getInstance();
        this.reservacionBO = ReservacionBO.getInstance();
        this.categoriaBO = CategoriaBO.getInstance();
        this.usuarioBO = UsuarioBO.getInstance();
        this.controlPago = new PagoFachada();
    }

    /**
     * Obtiene el evento desde el BO y lo convierte a EventoDTO.
     */
    @Override
    public EventoDTO obtenerInformacionEvento(Long idEvento) throws CompraBoletoException {
        try {
            EventoDTO e = eventoBO.obtenerEventoPorId(idEvento);
            if (e == null) {
                throw new CompraBoletoException("El evento con ID " + idEvento + " no fue encontrado.");
            }
            return e;

        } catch (Exception ex) {
            throw new CompraBoletoException("Error al obtener la información del evento: " + ex.getMessage());
        }
    }

    /**
     * Obtiene las secciones de un evento y las convierte a SeccionDTO.
     */
    @Override
    public List<SeccionDTO> obtenerSeccionesEvento(Long idEvento) throws CompraBoletoException {
        try {
            List<SeccionDTO> secciones = seccionBO.consultarSeccionesPorEvento(idEvento);
            return secciones;
        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar las secciones: " + ex.getMessage());
        }
    }

    /**
     * Obtiene los estados de los asientos (ocupados/disponibles) y los
     * convierte a AsientoEventoDTO.
     */
    @Override
    public List<AsientoEventoDTO> obtenerOcupacionEvento(Long idEvento) throws CompraBoletoException {
        try {
            List<AsientoEventoDTO> estados = asientoEventoBO.consultarEstadosPorEvento(idEvento);
            return estados;

        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar la ocupación del evento: " + ex.getMessage());
        }
    }

    /**
     * Obtiene el catálogo físico de asientos y lo convierte a AsientoDTO.
     */
    @Override
    public List<AsientoDTO> obtenerCatalogoAsientos() throws CompraBoletoException {
        try {
            List<AsientoDTO> asientos = asientoBO.consultarTodosLosAsientos();

            return asientos.stream().map(a -> new AsientoDTO(
                    a.getIdAsiento(),
                    a.getFila(),
                    a.getNumero(),
                    a.getIdSeccion()
            )).collect(Collectors.toList());

        } catch (Exception ex) {
            throw new CompraBoletoException("Error al cargar el catálogo de asientos: " + ex.getMessage());
        }
    }

    @Override
    public Map<SeccionDTO, List<AsientoEventoDTO>> obtenerMapaOcupacion(Long idEvento) throws CompraBoletoException {
        try {
            List<SeccionDTO> secciones = seccionBO.consultarSeccionesPorEvento(idEvento);
            List<AsientoEventoDTO> ocupacion = asientoEventoBO.consultarEstadosPorEvento(idEvento);

            // Catálogo real desde asientoBO (NO desde coordinador)
            List<AsientoDTO> catalogo = this.obtenerCatalogoAsientos();

            Map<SeccionDTO, List<AsientoEventoDTO>> mapa = new HashMap<>();

            if (secciones != null && ocupacion != null) {
                for (SeccionDTO seccion : secciones) {

                    List<AsientoEventoDTO> asientosDeSeccion = ocupacion.stream()
                            .filter(ae -> {
                                for (AsientoDTO asiento : catalogo) {
                                    if (asiento.getIdAsiento().equals(ae.getIdAsiento())) {
                                        return asiento.getIdSeccion().equals(seccion.getIdSeccion());
                                    }
                                }
                                return false;
                            })
                            .collect(Collectors.toList());

                    mapa.put(seccion, asientosDeSeccion);
                }
            }

            return mapa;

        } catch (Exception e) {
            throw new CompraBoletoException("Error al construir mapa de ocupación: " + e.getMessage());
        }
    }

    @Override
    public boolean agregarReservacion(ReservacionDTO reservacion) throws CompraBoletoException {
        try {
            return reservacionBO.agregarReservacion(reservacion);
        } catch (Exception ex) {
            throw new CompraBoletoException("Error al agregar la reservación: " + ex.getMessage());
        }
    }

    public String generarCodigoQR(EventoDTO evento, AsientoEventoDTO asiento) throws CompraBoletoException {
        try {
            int asientoID = 0;
            int identificador = 0;
            if (asiento == null) {
                asientoID = 0;
                identificador = LocalDateTime.now().getNano();
            } else {
                asientoID = asiento.getIdAsiento().intValue();
                identificador = asiento.getIdAsiento().intValue();
            }
            String datosBoleto = "Evento: " + evento.getNombreEvento()
                    + ", Fecha y Hora: " + evento.getFechaHora()
                    + ", Ubicación: " + evento.getUbicacion().getNombre()
                    + ", Asiento: " + asientoID;

            String nombreCarpeta = "qrs-boletos";
            File archivoQRTemporal = QRCode.from(datosBoleto)
                    .to(ImageType.PNG)
                    .withSize(300, 300)
                    .file();
            String nombreArchivo = "Boleto_" + identificador + evento.getIdEvento() + ".png";
            File archivoFinal = new File("qrs-boletos", nombreArchivo);
            Files.copy(archivoQRTemporal.toPath(), archivoFinal.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return archivoFinal.getAbsolutePath();
        } catch (Exception e) {
            throw new CompraBoletoException("Fallos para generar QR: " + e.getMessage());
        }
    }

    public boolean reservarAsiento(Long idAsientoEvento) throws CompraBoletoException {
        try {
            return asientoEventoBO.reservarAsiento(idAsientoEvento);
        } catch (NegocioException e) {
            throw new CompraBoletoException(e.getMessage());
        }
    }

    public boolean liberarAsiento(Long idAsientoEvento) throws CompraBoletoException {
        try {
            return asientoEventoBO.liberarAsiento(idAsientoEvento);
        } catch (NegocioException e) {
            throw new CompraBoletoException(e.getMessage());
        }
    }

    public boolean venderAsientos(List<AsientoEventoDTO> asientosSeleccionados, Long totalCompra, boolean gratuito, ReservacionDTO reservacion) throws CompraBoletoException {
        try {
            if (reservacion == null) {
                return false;
            }
            if (gratuito) {
                try {
                    reservacionBO.agregarReservacion(reservacion);
                } catch (NegocioException ex) {
                    throw new CompraBoletoException(ex.getMessage());
                }

                return true;

            } else {
                if (reservacion.getCobro() != null) {
                    if (usuarioBO.restarCreditos(totalCompra.intValue() * 2, reservacion.getUsuario().getIdUsuario())) {
                        asientoEventoBO.venderAsiento(reservacion.getBoleto().getAsiento().getIdAsiento());
                        reservacionBO.agregarReservacion(reservacion);
                        return true;
                    }
                    return false;
                }
                this.asientosPendientesCompra = new ArrayList<>(asientosSeleccionados);
                this.totalPendienteCompra = totalCompra;
                return true;
            }
        } catch (NegocioException e) {
            return false;
        }
    }

    public boolean realizarCompra(TarjetaDTO noTarjeta, CobroDTO cobro) throws CompraBoletoException {
        try {

            boolean pagado = controlPago.procesarPago(noTarjeta, cobro);

            if (pagado) {

                for (AsientoEventoDTO asiento : asientosPendientesCompra) {
                    asientoEventoBO.venderAsiento(asiento.getIdAsiento());
                }

                asientosPendientesCompra.clear();
                totalPendienteCompra = 0L;

                return true;
            }

        } catch (NegocioException | PagoException ex) {
            throw new CompraBoletoException(ex.getMessage());
        }

        return false;
    }

    public Long getTotalPendiente() {
        return totalPendienteCompra;
    }
}
