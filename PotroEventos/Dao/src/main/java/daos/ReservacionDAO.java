/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Boleto;
import Entitys.Devolucion;
import Entitys.Reservacion;
import adaptadores.BoletoPersistenciaAdapter;
import adaptadores.ReservacionPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidadesmongo.ReservacionMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IReservacionDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class ReservacionDAO implements IReservacionDAO {
    
    private MongoCollection<ReservacionMongoEntidad> coleccionReservaciones = ConexionMongo.obtenerColeccionReservaciones();
    private static ReservacionDAO instance;
    
    private ReservacionDAO() {
        // esto es para que no se repitan los qrs y su forma de buscarlos sea
        // más rápida. aunq ahora q lo pienso debería ser el token
        coleccionReservaciones
                .createIndex(
                        Indexes.ascending("boleto.codigoQR"), 
                        new IndexOptions().unique(true));
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
            
            ObjectId idGenerado = resultado
                    .getInsertedId()
                    .asObjectId()
                    .getValue();
            //String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            
            r.setId(idGenerado);
            
            return ReservacionPersistenciaAdapter.convertirADominio(r);
            
        } catch (MongoException e) {
            System.out.println("No fue posible guardar la reservación: " + e.getMessage());
            throw new PersistenciaException("No fue posible guardar la reservación: " + e.getMessage());
        }
        
    }
    
    @Override
    public List<Reservacion> obtenerReservacionesUsuario(String idUsuario) throws PersistenciaException {
        try {
            List<ReservacionMongoEntidad> reservaciones = coleccionReservaciones
                    .find(eq("usuario", new ObjectId(idUsuario)))
                    .into(new ArrayList<>());
            return ReservacionPersistenciaAdapter.convertirListaADominio(reservaciones);
        } catch (Exception e) {
            throw new PersistenciaException("No fue posible obtener las reservaciones");
        }
    }

    @Override
    public Boleto obtenerBoleto(String idReservacion) throws PersistenciaException {
        try {
            ReservacionMongoEntidad reservacion = coleccionReservaciones
                    .find(eq("_id", new ObjectId(idReservacion)))
                    .first();

            if (reservacion == null || reservacion.getBoleto() == null) {
                return null;
            }

            return BoletoPersistenciaAdapter.convertirADominio(reservacion.getBoleto());

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener el boleto de la reservación.");
        }
    }

    // lo agregó la majo
//    @Override
//    public boolean agregarDevolucion(String idReservacion, Devolucion devolucion) throws PersistenciaException {
//        try{
//            Bson r = Filters.eq("_id", new ObjectId(idReservacion));
//            Bson campo = Updates.set("devolucion", devolucion);
//            
//            UpdateResult resultado = coleccionReservaciones.updateOne(r, campo);
//            
//            return resultado.getModifiedCount() > 0;
//        } catch(MongoException me){
//            throw new PersistenciaException("No fue posible agregar la devolución a la reservación.");
//        }
//    }

    // lo agregó la majo
    @Override
    public boolean cancelarReservacion(Devolucion devolucion, String idReservacion) throws PersistenciaException {
        try{
            Bson filtro = Filters.eq("_id", new ObjectId(idReservacion));
            Bson actualizacion = Updates.combine(
                    Updates.set("estado", "CANCELADA"),
                    Updates.set("boleto.estado", "CANCELADO"),
                    Updates.set("devoluciom", devolucion));
            
            UpdateResult resultado = coleccionReservaciones.updateOne(filtro, actualizacion);
            
            return resultado.getModifiedCount() > 0;
        } catch(MongoException me){
            throw new PersistenciaException("No fue posible cancelar la reservacón.");
        }
    }
    
}
