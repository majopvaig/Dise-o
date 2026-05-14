/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import Entitys.ENUMS.ReservacionEstado;
import java.time.LocalDateTime;

/**
 *
 * @author maria
 */
public class Reservacion {
    
    private String idReservacion;
    private Double total;
    private Boleto boleto;
    private String cobro;
    private Usuario usuario;
    private LocalDateTime fechaHora;
    private ReservacionEstado estado;
    private Devolucion devolucion;

    public Reservacion() {
    }

    public Reservacion(Double total, Boleto boleto, String cobro, Usuario usuario, LocalDateTime fechaHora, ReservacionEstado estado, Devolucion devolucion) {
        this.total = total;
        this.boleto = boleto;
        this.cobro = cobro;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.devolucion = devolucion;
    }

    public Reservacion(String idReservacion, Double total, Boleto boleto, String cobro, Usuario usuario, LocalDateTime fechaHora, ReservacionEstado estado, Devolucion devolucion) {
        this.idReservacion = idReservacion;
        this.total = total;
        this.boleto = boleto;
        this.cobro = cobro;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.devolucion = devolucion;
    }

    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String cobro) {
        this.cobro = cobro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ReservacionEstado getEstado() {
        return estado;
    }

    public void setEstado(ReservacionEstado estado) {
        this.estado = estado;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }
    
}
