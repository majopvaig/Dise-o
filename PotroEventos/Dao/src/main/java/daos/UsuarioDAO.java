/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import Entitys.Usuario;
import interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aaron
 */
public class UsuarioDAO implements IUsuarioDAO{

    private static UsuarioDAO instance;

    private UsuarioDAO() {
    }
    
    public static UsuarioDAO getInstance(){
        if(instance == null){
            instance = new UsuarioDAO();
        }
        return instance;
    }
    
    @Override
    public boolean restarCreditos(Integer cantidad, Long idUsuario){
        if(idUsuario == null){
            return false;
        }
        for(Usuario u : obtenerUsuarios()){
            if(u.getIdUsuario().equals(idUsuario)){
                u.setCreditos(u.getCreditos() - cantidad);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<Usuario> obtenerUsuarios() {
        // craecion de lista manual para que el sistema pueda cargar informacion
        List<Usuario> usuarios = new ArrayList<>();
        
        // usuario 1
        Usuario usuario1 = new Usuario();
        usuario1.setIdUsuario(1L);
        usuario1.setApellidoMaterno("Gaspar");
        usuario1.setApellidoPaterno("Leyva");
        usuario1.setNombre("Andre");
        usuario1.setCorreo("andre1@gmail.com");
        usuario1.setContrasenia("12");

        // usuario 2
        Usuario usuario2 = new Usuario();
        usuario1.setIdUsuario(2L);
        usuario1.setApellidoMaterno("Vega");
        usuario1.setApellidoPaterno("Luna");
        usuario1.setNombre("Sisi");
        usuario1.setCorreo("sisi1@gmail.com");
        usuario1.setContrasenia("123");
        
        // usuario 3
        Usuario usuario3 = new Usuario();
        usuario1.setIdUsuario(1L);
        usuario1.setApellidoMaterno("Marquez");
        usuario1.setApellidoPaterno("esparza");
        usuario1.setNombre("miguel");
        usuario1.setCorreo("miguel1@gmail.com");
        usuario1.setContrasenia("1234");
        
        // agregar
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        
        return usuarios;
    }
    
}
