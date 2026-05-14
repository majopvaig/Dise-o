/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import Entitys.Devolucion;
import Entitys.ENUMS.MotivoDevolucionP;
import Entitys.ENUMS.TipoDevolucionP;
import dtos.DevolucionDTO;
import dtos.ENUMS.MotivoDevolucionN;
import dtos.ENUMS.TipoDevolucionN;
import java.time.LocalDateTime;

/**
 *
 * @author maria
 */
public class DevolucionAdapter {
    
    public static DevolucionDTO convertirADTO(Devolucion entidad){
        if(entidad == null){
            return null;
        }
        
        return new DevolucionDTO(
                MotivoDevolucionN.valueOf(entidad.getMotivo().name()), 
                entidad.getDescripcion(), 
                TipoDevolucionN.valueOf(entidad.getTipo().name()), 
                entidad.getFechaHoraDevolucion(), 
                ReembolsoAdapter.convertirADTO(entidad.getReembolso()));
    }
    
    public static Devolucion convertirAEntidad(DevolucionDTO dto){
        if(dto == null){
            return null;
        }
        
        return new Devolucion(
                MotivoDevolucionP.valueOf(dto.getMotivo().name()), 
                dto.getDescripcion(), 
                TipoDevolucionP.valueOf(dto.getTipo().name()), 
                dto.getFechaHoraDevolucion(), 
                ReembolsoAdapter.convertirAEntidad(dto.getReembolso()));
    }
}
