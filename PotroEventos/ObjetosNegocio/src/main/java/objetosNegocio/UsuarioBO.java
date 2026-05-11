/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adapters.UsuarioAdapter;
import dtos.LoginDTO;
import dtos.UsuarioDTO;
import interfaces.IUsuarioBO;
import daos.UsuarioDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;

/**
 *
 * @author aaron
 */
public class UsuarioBO implements IUsuarioBO {

    private static UsuarioBO instance;

    private IUsuarioDAO usuarioDAO = UsuarioDAO.getInstance();

    private UsuarioBO() {

    }

    public static UsuarioBO getInstance() {
        if (instance == null) {
            instance = new UsuarioBO();
        }
        return instance;
    }

    @Override
    public UsuarioDTO obtenerUsuario(LoginDTO sesion) throws NegocioException {
        try {
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setCorreo(sesion.getCorreo());
            usuario.setContrasenia(sesion.getContrasenia());

            return UsuarioAdapter.entidadADTO(usuarioDAO.obtenerUsuario(UsuarioAdapter.dtoAEntidad(usuario)));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO dto) throws NegocioException {
        try {
            return UsuarioAdapter.entidadADTO(usuarioDAO.guardarUsuario(UsuarioAdapter.dtoAEntidad(dto)));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public boolean restarCreditos(Integer cantidad, String idUsuario) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean aumentarCreditos(Integer cantidad, String idUsuario) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String consultarCreditos(String idUsuario) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
