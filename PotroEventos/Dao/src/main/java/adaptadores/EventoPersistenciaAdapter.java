/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.ENUMS.EstadoEvento;
import Entitys.ENUMS.TipoEventoP;
import Entitys.Evento;
import entidadesmongo.EventoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class EventoPersistenciaAdapter {
    
    public static EventoMongoEntidad convertirAMongo(Evento evento) throws PersistenciaException {
        if(evento == null){
            return null;
        }
        
        EventoMongoEntidad mongo = new EventoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(evento.getIdEvento()));
        mongo.setCategoria(CategoriaPersistenciaAdapter.convetirAMongo(evento.getCategoriaEvento()));
        mongo.setNombre(evento.getNombreEvento());
        mongo.setInformacion(evento.getInformacionEvento());
        mongo.setFechaHora(evento.getFechaHora());
        mongo.setUbicacion(UbicacionPersistenciaAdapter.convetirAMongo(evento.getUbicacion()));
        mongo.setEstado(evento.getEstadoEvento().name());
        mongo.setUrlImagen(evento.getUrlImagen());
        mongo.setGratuito(evento.isGratuito());
        mongo.setTipo(evento.getTipoEvento().name());
        mongo.setDisponibilidad(evento.getDisponibilidad());
        
        return mongo;
    }
    
    public static Evento convertirADominio(EventoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Evento dominio = new Evento();
        dominio.setIdEvento(mongo.getIdComoTexto());
        dominio.setCategoriaEvento(CategoriaPersistenciaAdapter.convertirADominio(mongo.getCategoria()));
        dominio.setNombreEvento(mongo.getNombre());
        dominio.setInformacionEvento(mongo.getInformacion());
        dominio.setFechaHora(mongo.getFechaHora());
        dominio.setUbicacion(UbicacionPersistenciaAdapter.convertirADominio(mongo.getUbicacion()));
        dominio.setEstadoEvento(EstadoEvento.valueOf(mongo.getEstado()));
        dominio.setUrlImagen(mongo.getUrlImagen());
        dominio.setGratuito(mongo.isGratuito());
        dominio.setTipoEvento(TipoEventoP.valueOf(mongo.getTipo()));
        dominio.setDisponibilidad(mongo.getDisponibilidad());
        
        return dominio;
    }
    
    public static List<Evento> convetirListaADominio(List<EventoMongoEntidad> lista) throws PersistenciaException {
        List<Evento> eventos = new ArrayList<>();
        
        if(lista == null){
            return eventos;
        }
        
        for(EventoMongoEntidad mongo: lista){
            eventos.add(convertirADominio(mongo));
        }
        
        return eventos;
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
