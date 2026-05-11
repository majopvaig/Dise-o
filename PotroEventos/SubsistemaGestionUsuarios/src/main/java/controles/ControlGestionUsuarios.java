package controles;

import dtos.ReservacionDTO;
import dtos.UsuarioDTO;
import excepciones.GestionUsuarioException;
import excepciones.NegocioException;
import interfaces.IReservacionBO;

import interfaces.IUsuarioBO;
import java.util.List;
import objetosNegocio.ReservacionBO;
import objetosNegocio.UsuarioBO;

/**
 * Controlador internod e la clase de gestion de usuarios. Dedicado a mantener
 * activo y desvincular un usuario de la sesión.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class ControlGestionUsuarios {

    // guardar el usuario que inicia sesion;
    private UsuarioDTO usuarioActivo;
    private IReservacionBO reservacionBO;

    // comunicacion con bo
    private IUsuarioBO usuarioBO;

    //singleton
    private static ControlGestionUsuarios instance;

    public ControlGestionUsuarios() {
        this.usuarioBO = UsuarioBO.getInstance();
        this.reservacionBO = ReservacionBO.getInstance();
    }

    public UsuarioDTO asociarUsuario(UsuarioDTO usuario) {
        this.usuarioActivo = usuario;
        return this.usuarioActivo;
    }

    public UsuarioDTO getUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean restarCreditos(Integer cantidad, String idUsuario) throws GestionUsuarioException {
        try {
            return usuarioBO.restarCreditos(cantidad, idUsuario);
        } catch (NegocioException ne) {
            throw new GestionUsuarioException(ne.getMessage());
        }
    }
    
    public boolean aumentarCreditos(Integer cantidad, String idUsuario) throws GestionUsuarioException {
        try{
            return usuarioBO.aumentarCreditos(cantidad, idUsuario);
        } catch(NegocioException ne){
            throw new GestionUsuarioException(ne.getMessage());
        }
    }
    
    public List<ReservacionDTO> obtenerReservacionUsuario(String idUsuario) throws GestionUsuarioException {
        try {
            return reservacionBO.obtenerReservacionesUsuario(idUsuario);
        } catch (NegocioException ex) {
            throw new GestionUsuarioException(ex.getMessage());
        }
    }
    
    public String consultarCreditos(String idUsuario) throws GestionUsuarioException {
        try{
            return usuarioBO.consultarCreditos(idUsuario);
        } catch(NegocioException ne){
            throw new GestionUsuarioException(ne.getMessage());
        }
    }

}
