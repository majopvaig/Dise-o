/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Seccion;
import entidadesmongo.SeccionMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class SeccionPersistenciaAdapter {
    
    public static SeccionMongoEntidad convertirAMongo(Seccion dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        SeccionMongoEntidad mongo = new SeccionMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdSeccion()));
        mongo.setNombre(dominio.getNombre());
        mongo.setCapacidad(dominio.getCapacidad());
        mongo.setPrecioBase(dominio.getPrecioBase());
        
        return mongo;
    }
    
    public static Seccion convertirADominio(SeccionMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Seccion dominio = new Seccion();
        
        dominio.setIdSeccion(mongo.getIdComoTexto());
        dominio.setNombre(mongo.getNombre());
        dominio.setCapacidad(mongo.getCapacidad());
        dominio.setPrecioBase(mongo.getPrecioBase());
        
        return dominio;
    }
    
    public static List<Seccion> convertirListaADominio(List<SeccionMongoEntidad> lista) throws PersistenciaException {
        List<Seccion> secciones = new ArrayList<>();
        
        if(lista == null){
            return secciones;
        }
        
        for(SeccionMongoEntidad mongo : lista){
            secciones.add(convertirADominio(mongo));
        }
        
        return secciones;
    }
    
    public static List<SeccionMongoEntidad> convertirListaAMongo(List<Seccion> lista) throws PersistenciaException {
        List<SeccionMongoEntidad> secciones = new ArrayList<>();
        
        if(lista == null){
            return secciones;
        }
        
        for(Seccion dominio : lista){
            secciones.add(convertirAMongo(dominio));
        }
        
        return secciones;
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
