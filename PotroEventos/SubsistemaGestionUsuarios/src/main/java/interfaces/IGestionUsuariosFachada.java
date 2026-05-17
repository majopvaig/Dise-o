/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.BoletoDTO;
import dtos.ReservacionDTO;
import dtos.UsuarioDTO;
import excepciones.GestionUsuarioException;
import java.util.List;

/**
 * Interfaz que sirve como puente entre la fachada y la capa de presentación.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public interface IGestionUsuariosFachada {

    public UsuarioDTO obtenerUsuarioActivo();

    // de la majo
    public boolean restarCreditos(Integer cantidad, String idUsuario);
    
    // de la majo
    public boolean aumentarCreditos(Integer cantidad, String idUsuario);
    
    public String consultarCreditos(String idUsuario);

    public List<ReservacionDTO> obtenerReservacionesUsuario(String idUsuario) throws GestionUsuarioException;
}
