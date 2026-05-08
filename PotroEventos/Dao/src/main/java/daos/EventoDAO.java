package daos;

import Entitys.Categoria;
import Entitys.Evento;
import adaptadores.EventoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidadesmongo.EventoMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IEventoDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
            EventoMongoEntidad evento = this.coleccionEventos.find(eq("_id", new ObjectId(idEvento))).first();

            return EventoPersistenciaAdapter.convertirADominio(evento);

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible buscar el evento");
        }
    }

    @Override
    public List<Evento> buscarTodosCategoria(Categoria categoria) throws PersistenciaException {
        try {
            List<EventoMongoEntidad> eventos = coleccionEventos.find(eq("categoria", categoria.getNombre())).into(new ArrayList<>());
            return EventoPersistenciaAdapter.convetirListaADominio(eventos);
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener los eventos");
        }
    }

    @Override
    public Evento guardar(Evento evento) throws PersistenciaException {
        if (evento == null) {
            throw new PersistenciaException("El evento no puede ser null");
        }

        if (evento.getFechaHora() == null) {
            evento.setFechaHora(LocalDateTime.now());
        }

        try {
            EventoMongoEntidad e = EventoPersistenciaAdapter.convertirAMongo(evento);
            InsertOneResult resultado = this.coleccionEventos.insertOne(e);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar.");
            }
            ObjectId idGenerad = resultado.getInsertedId().asObjectId().getValue();
            //String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();

            e.setId(idGenerad);

            return EventoPersistenciaAdapter.convertirADominio(e);

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar el evento");
        }
    }

    @Override
    public Evento actualizarEvento(Evento evento) throws PersistenciaException {
        if (evento == null) {
            throw new PersistenciaException("El evento no puede ser null");
        }

        if (evento.getIdEvento() == null) {
            throw new PersistenciaException("El id del evento es requerido");
        }

        try {
            EventoMongoEntidad e = EventoPersistenciaAdapter.convertirAMongo(evento);
            
            UpdateResult resultado = this.coleccionEventos.replaceOne(eq("_id", new ObjectId(evento.getIdEvento())), e);

            if (resultado.getMatchedCount() == 0) {
                throw new PersistenciaException("No se encontró el evento");
            }

            return EventoPersistenciaAdapter.convertirADominio(e);

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible actualizar el evento");
        }
    }

}
