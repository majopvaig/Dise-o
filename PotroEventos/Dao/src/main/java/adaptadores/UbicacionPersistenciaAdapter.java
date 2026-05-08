/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.ENUMS.TipoUbicacionP;
import Entitys.Ubicacion;
import entidadesmongo.UbicacionMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class UbicacionPersistenciaAdapter {
    
    public static UbicacionMongoEntidad convetirAMongo(Ubicacion ubicacion) throws PersistenciaException {
        if(ubicacion == null){
            return null;
        }
        
        UbicacionMongoEntidad mongo = new UbicacionMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(ubicacion.getIdUbicacion()));
        mongo.setNombre(ubicacion.getNombre());
        mongo.setCapacidad(ubicacion.getCapacidad());
        mongo.setTipoUbicacion(ubicacion.getTipo().name());
        
        return mongo;
    }
    
    public static Ubicacion convertirADominio(UbicacionMongoEntidad ubicacion) throws PersistenciaException {
        if(ubicacion == null){
            return null;
        }
        
        Ubicacion dominio = new Ubicacion();
        
        dominio.setIdUbicacion(ubicacion.getIdComoTexto());
        dominio.setNombre(ubicacion.getNombre());
        dominio.setCapacidad(ubicacion.getCapacidad());
        dominio.setTipo(TipoUbicacionP.valueOf(ubicacion.getTipoUbicacion()));
        
        return dominio;
    }
    
    /*
    lo puse pero según yo nunca se usa (?)
    */
    public static List<Ubicacion> convertirListaADominio(List<UbicacionMongoEntidad> lista) throws PersistenciaException {
        List<Ubicacion> ubicaciones = new ArrayList<>();
        
        if(lista == null){
            return ubicaciones;
        }
        
        for(UbicacionMongoEntidad mongo : lista){
            ubicaciones.add(convertirADominio(mongo));
        }
        
        return ubicaciones;
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
