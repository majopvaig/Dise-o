/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dtos.UsuarioDTO;
import interfaces.IGestionUsuariosFachada;
import controles.ControlGestionUsuarios;
import dtos.ReservacionDTO;
import excepciones.GestionUsuarioException;
import java.util.List;

/**
 * Fachada del subsistema, se encarga de comunicarse con el controlador.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class GestionUsuarioFachada implements IGestionUsuariosFachada {

    private final ControlGestionUsuarios control;

    public GestionUsuarioFachada() {
        this.control = new ControlGestionUsuarios();
    }

    // --- Método que regresa el usuario con la sesion activa --- 
    @Override
    public UsuarioDTO obtenerUsuarioActivo() {
        return control.getUsuarioActivo();
    }

    @Override
    public List<ReservacionDTO> obtenerReservacionesUsuario(String idUsuario) throws GestionUsuarioException {
        return control.obtenerReservacionUsuario(idUsuario);
    }

    @Override
    public boolean restarCreditos(Integer cantidad, String idUsuario) {
        try {
            return control.restarCreditos(cantidad, idUsuario);
        } catch (GestionUsuarioException gue) {
            return false;
        }
    }

    @Override
    public boolean aumentarCreditos(Integer cantidad, String idUsuario) {
        try {
            return control.aumentarCreditos(cantidad, idUsuario);
        } catch (GestionUsuarioException gue) {
            return false;
        }
    }

    @Override
    public String consultarCreditos(String idUsuario) {
        try {
            return control.consultarCreditos(idUsuario);
        } catch (GestionUsuarioException gue) {
            return null;
        }
    }
}
