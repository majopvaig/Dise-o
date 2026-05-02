/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicioSistema;

import Controlador.coordinador.CoordinadorAplicacion;
import Controlador.interfaz.ICoordinadorAplicacion;


/**
 *
 * @author maria
 */
public class InicioPotroEventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        IUsuarioBO bo = UsuarioBO.getInstance();
//        try{
//            bo.asociarUsuario(new UsuarioDTO(1L, "Aslan Jade", "Callenreese", "", "eijimypookie@gmail.com", "eiji4ever", 0));
//        } catch(NegocioException ne){
//            System.out.println("falló agregar el usuario.");
//        }
        ICoordinadorAplicacion inicio = new CoordinadorAplicacion();
        inicio.mostrarInicioSesion();
    }
    
}
