/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private double total;
    private BoletoMongoEntidad boleto;
    private String cobro;
    private ObjectId usuario;
    private LocalDateTime fechaRegistro;
    private String estado;

    public ReservacionMongoEntidad() {
    }

    public ReservacionMongoEntidad(double total, BoletoMongoEntidad boleto, String cobro, ObjectId usuario, LocalDateTime fechaRegistro, String estado) {
        this.total = total;
        this.boleto = boleto;
        this.cobro = cobro;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public ReservacionMongoEntidad(ObjectId id, double total, BoletoMongoEntidad boleto, String cobro, ObjectId usuario, LocalDateTime fechaRegistro, String estado) {
        this.id = id;
        this.total = total;
        this.boleto = boleto;
        this.cobro = cobro;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BoletoMongoEntidad getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoMongoEntidad boleto) {
        this.boleto = boleto;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String cobro) {
        this.cobro = cobro;
    }

    public ObjectId getUsuario() {
        return usuario;
    }

    public void setUsuario(ObjectId usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuarioComoTexto(){
        if(usuario == null){
            return null;
        }
        return usuario.toHexString();
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservacionMongoEntidad{" 
                + "id=" + getIdComoTexto() 
                + ", total=" + total 
                + ", boleto=" + boleto 
                + ", cobro=" + cobro
                + ", usuario=" + getUsuarioComoTexto() 
                + ", fechaRegistro=" + fechaRegistro 
                + ", estado=" + estado 
                + '}';
    }
    
}
