/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class AsientoEventoMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private ReservacionMongoEntidad reservacion;
    private String estado;
    private AsientoMongoEntidad asiento;
    private EventoMongoEntidad evento;

    public AsientoEventoMongoEntidad() {
    }

    public AsientoEventoMongoEntidad(ReservacionMongoEntidad reservacion, String estado, AsientoMongoEntidad asiento, EventoMongoEntidad evento) {
        this.reservacion = reservacion;
        this.estado = estado;
        this.asiento = asiento;
        this.evento = evento;
    }

    public AsientoEventoMongoEntidad(ObjectId id, ReservacionMongoEntidad reservacion, String estado, AsientoMongoEntidad asiento, EventoMongoEntidad evento) {
        this.id = id;
        this.reservacion = reservacion;
        this.estado = estado;
        this.asiento = asiento;
        this.evento = evento;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public String getIdComoTexto(){
        if(id == null){
            return null;
        }
        return id.toHexString();
    }

    public ReservacionMongoEntidad getReservacion() {
        return reservacion;
    }

    public void setReservacion(ReservacionMongoEntidad reservacion) {
        this.reservacion = reservacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AsientoMongoEntidad getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoMongoEntidad asiento) {
        this.asiento = asiento;
    }

    public EventoMongoEntidad getEvento() {
        return evento;
    }

    public void setEvento(EventoMongoEntidad evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "AsientoEventoMongoEntidad{" 
                + "id=" + id 
                + ", reservacion=" + reservacion 
                + ", estado=" + estado 
                + ", asiento=" + asiento 
                + ", evento=" + evento + '}';
    }
    
}
