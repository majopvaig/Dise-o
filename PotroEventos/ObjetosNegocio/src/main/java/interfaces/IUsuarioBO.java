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
}
