/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Categoria;
import Entitys.ENUMS.CategoriaEvento;
import entidadesmongo.CategoriaMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class CategoriaPersistenciaAdapter {
    
    public static CategoriaMongoEntidad convetirAMongo(Categoria dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        CategoriaMongoEntidad mongo = new CategoriaMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getId()));
        mongo.setNombre(dominio.getNombre().name());
        mongo.setUrlImagen(dominio.getUrlImagen());
        
        return mongo;
    }
    
    public static Categoria convertirADominio(CategoriaMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Categoria dominio = new Categoria();
        
        dominio.setId(mongo.getIdComoTexto());
        dominio.setNombre(CategoriaEvento.valueOf(mongo.getNombre()));
        dominio.setUrlImagen(mongo.getUrlImagen());
        
        return dominio;
    }
    
    public static List<Categoria> convertirListaADominio(List<CategoriaMongoEntidad> lista) throws PersistenciaException {
        List<Categoria> categorias = new ArrayList<>();
        
        if(lista == null){
            return categorias;
        }
        
        for(CategoriaMongoEntidad mongo : lista){
            categorias.add(convertirADominio(mongo));
        }
        
        return categorias;
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
