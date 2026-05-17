package interfaces;

import dtos.LoginDTO;
import dtos.UsuarioDTO;
import excepciones.NegocioException;

/**
 *
 * @author aaron
 */
public interface IUsuarioBO {

    public UsuarioDTO obtenerUsuario(LoginDTO sesion) throws NegocioException;

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario) throws NegocioException;
    
    // esto lo agregó la majo
    public boolean restarCreditos(Integer cantidad, String idUsuario) throws NegocioException;
    
    // esto lo agregó la majo
    public boolean aumentarCreditos(Integer cantidad, String idUsuario) throws NegocioException;
    
    // esto lo agregó la majo
    public String consultarCreditos(String idUsuario) throws NegocioException;
}
