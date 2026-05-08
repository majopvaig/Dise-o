/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Asiento;
import Entitys.AsientoEvento;
import Entitys.ENUMS.EstadoAsiento;
import entidadesmongo.AsientoEventoMongoEntidad;
import entidadesmongo.AsientoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class AsientoEventoPersistenciaAdapter {
 
    public static AsientoEventoMongoEntidad convertirAMongo(AsientoEvento dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        AsientoEventoMongoEntidad mongo = new AsientoEventoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdAsientoEvento()));
        mongo.setReservacion(ReservacionPersistenciaAdapter.convertirAMongo(dominio.getReservacion()));
        mongo.setEstado(dominio.getEstadoAsiento().name());
        mongo.setAsiento(AsientoPersistenciaAdapter.convertirAMongo(dominio.getAsiento()));
        mongo.setEvento(EventoPersistenciaAdapter.convertirAMongo(dominio.getEvento()));
        
        return mongo;
    }
    
    public static AsientoEvento convertirADominio(AsientoEventoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        AsientoEvento dominio = new AsientoEvento();
        
        dominio.setIdAsientoEvento(mongo.getIdComoTexto());
        dominio.setReservacion(ReservacionPersistenciaAdapter.convertirADominio(mongo.getReservacion()));
        dominio.setEstadoAsiento(EstadoAsiento.valueOf(mongo.getEstado()));
        dominio.setAsiento(AsientoPersistenciaAdapter.convertirADominio(mongo.getAsiento()));
        dominio.setEvento(EventoPersistenciaAdapter.convertirADominio(mongo.getEvento()));
        
        return dominio;
    }
    
    public static List<AsientoEvento> convertirListaADominio(List<AsientoEventoMongoEntidad> lista) throws PersistenciaException {
        List<AsientoEvento> asientos = new ArrayList<>();
        
        if(lista == null){
            return asientos;
        }
        
        for(AsientoEventoMongoEntidad mongo : lista){
            asientos.add(convertirADominio(mongo));
        }
        
        return asientos;
    }
    
    private static ObjectId convertirStringAObjectId(String id) throws PersistenciaException {
        if (id == null || id.isBlank()) {
            return null;
        }
        if (!ObjectId.isValid(id)) {
            throw new PersistenciaException(
                    "El id recibido no tiene formato válido de ObjectId."
            );
        }
        return new ObjectId(id);
    }
}
