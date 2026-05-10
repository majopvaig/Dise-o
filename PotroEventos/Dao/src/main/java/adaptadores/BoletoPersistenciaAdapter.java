/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.AsientoEvento;
import Entitys.Boleto;
import Entitys.ENUMS.EstadoBoleto;
import Entitys.Evento;
import daos.AsientoEventoDAO;
import daos.EventoDAO;
import entidadesmongo.BoletoMongoEntidad;
import entidadesresumenmongo.AsientoEventoResumenMongo;
import entidadesresumenmongo.EventoResumenMongo;
import excepciones.PersistenciaException;
import interfaces.IAsientoEventoDAO;
import interfaces.IEventoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class BoletoPersistenciaAdapter {
    
    private static IEventoDAO eventoDAO = EventoDAO.getInstance();
    private static IAsientoEventoDAO asientoEventoDAO = AsientoEventoDAO.getInstancia();
    
    public static BoletoMongoEntidad convertirAMongo(Boleto dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        BoletoMongoEntidad mongo = new BoletoMongoEntidad();
        
        mongo.setCodigoQR(dominio.getCodigoQR());
        mongo.setPrecio(dominio.getPrecio());
        mongo.setEstado(dominio.getEstadoBoleto().name());
        
        EventoResumenMongo e = new EventoResumenMongo(
                convertirStringAObjectId(dominio.getEvento().getIdEvento()), 
                dominio.getEvento().getNombreEvento(), 
                dominio.getEvento().getFechaHora());
        
        mongo.setEvento(e);
        
        if (dominio.getAsiento() != null) {
            AsientoEventoResumenMongo a = new AsientoEventoResumenMongo(
                    convertirStringAObjectId(dominio.getAsiento().getIdAsientoEvento()),
                    dominio.getAsiento().getAsiento().getFila(),
                    dominio.getAsiento().getAsiento().getNumero(),
                    dominio.getAsiento().getAsiento().getSeccion().getNombre());            
            
            mongo.setAsiento(a);
        } else {
            mongo.setAsiento(null);
        }
        
        return mongo;
    }
    
    public static Boleto convertirADominio(BoletoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Boleto dominio = new Boleto();
        
        dominio.setCodigoQR(mongo.getCodigoQR());
        dominio.setPrecio(mongo.getPrecio());
        dominio.setEstadoBoleto(EstadoBoleto.valueOf(mongo.getEstado()));
        
        Evento e = eventoDAO.buscarPorId(mongo.getEvento().getIdComoTexto());
        if(e != null){
            dominio.setEvento(e);
        }
        
        if (mongo.getAsiento() != null) {
            AsientoEvento a = asientoEventoDAO.consultarPorId(mongo.getAsiento().getIdComoTexto());
            if (a != null) {
                dominio.setAsiento(a);
            }
        } else {
            mongo.setAsiento(null);
        }
        
        return dominio;
    }
    
    public static List<Boleto> convertirListaADominio(List<BoletoMongoEntidad> lista) throws PersistenciaException {
        List<Boleto> boletos = new ArrayList<>();
        
        if(lista == null){
            return boletos;
        }
        
        for(BoletoMongoEntidad mongo : lista){
            boletos.add(convertirADominio(mongo));
        }
        
        return boletos;
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
