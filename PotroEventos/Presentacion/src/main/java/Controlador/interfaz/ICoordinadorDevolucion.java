/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.interfaz;

import dtos.DevolucionDTO;
import dtos.ENUMS.TipoDevolucionN;
import dtos.EventoDTO;
import dtos.ReservacionDTO;
import dtos.UsuarioDTO;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ICoordinadorDevolucion {
 
    List<ReservacionDTO> consultarReservacionesUsuario(String idUsuario);
    
    void abrirMostrarEventoCancelar(ReservacionDTO reservacion);
    
    void mostrarDevolucion(ReservacionDTO reservacion);
    
    boolean cancelarReservacionGratuita(ReservacionDTO reservaciom);
    
    boolean cancelarReservacionPaga(ReservacionDTO reservacion, TipoDevolucionN tipo);
    
    void abrirConsultar(UsuarioDTO usuario);
    
    EventoDTO consultarEvento(EventoDTO evento);
    
    boolean validarTiempo(EventoDTO evento);
    
    boolean registrarMotivoCancelacion(DevolucionDTO devolucion);
    
    boolean aumentarCapacidadEvento(String idEvento);
    
    
}
