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

    private Long idReservacion;
    private EstadoAsiento estadoAsiento;
    private Asiento asiento;
    private Evento evento;

    public AsientoEvento() {
    }

    public AsientoEvento(Long idReservacion, EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
        this.idReservacion = idReservacion;
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public AsientoEvento(EstadoAsiento estadoAsiento, Asiento asiento, Evento evento) {
        this.estadoAsiento = estadoAsiento;
        this.asiento = asiento;
        this.evento = evento;
    }

    public Long getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Long idReservacion) {
        this.idReservacion = idReservacion;
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

    @Override
    public String toString() {
        return "AsientoEvento{" + "idReservacion=" + idReservacion + ", estadoAsiento=" + estadoAsiento + ", asiento=" + asiento + ", evento=" + evento + '}';
    }

}
