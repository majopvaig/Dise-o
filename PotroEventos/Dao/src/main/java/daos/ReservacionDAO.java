/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Reservacion;
import adaptadores.ReservacionPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import entidadesmongo.ReservacionMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IReservacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionDAO implements IReservacionDAO {
    
    private MongoCollection<ReservacionMongoEntidad> coleccionReservaciones = ConexionMongo.obtenerColeccionReservaciones();
    private static ReservacionDAO instance;
    
    private ReservacionDAO() {
    }
    
    public static ReservacionDAO getInstance() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }
    
    @Override
    public Reservacion guardarReservacion(Reservacion reservacion) throws PersistenciaException {
        if (reservacion == null) {
            throw new PersistenciaException("La reservacion no puede ser nula.");
        }
        
        try {
            ReservacionMongoEntidad r = ReservacionPersistenciaAdapter.convertirAMongo(reservacion);
            
            InsertOneResult resultado = this.coleccionReservaciones.insertOne(r);
            
            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar.");
            }
            
            ObjectId idGenerado = resultado.getInsertedId().asObjectId().getValue();
            //String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            
            r.setId(idGenerado);
            
            return ReservacionPersistenciaAdapter.convertirADominio(r);
            
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar la reservación.");
        }
        
    }
    
    @Override
    public List<Reservacion> obtenerReservacionesUsuario(String idUsuario) throws PersistenciaException {
        try {
            List<ReservacionMongoEntidad> reservaciones = coleccionReservaciones.find(eq("idUsuario", new ObjectId(idUsuario))).into(new ArrayList<>());
            return ReservacionPersistenciaAdapter.convertirListaADominio(reservaciones);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible obtener las reservaciones");
        }
    }
    
}
