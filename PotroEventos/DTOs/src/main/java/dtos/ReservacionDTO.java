/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import dtos.ENUMS.ReservacionEstadoDTO;
import java.time.LocalDateTime;

/**
 *
 * @author maria
 */
public class ReservacionDTO {

    private String idReservacion;
    private Double total;
    private BoletoDTO boleto;
    private String cobro;
    private UsuarioDTO usuario;
    private LocalDateTime fechaHora;
    private ReservacionEstadoDTO estado;
    private DevolucionDTO devolucion;

    public ReservacionDTO() {
    }

    public ReservacionDTO(Double total, BoletoDTO boleto, String cobro, UsuarioDTO usuario, LocalDateTime fechaHora, ReservacionEstadoDTO estado, DevolucionDTO devolucion) {
        this.total = total;
        this.boleto = boleto;
        this.cobro = cobro;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.devolucion = devolucion;
    }

    public ReservacionDTO(String idReservacion, Double total, BoletoDTO boleto, String cobro, UsuarioDTO usuario, LocalDateTime fechaHora, ReservacionEstadoDTO estado, DevolucionDTO devolucion) {
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

    public BoletoDTO getBoleto() {
        return boleto;
    }

    public void setBoleto(BoletoDTO boleto) {
        this.boleto = boleto;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String cobro) {
        this.cobro = cobro;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ReservacionEstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(ReservacionEstadoDTO estado) {
        this.estado = estado;
    }

    public DevolucionDTO getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(DevolucionDTO devolucion) {
        this.devolucion = devolucion;
    }
    
}
