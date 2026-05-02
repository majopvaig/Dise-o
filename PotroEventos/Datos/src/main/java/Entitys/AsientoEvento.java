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

    private Long idAsientoEvento;
    private Reservacion reservacion;
    private EstadoAsiento estadoAsiento;
    private Asiento asiento;
    private Evento evento;

    public AsientoEvento() {
    }

    public AsientoEvento(Reservacion reservacion, EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
        this.reservacion = reservacion;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public AsientoEvento(Long idAsientoEvento, Reservacion reservacion, EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
        this.idAsientoEvento = idAsientoEvento;
        this.reservacion = reservacion;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public Long getIdAsientoEvento() {
        return idAsientoEvento;
    }

    public void setIdAsientoEvento(Long idAsientoEvento) {
        this.idAsientoEvento = idAsientoEvento;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
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
