/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import dtos.AsientoDTO;
import excepciones.NegocioException;
import interfaces.IAsientoBO;
import java.util.List;

/**
 *
 * @author maria
 */
public class AsientoBO implements IAsientoBO {

    private static AsientoBO instancia;
    
    private AsientoBO(){}
    
    public static AsientoBO getInstance(){
        if(instancia == null){
            instancia = new AsientoBO();
        }
        return instancia;
    }
    
    @Override
    public List<AsientoDTO> consultarTodosLosAsientos() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
