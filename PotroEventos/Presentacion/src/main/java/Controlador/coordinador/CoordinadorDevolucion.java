/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.coordinador;

import Controlador.interfaz.ICoordinadorAplicacion;
import Controlador.interfaz.ICoordinadorDevolucion;
import PantallasDevolucion.PantallaDevolucion;
import PantallasDevolucion.PantallaEventoCancelar;
import dtos.DevolucionDTO;
import dtos.ENUMS.TipoDevolucionN;
import dtos.EventoDTO;
import dtos.ReservacionDTO;
import dtos.UsuarioDTO;
import excepciones.GestionEventoException;
import fachada.GestionEventoFachada;
import interfaces.IFachadaGestionEvento;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 *
 * @author maria
 */
public class CoordinadorDevolucion implements ICoordinadorDevolucion {
    
    private PantallaDevolucion frmDevolucion;
    private PantallaEventoCancelar frmEventoCancelar;
    private final ICoordinadorAplicacion coordinadorApp;
    private final IFachadaGestionEvento controlEvento = new GestionEventoFachada();
    
    public CoordinadorDevolucion(ICoordinadorAplicacion coordinador){
        this.coordinadorApp = coordinador;
    }
    
    private void ocultarTodo(){
        if(frmDevolucion != null){
            frmDevolucion.setVisible(false);
        }
        if(frmEventoCancelar != null){
            frmEventoCancelar.setVisible(false);
        }
    }
    
    @Override
    public List<ReservacionDTO> consultarReservacionesUsuario(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirMostrarEventoCancelar(ReservacionDTO reservacion) {
        ocultarTodo();
        if(frmEventoCancelar == null){
            frmEventoCancelar = new PantallaEventoCancelar(reservacion, this);
        } else {
            frmEventoCancelar.setReservacion(reservacion);
        }
        frmEventoCancelar.setVisible(true);
    }

    @Override
    public void mostrarDevolucion(ReservacionDTO reservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancelarReservacionGratuita(ReservacionDTO reservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancelarReservacionPaga(ReservacionDTO reservacion, TipoDevolucionN tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirConsultar(UsuarioDTO usuario) {
        ocultarTodo();
        coordinadorApp.mostrarConsultar();
    }

    @Override
    public EventoDTO consultarEvento(EventoDTO evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    sabes k we yo creo q esto lo puede hacer el subsistema as well
    */
    @Override
    public boolean validarTiempo(EventoDTO evento) {
        LocalDateTime limite48Horas = LocalDateTime.now().minus(48, ChronoUnit.HOURS);
        return evento.getFechaHora().isBefore(limite48Horas);
    }

    @Override
    public boolean registrarMotivoCancelacion(DevolucionDTO devolucion, String idReservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean aumentarCapacidadEvento(String idEvento) {
        try {
            return controlEvento.aumentarCapacidad(idEvento);
        } catch (GestionEventoException gee) {
            return false;
        }
    }
    
    @Override
    public void inicioAplicacion(){
        ocultarTodo();
        coordinadorApp.mostrarInicio();
    }
    
}
