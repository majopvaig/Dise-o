package daos;

import Entitys.AsientoEvento;
import Entitys.ENUMS.EstadoAsiento;
import adaptadores.AsientoEventoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidadesmongo.AsientoEventoMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IAsientoEventoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * DAO mock para la gestión de asientos por evento.
 *
 * Esta implementación utiliza una lista en memoria a nivel de clase para
 * facilitar pruebas unitarias y simulaciones sin necesidad de base de datos
 * real.
 *
 * Permite consultar los asientos de un evento y reservar un asiento únicamente
 * si aún se encuentra disponible.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoEventoDAO implements IAsientoEventoDAO {

    private static AsientoEventoDAO instancia;

    /**
     * Lista mock a nivel de clase para persistencia en memoria. Esto permite
     * que las pruebas mantengan estado entre llamadas.
     */
    private final MongoCollection<AsientoEventoMongoEntidad> coleccionAsientosEventos;

    private AsientoEventoDAO() {
        this.coleccionAsientosEventos = ConexionMongo.obtenerColeccionAsientosEvento();
    }

    public static AsientoEventoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AsientoEventoDAO();
        }
        return instancia;
    }

    @Override
    public List<AsientoEvento> buscarPorEvento(String idEvento) throws PersistenciaException {
        try{
            List<AsientoEventoMongoEntidad> asientos = coleccionAsientosEventos
                    .find(eq("evento", new ObjectId(idEvento)))
                    .into(new ArrayList<>());
            return AsientoEventoPersistenciaAdapter.convertirListaADominio(asientos);
        } catch(MongoException me){
            throw new PersistenciaException("No fue posible consultar los asientos del evento.");
        }

    }

    @Override
    public boolean reservarAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEventoMongoEntidad asiento = this.coleccionAsientosEventos
                    .find(eq("_id", new ObjectId(idAsiento)))
                    .first();
            
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstado(EstadoAsiento.RESERVADO.name());

            UpdateResult resultado = this.coleccionAsientosEventos
                    .replaceOne(eq("_id", new ObjectId(asiento.getIdComoTexto())), asiento);
            
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible reservar el asiento");
        }
    }

    @Override
    public boolean liberarAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEventoMongoEntidad asiento = this.coleccionAsientosEventos
                    .find(eq("_id", new ObjectId(idAsiento)))
                    .first();
            
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstado(EstadoAsiento.DISPONIBLE.name());

            UpdateResult resultado = this.coleccionAsientosEventos.
                    replaceOne(eq("_id", new ObjectId(asiento.getIdComoTexto())), asiento);
            
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible liberar el asiento");
        }
    }

    @Override
    public boolean venderAsiento(String idAsiento) throws PersistenciaException {
        try {
            AsientoEventoMongoEntidad asiento = this.coleccionAsientosEventos
                    .find(eq("_id", new ObjectId(idAsiento)))
                    .first();
            
            if (asiento == null) {
                throw new PersistenciaException("AsientoEvento no encontrado");
            }

            asiento.setEstado(EstadoAsiento.VENDIDO.name());

            UpdateResult resultado = this.coleccionAsientosEventos.
                    replaceOne(eq("_id", new ObjectId(asiento.getIdComoTexto())), asiento);
            
            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el asiento");
            }
            return true;

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible vender el asiento");
        }
    }

    @Override
    public AsientoEvento consultarPorId(String idAsiento) throws PersistenciaException {
        try{
            AsientoEventoMongoEntidad seccion = coleccionAsientosEventos
                    .find(eq("_id", new ObjectId(idAsiento)))
                    .first();
            return AsientoEventoPersistenciaAdapter.convertirADominio(seccion);
        } catch(MongoException me){
            throw new PersistenciaException("No fue posible obtener el asiento del evento.");
        }
    }

}
