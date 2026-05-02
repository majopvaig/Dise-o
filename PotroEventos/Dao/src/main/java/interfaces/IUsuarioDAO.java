/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entitys.Usuario;
import java.util.List;

/**
 *
 * @author aaron
 */
public interface IUsuarioDAO {
    
    List<Usuario> obtenerUsuarios();
    
    boolean restarCreditos(Integer cantidad, Long idUsuario);
    
    Usuario obtenerUsuario(Usuario usuario);    
}
