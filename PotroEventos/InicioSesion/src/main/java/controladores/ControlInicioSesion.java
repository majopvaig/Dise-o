/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase controlador de inicio de sesion que gestiona el control interno de todo
 * lo que tiene que ver con la gestion de inicio de sesion
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
import dtos.LoginDTO;
import interfaces.IUsuarioBO;
import objetosNegocio.UsuarioBO;

public class ControlInicioSesion {
    
    private List<UsuarioDTO> listaUsuarios = new ArrayList<>();
    
    private static ControlInicioSesion instance;
    
    private UsuarioDTO usuario;
    
    private final IUsuarioBO usuarioBO = UsuarioBO.getInstance();
    
    private ControlInicioSesion() {
        UsuarioDTO prueba = new UsuarioDTO();
        prueba.setCorreo("admin@mail.com");
        prueba.setContrasenia("1234");
        prueba.setNombre("Dayanara");
        prueba.setCreditos(0);
        listaUsuarios.add(prueba);
    }
    
    public static ControlInicioSesion getIntance() {
        if (instance == null) {
            instance = new ControlInicioSesion();
        }
        return instance;
    }

    /**
     *
     * @param login
     * @return
     */
    public UsuarioDTO iniciarSesion(LoginDTO login) {
        return usuarioBO.obtenerUsuario(login);
    }
    
    public UsuarioDTO verificarUsuario(String correo, String contrasenia) {
        if (correo.isEmpty() || contrasenia.isEmpty()) {
            return null;
        }
        return this.iniciarSesion(new LoginDTO(correo, contrasenia));
    }
    
    public void registrarSesion(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
    public void eliminarSesion() {
        this.usuario = null;
    }
    
    public UsuarioDTO obtenerUsuarioActual() {
        return usuario;
    }
}
