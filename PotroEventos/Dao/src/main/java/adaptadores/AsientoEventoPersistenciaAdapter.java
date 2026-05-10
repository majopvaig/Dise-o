/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Asiento;
import Entitys.AsientoEvento;
import Entitys.ENUMS.EstadoAsiento;
import Entitys.Evento;
import daos.AsientoDAO;
import daos.EventoDAO;
import entidadesmongo.AsientoEventoMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IAsientoDAO;
import interfaces.IEventoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class AsientoEventoPersistenciaAdapter {
    
    private static IAsientoDAO asientoDAO = AsientoDAO.getInstance();
    private static IEventoDAO eventoDAO = EventoDAO.getInstance();
 
    public static AsientoEventoMongoEntidad convertirAMongo(AsientoEvento dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        AsientoEventoMongoEntidad mongo = new AsientoEventoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdAsientoEvento()));
        mongo.setPrecio(dominio.getPrecio());
        mongo.setEstado(dominio.getEstadoAsiento().name());
        mongo.setAsiento(convertirStringAObjectId(dominio.getAsiento().getIdAsiento()));
        mongo.setEvento(convertirStringAObjectId(dominio.getEvento().getIdEvento()));
        
        return mongo;
    }
    
    public static AsientoEvento convertirADominio(AsientoEventoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        AsientoEvento dominio = new AsientoEvento();
        
        dominio.setIdAsientoEvento(mongo.getIdComoTexto());
        dominio.setPrecio(mongo.getPrecio());
        dominio.setEstadoAsiento(EstadoAsiento.valueOf(mongo.getEstado()));
        
        Asiento asiento = asientoDAO.consultarPorID(mongo.getAsientoComoTexto());
        if(asiento != null){
            dominio.setAsiento(asiento);
        }
        
        Evento evento = eventoDAO.buscarPorId(mongo.getEventoComoTexto());
        if(evento != null){
            dominio.setEvento(evento);
        }    
        
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
