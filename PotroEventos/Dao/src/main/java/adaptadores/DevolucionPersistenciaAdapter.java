/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Devolucion;
import Entitys.ENUMS.MotivoDevolucionP;
import Entitys.ENUMS.TipoDevolucionP;
import entidadesmongo.DevolucionMongoEntidad;
import excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public class DevolucionPersistenciaAdapter {
    
    public static DevolucionMongoEntidad convertirAMongo(Devolucion dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        return new DevolucionMongoEntidad(
                dominio.getMotivo().name(), 
                dominio.getDescripcion(), 
                dominio.getTipo().name(), 
                dominio.getFechaHoraDevolucion(), 
                ReembolsoPersistenciaAdapter.convertirAMongo(dominio.getReembolso()));
    }
    
    public static Devolucion convertirADominio(DevolucionMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        return new Devolucion(
                MotivoDevolucionP.valueOf(mongo.getMotivo()), 
                mongo.getDescripcion(), 
                TipoDevolucionP.valueOf(mongo.getTipo()), 
                mongo.getFechaHoraDevolucion(), 
                ReembolsoPersistenciaAdapter.convertirADominio(mongo.getReembolso()));
    }
}
