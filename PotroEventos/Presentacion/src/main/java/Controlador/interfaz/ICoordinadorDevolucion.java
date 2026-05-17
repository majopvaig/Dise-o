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
 
    /*
    esto es para ir por las reservaciones del usuario, pero lowkey eso lo hace el
    coordinador principal so lol
    */
    List<ReservacionDTO> consultarReservacionesUsuario(String idUsuario);
    
    /*
    esto es para ver la info del evento q se quiere cancelar
    */
    void abrirMostrarEventoCancelar(ReservacionDTO reservacion);
    
    /*
    esto es para abrir el panel de formulario de cancelacion
    */
    void mostrarDevolucion(ReservacionDTO reservacion);
    
    /*
    esto ya son operaciones de negocio, es ir al subsistema y cancelar reservacion gratis
    */
    boolean cancelarReservacionGratuita(ReservacionDTO reservacion);
    
    /*
    esto ya son operaciones de negocio, es ir al subsistema y cancelar reservacion de paga
    */
    boolean cancelarReservacionPaga(ReservacionDTO reservacion, TipoDevolucionN tipo);
    
    /*
    abrir el panel de consultar
    considerando quitar el parámetro xq se supone que el coordinador ya sabe que
    reservaciones está consultando
    */
    void abrirConsultar(UsuarioDTO usuario);
    
    /*
    esto es para jalar la info del evento pero también está demás xq todo eso
    se jala de la reservación
    */
    EventoDTO consultarEvento(EventoDTO evento);
    
    /*
    chamba interna donde cuida que el evento que se quiere cancelar no esté a 
    menos de 48 horas de ocurrir
    */
    boolean validarTiempo(EventoDTO evento);
    
    /*
    registrar el motivo.
    aquí yo creo q las operaciones de reservación seria
    -cancelarla
    -append el motivo de cancelacion + su reembolso (en caso de usarse)
    */
    boolean registrarMotivoCancelacion(DevolucionDTO devolucion, String idDevolucion);
    
    /*
    solo es ir a la gestión evento y aumentar la capacidad
    */
    boolean aumentarCapacidadEvento(String idEvento);
    
    void inicioAplicacion();
    
}
