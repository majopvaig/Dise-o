/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.coordinador;

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
import java.util.List;

/**
 *
 * @author maria
 */
public class CoordinadorDevolucion implements ICoordinadorDevolucion {
    
    private PantallaDevolucion frmDevolucion;
    private PantallaEventoCancelar frmEventoCancelar;
    private IFachadaGestionEvento controlEvento = new GestionEventoFachada();
    
    @Override
    public List<ReservacionDTO> consultarReservacionesUsuario(String idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirMostrarEventoCancelar(ReservacionDTO reservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarDevolucion(ReservacionDTO reservacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancelarReservacionGratuita(ReservacionDTO reservaciom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean cancelarReservacionPaga(ReservacionDTO reservacion, TipoDevolucionN tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void abrirConsultar(UsuarioDTO usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EventoDTO consultarEvento(EventoDTO evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarTiempo(EventoDTO evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean registrarMotivoCancelacion(DevolucionDTO devolucion) {
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
    
}
