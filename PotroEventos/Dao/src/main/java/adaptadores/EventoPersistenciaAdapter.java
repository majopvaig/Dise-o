/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Categoria;
import Entitys.ENUMS.EstadoEvento;
import Entitys.ENUMS.TipoEventoP;
import Entitys.Evento;
import Entitys.Ubicacion;
import daos.CategoriaDAO;
import daos.UbicacionDAO;
import entidadesmongo.EventoMongoEntidad;
import entidadesresumenmongo.CategoriaResumenMongo;
import entidadesresumenmongo.UbicacionResumenMongo;
import excepciones.PersistenciaException;
import interfaces.ICategoriaDAO;
import interfaces.IUbicacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class EventoPersistenciaAdapter {
    
    private static ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    private static IUbicacionDAO ubicacionDAO = UbicacionDAO.getInstance();
    
    public static EventoMongoEntidad convertirAMongo(Evento evento) throws PersistenciaException {
        if(evento == null){
            return null;
        }
        
        EventoMongoEntidad mongo = new EventoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(evento.getIdEvento()));
        
        mongo.setCategoria(
                new CategoriaResumenMongo(
                        convertirStringAObjectId(evento.getCategoriaEvento().getId()), 
                        evento.getCategoriaEvento().getNombre().name()));
        
        mongo.setNombre(evento.getNombreEvento());
        mongo.setInformacion(evento.getInformacionEvento());
        mongo.setFechaHora(evento.getFechaHora());
        
        mongo.setUbicacion(
                new UbicacionResumenMongo(
                        convertirStringAObjectId(evento.getUbicacion().getIdUbicacion()), 
                        evento.getUbicacion().getNombre()));
        
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
        
        Categoria categoria = categoriaDAO.consultarPorId(mongo.getCategoria().getIdComoTexto());
        if(categoria != null){
            dominio.setCategoriaEvento(categoria);
        }
        
        dominio.setNombreEvento(mongo.getNombre());
        dominio.setInformacionEvento(mongo.getInformacion());
        dominio.setFechaHora(mongo.getFechaHora());
        
        Ubicacion ubicacion = ubicacionDAO.consultarPorID(mongo.getUbicacion().getIdComoTexto());
        if(ubicacion != null){
            dominio.setUbicacion(ubicacion);
        }

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
