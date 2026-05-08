package interfaz;

import dtos.AsientoDTO;
import dtos.AsientoEventoDTO;
import dtos.CobroDTO;
import dtos.EventoDTO;
import dtos.ReservacionDTO;
import dtos.SeccionDTO;
import dtos.TarjetaDTO;
import dtos.UsuarioInstitucionalDTO;
import excepciones.CompraBoletoException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public interface IControlCompraBoleto {

    /**
     * Obtiene la lista de secciones asociadas a un evento.
     */
    List<SeccionDTO> obtenerSeccionesEvento(String idEvento) throws CompraBoletoException;

    /**
     * Obtiene el estado de ocupación de los asientos para un evento específico.
     */
    List<AsientoEventoDTO> obtenerOcupacionEvento(String idEvento) throws CompraBoletoException;

    /**
     * Obtiene el catálogo completo de asientos físicos registrados en el
     * sistema.
     */
    List<AsientoDTO> obtenerCatalogoAsientos() throws CompraBoletoException;

    /**
     * Registra una nueva reservación en el sistema.
     */
    boolean agregarReservacion(ReservacionDTO reservacion) throws CompraBoletoException;

    public Map<SeccionDTO, List<AsientoEventoDTO>> obtenerMapaOcupacion(String idEvento) throws CompraBoletoException;

    public String generarCodigoQR(EventoDTO evento, AsientoEventoDTO asiento) throws CompraBoletoException;

    public boolean reservarAsiento(String idAsientoEvento) throws CompraBoletoException;

    public boolean liberarAsiento(String idAsientoEvento) throws CompraBoletoException;

    public boolean venderAsientos(List<AsientoEventoDTO> asientosSeleccionados, Long totalCompra, boolean gratuito, ReservacionDTO reservacion) throws CompraBoletoException;

    public boolean realizarCompra(TarjetaDTO tarjeta, CobroDTO cobro) throws CompraBoletoException;

    public Long getTotalPendiente();

    public boolean validarCredencialesITSON(UsuarioInstitucionalDTO usuario);
}
