/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import Entitys.Boleto;
import Entitys.ENUMS.ReservacionEstado;
import Entitys.Reservacion;
import Entitys.Usuario;
import daos.ReservacionDAO;
import daos.UsuarioDAO;
import entidadesmongo.ReservacionMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IReservacionDAO;
import interfaces.IUsuarioDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionPersistenciaAdapter {
    
    public static IReservacionDAO reservacionDAO = ReservacionDAO.getInstance();
    public static IUsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
    
    public static ReservacionMongoEntidad convertirAMongo(Reservacion dominio) throws PersistenciaException {
        if(dominio == null){
            return null;
        }
        
        ReservacionMongoEntidad mongo = new ReservacionMongoEntidad();
        
        mongo.setId(convertirStringAObjectId(dominio.getIdReservacion()));
        mongo.setTotal(dominio.getTotal());
        mongo.setBoleto(BoletoPersistenciaAdapter.convertirAMongo(dominio.getBoleto()));
        mongo.setCobro(dominio.getCobro());
        mongo.setUsuario(convertirStringAObjectId(dominio.getUsuario().getIdUsuario()));
        
        if(dominio.getFechaHora() == null){
            mongo.setFechaRegistro(LocalDateTime.now());
        } else {
            mongo.setFechaRegistro(dominio.getFechaHora());
        }
        mongo.setEstado(dominio.getEstado().name());
        
        if(dominio.getDevolucion() != null){
            mongo.setDevolucion(DevolucionPersistenciaAdapter.convertirAMongo(dominio.getDevolucion()));
        }
        
        return mongo;
    }
    
    public static Reservacion convertirADominio(ReservacionMongoEntidad mongo) throws PersistenciaException {
        if(mongo == null){
            return null;
        }
        
        Reservacion dominio = new Reservacion();
        
        dominio.setIdReservacion(mongo.getIdComoTexto());
        dominio.setTotal(mongo.getTotal());
        
        Boleto b = reservacionDAO.obtenerBoleto(mongo.getIdComoTexto());
        if(b != null){
            dominio.setBoleto(b);
        }
        
        dominio.setCobro(mongo.getCobro());
        
        Usuario u = usuarioDAO.obtenerPorId(mongo.getUsuarioComoTexto());
        if(u != null){
            dominio.setUsuario(u);
        }
        
        dominio.setFechaHora(mongo.getFechaRegistro());
        dominio.setEstado(ReservacionEstado.valueOf(mongo.getEstado()));
        
        if(mongo.getDevolucion() != null){
            dominio.setDevolucion(DevolucionPersistenciaAdapter.convertirADominio(mongo.getDevolucion()));
        } 
        
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
