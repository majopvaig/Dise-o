package dtos;

import dtos.ENUMS.EstadoAsientoDTO;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoEventoDTO {

    private Long idReservacion;
    private EstadoAsientoDTO estadoAsiento;
    private Long idAsiento;
    private Long idEvento;

    public AsientoEventoDTO() {
    }

    public AsientoEventoDTO(Long idReservacion, EstadoAsientoDTO estadoAsiento, Long idAsiento, Long idEvento) {
        this.idReservacion = idReservacion;
        this.estadoAsiento = estadoAsiento;
        this.idAsiento = idAsiento;
        this.idEvento = idEvento;
    }

    public AsientoEventoDTO(EstadoAsientoDTO estadoAsiento, Long idAsiento, Long idEvento) {
        this.estadoAsiento = estadoAsiento;
        this.idAsiento = idAsiento;
        this.idEvento = idEvento;
    }

    public Long getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Long idReservacion) {
        this.idReservacion = idReservacion;
    }

    public EstadoAsientoDTO getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsientoDTO estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public Long getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Long idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "AsientoEventoDTO{" + "idReservacion=" + idReservacion + ", estadoAsiento=" + estadoAsiento + ", idAsiento=" + idAsiento + ", idEvento=" + idEvento + '}';
    }

}
