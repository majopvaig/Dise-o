package daos;

import Entitys.Categoria;
import Entitys.Evento;
import adaptadores.EventoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.inc;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidadesmongo.EventoMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IEventoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación mock de la DAO de Evento. Simula persistencia en memoria
 * utilizando una lista.
 *
 * * @author Kaleb
 */
public class EventoDAO implements IEventoDAO {

    private final MongoCollection<EventoMongoEntidad> coleccionEventos;

    private static EventoDAO instancia;

    public EventoDAO() {
        this.coleccionEventos = ConexionMongo.obtenerColeccionEventos();
    }

    public static EventoDAO getInstance() {
        if (instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
    }

    @Override
    public Evento buscarPorId(String idEvento) throws PersistenciaException {
        try {
            EventoMongoEntidad evento = this.coleccionEventos
                    .find(eq("_id", new ObjectId(idEvento)))
                    .first();

            return EventoPersistenciaAdapter.convertirADominio(evento);

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible buscar el evento");
        }
    }

    @Override
    public List<Evento> buscarTodosCategoria(Categoria categoria) throws PersistenciaException {
        try {
            Bson filtro = Filters.and(
                    Filters.eq("categoria._id", new ObjectId(categoria.getId())),
                    Filters.eq("estado", "ACTIVO"),
                    Filters.ne("disponibilidad", 0),
                    Filters.gt("fechaHora", LocalDateTime.now()));
            
            List<EventoMongoEntidad> eventos = coleccionEventos
                    .find(filtro)
                    .into(new ArrayList<>());
            return EventoPersistenciaAdapter.convetirListaADominio(eventos);
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener los eventos");
        }
    }

    @Override
    public boolean reducirDisponibilidad(String idEvento) throws PersistenciaException {
        if(idEvento == null){
            throw new PersistenciaException("El id del evento es requerido.");
        }
        try{  
            Bson filtro = Filters.and(
                    Filters.eq("_id", new ObjectId(idEvento)), 
                    Filters.ne("disponibilidad", 0));
            
            Bson disminucion = inc("disponibilidad", -1);
            
            UpdateResult resultado = coleccionEventos.updateOne(filtro, disminucion);
            
            return resultado.getModifiedCount() > 0;
            
        } catch(MongoException me){
            throw new PersistenciaException("No fue posible disminuir la capacidad del evento.");
        }
    }

    // lo agregó la majo
    @Override
    public boolean aumentarDisponibilidad(String idEvento) throws PersistenciaException {
        if (idEvento == null) {
            throw new PersistenciaException("El id del evento es requerido.");
        }
        try {
            Bson filtro = Filters.and(
                    Filters.eq("_id", new ObjectId(idEvento)));

            Bson aumento = inc("disponibilidad", +1);

            UpdateResult resultado = coleccionEventos.updateOne(filtro, aumento);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException me) {
            throw new PersistenciaException("No fue posible aumentar la capacidad del evento.");
        }
    }

}
