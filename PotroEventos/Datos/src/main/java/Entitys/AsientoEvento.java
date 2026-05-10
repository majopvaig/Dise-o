package Entitys;

import Entitys.ENUMS.EstadoAsiento;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoEvento {

    private String idAsientoEvento;
    private Double precio;
    private EstadoAsiento estadoAsiento;
    private Asiento asiento;
    private Evento evento;

    public AsientoEvento() {
    }

    public AsientoEvento(Double precio, EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
        this.precio = precio;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public AsientoEvento(String idAsientoEvento, Double precio, EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
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

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}
