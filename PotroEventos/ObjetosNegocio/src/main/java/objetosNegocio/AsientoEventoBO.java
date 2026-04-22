/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import dtos.AsientoEventoDTO;
import excepciones.NegocioException;
import interfaces.IAsientoEventoBO;
import java.util.List;

/**
 *
 * @author maria
 */
public class AsientoEventoBO implements IAsientoEventoBO {

    private static AsientoEventoBO instancia;
    
    private AsientoEventoBO(){}
    
    public static AsientoEventoBO getInstance(){
        if(instancia == null){
            instancia = new AsientoEventoBO();
        }
        return instancia;
    }
    
    @Override
    public List<AsientoEventoDTO> consultarEstadosPorEvento(Long idEvento) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
