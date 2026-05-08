/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Boleto;
import Entitys.ENUMS.EstadoBoleto;
import entidadesmongo.BoletoMongoEntidad;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class BoletoPersistenciaAdapter {
    
    public static BoletoMongoEntidad convertirAMongo(Boleto dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        BoletoMongoEntidad mongo = new BoletoMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdBoleto()));
        mongo.setCodigoQR(dominio.getCodigoQR());
        mongo.setPrecio(dominio.getPrecio());
        mongo.setEstado(dominio.getEstadoBoleto().name());
        mongo.setEvento(EventoPersistenciaAdapter.convertirAMongo(dominio.getEvento()));
        mongo.setAsiento(AsientoEventoPersistenciaAdapter.convertirAMongo(dominio.getAsiento()));
        
        return mongo;
    }
    
    public static Boleto convertirADominio(BoletoMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Boleto dominio = new Boleto();
        
        dominio.setIdBoleto(mongo.getIdComoTexto());
        dominio.setCodigoQR(mongo.getCodigoQR());
        dominio.setPrecio(mongo.getPrecio());
        dominio.setEstadoBoleto(EstadoBoleto.valueOf(mongo.getEstado()));
        dominio.setEvento(EventoPersistenciaAdapter.convertirADominio(mongo.getEvento()));
        dominio.setAsiento(AsientoEventoPersistenciaAdapter.convertirADominio(mongo.getAsiento()));
        
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
