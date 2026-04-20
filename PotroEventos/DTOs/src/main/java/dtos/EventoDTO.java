package dtos;

import dtos.ENUMS.CategoriaEventoDTO;
import dtos.ENUMS.EstadoEventoDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class EventoDTO {

    private Long idEvento;
    private CategoriaEventoDTO categoriaEvento;
    private String nombreEvento;
    private String informacionEvento;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private EstadoEventoDTO estadoEvento;

    public EventoDTO() {
    }

    public EventoDTO(Long idEvento, CategoriaEventoDTO categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEventoDTO estadoEvento) {
        this.idEvento = idEvento;
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estadoEvento = estadoEvento;
    }

    public EventoDTO(CategoriaEventoDTO categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEventoDTO estadoEvento) {
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estadoEvento = estadoEvento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public CategoriaEventoDTO getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEventoDTO categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getInformacionEvento() {
        return informacionEvento;
    }

    public void setInformacionEvento(String informacionEvento) {
        this.informacionEvento = informacionEvento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstadoEventoDTO getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEventoDTO estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    @Override
    public String toString() {
        return "EventoDTO{" + "idEvento=" + idEvento + ", categoriaEvento=" + categoriaEvento + ", nombreEvento=" + nombreEvento + ", informacionEvento=" + informacionEvento + ", fechaHora=" + fechaHora + ", ubicacion=" + ubicacion + ", estadoEvento=" + estadoEvento + '}';
    }

}
