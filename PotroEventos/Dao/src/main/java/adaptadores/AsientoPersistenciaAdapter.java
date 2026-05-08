/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Asiento;
import entidadesmongo.AsientoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class AsientoPersistenciaAdapter {
    
    public static AsientoMongoEntidad convertirAMongo(Asiento dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        AsientoMongoEntidad mongo = new AsientoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdAsiento()));
        mongo.setFila(dominio.getFila());
        mongo.setNumero(dominio.getNumero());
        mongo.setSeccion(SeccionPersistenciaAdapter.convertirAMongo(dominio.getSeccion()));
        
        return mongo;
    }
    
    public static Asiento convertirADominio(AsientoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Asiento dominio = new Asiento();
        
        dominio.setIdAsiento(mongo.getIdComoTexto());
        dominio.setFila(mongo.getFila());
        dominio.setNumero(mongo.getNumero());
        dominio.setSeccion(SeccionPersistenciaAdapter.convertirADominio(mongo.getSeccion()));
        
        return dominio;
    }
    
    public static List<Asiento> convertirListaADominio(List<AsientoMongoEntidad> lista) throws PersistenciaException {
        List<Asiento> asientos = new ArrayList<>();
        
        if(lista == null){
            return asientos;
        }
        
        for(AsientoMongoEntidad mongo : lista){
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
