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
public class BoletoMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private String codigoQR;
    private double precio;
    private String estado;
    private EventoMongoEntidad evento;
    private AsientoEventoMongoEntidad asiento;

    public BoletoMongoEntidad() {
    }

    public BoletoMongoEntidad(String codigoQR, double precio, String estado, EventoMongoEntidad evento, AsientoEventoMongoEntidad asiento) {
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.estado = estado;
        this.evento = evento;
        this.asiento = asiento;
    }

    public BoletoMongoEntidad(ObjectId id, String codigoQR, double precio, String estado, EventoMongoEntidad evento, AsientoEventoMongoEntidad asiento) {
        this.id = id;
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.estado = estado;
        this.evento = evento;
        this.asiento = asiento;
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

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EventoMongoEntidad getEvento() {
        return evento;
    }

    public void setEvento(EventoMongoEntidad evento) {
        this.evento = evento;
    }

    public AsientoEventoMongoEntidad getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoEventoMongoEntidad asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "BoletoMongoEntidad{" 
                + "id=" + id 
                + ", codigoQR=" + codigoQR 
                + ", precio=" + precio 
                + ", estado=" + estado 
                + ", evento=" + evento 
                + ", asiento=" + asiento + '}';
    }
    
}
