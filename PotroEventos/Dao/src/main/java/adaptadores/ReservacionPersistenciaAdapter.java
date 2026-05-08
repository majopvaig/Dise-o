/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.ENUMS.ReservacionEstado;
import Entitys.Reservacion;
import entidadesmongo.ReservacionMongoEntidad;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionPersistenciaAdapter {
    
    public static ReservacionMongoEntidad convertirAMongo(Reservacion dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        ReservacionMongoEntidad mongo = new ReservacionMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdReservacion()));
        mongo.setTotal(dominio.getTotal());
        mongo.setBoleto(BoletoPersistenciaAdapter.convertirAMongo(dominio.getBoleto()));
        mongo.setUsuario(UsuarioPersistenciaAdapter.convertirAMongo(dominio.getUsuario()));
        if(dominio.getFechaHora() == null){
            mongo.setFechaRegistro(LocalDateTime.now());
        } else {
            mongo.setFechaRegistro(dominio.getFechaHora());
        }
        mongo.setEstado(dominio.getEstado().name());
        
        return mongo;
    }
    
    public static Reservacion convertirADominio(ReservacionMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Reservacion dominio = new Reservacion();
        
        dominio.setIdReservacion(mongo.getIdComoTexto());
        dominio.setTotal(mongo.getTotal());
        dominio.setBoleto(BoletoPersistenciaAdapter.convertirADominio(mongo.getBoleto()));
        dominio.setUsuario(UsuarioPersistenciaAdapter.convertirADominio(mongo.getUsuario()));
        dominio.setFechaHora(mongo.getFechaRegistro());
        dominio.setEstado(ReservacionEstado.valueOf(mongo.getEstado()));
        
        return dominio;
    }
    
    public static List<Reservacion> convertirListaADominio(List<ReservacionMongoEntidad> lista) throws PersistenciaException {
        List<Reservacion> reservaciones = new ArrayList<>();
        
        if(lista == null){
            return null;
        }
        
        for(ReservacionMongoEntidad mongo : lista){
            reservaciones.add(convertirADominio(mongo));
        }
        
        return reservaciones;
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
