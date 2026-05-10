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

    private String idAsientoEvento;
    private Double precio;
    private EstadoAsientoDTO estadoAsiento;
    private AsientoDTO asiento;
    private EventoDTO evento;

    public AsientoEventoDTO() {
    }

    public AsientoEventoDTO(Double precio, EstadoAsientoDTO estadoAsiento, AsientoDTO asiento, EventoDTO evento) {
        this.precio = precio;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public AsientoEventoDTO(String idAsientoEvento, Double precio, EstadoAsientoDTO estadoAsiento, AsientoDTO asiento, EventoDTO evento) {
        this.idAsientoEvento = idAsientoEvento;
        this.precio = precio;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public String getIdAsientoEvento() {
        return idAsientoEvento;
    }

    public void setIdAsientoEvento(String idAsientoEvento) {
        this.idAsientoEvento = idAsientoEvento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public EstadoAsientoDTO getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsientoDTO estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public AsientoDTO getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoDTO asiento) {
        this.asiento = asiento;
    }

    public EventoDTO getEvento() {
        return evento;
    }

    public void setEvento(EventoDTO evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "AsientoEventoDTO{" + "idAsientoEvento=" + idAsientoEvento + ", precio=" + precio + ", estadoAsiento=" + estadoAsiento + ", asiento=" + asiento + ", evento=" + evento + '}';
    }

}
