/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import entidadesresumenmongo.AsientoEventoResumenMongo;
import entidadesresumenmongo.EventoResumenMongo;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class BoletoMongoEntidad {
    
    private String codigoQR;
    private double precio;
    private String estado;
    private EventoResumenMongo evento;
    private AsientoEventoResumenMongo asiento;

    public BoletoMongoEntidad() {
    }

    public BoletoMongoEntidad(String codigoQR, double precio, String estado, EventoResumenMongo evento, AsientoEventoResumenMongo asiento) {
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.estado = estado;
        this.evento = evento;
        this.asiento = asiento;
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

    public EventoResumenMongo getEvento() {
        return evento;
    }

    public void setEvento(EventoResumenMongo evento) {
        this.evento = evento;
    }

    public AsientoEventoResumenMongo getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoEventoResumenMongo asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "BoletoMongoEntidad{" 
                + ", codigoQR=" + codigoQR 
                + ", precio=" + precio 
                + ", estado=" + estado 
                + ", evento=" + evento 
                + ", asiento=" + asiento 
                + '}';
    }
    
}
