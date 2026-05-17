/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dtos.ReembolsoDTO;
import dtos.RefundDTO;

/**
 *
 * @author maria
 */
public class BancoAdapter {
    
    
    public static RefundDTO dtoAInfraestructura(ReembolsoDTO dto){
        if(dto == null){
            return null;
        }
        
        return new RefundDTO(
                dto.getIdOperacion(), 
                dto.getFechaOperacion(), 
                dto.getImporte(), 
                dto.getMetodoPago());
    }
    
    public static ReembolsoDTO infraestructuraADTO(RefundDTO infraestructura){
        if(infraestructura == null){
            return null;
        }
        
        return new ReembolsoDTO(
                infraestructura.getRefundID(), 
                infraestructura.getRefundDate(), 
                infraestructura.getAmountRefunded(), 
                infraestructura.getRefundMethod());
    }
}
