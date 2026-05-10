package interfaces;

import Entitys.Categoria;
import Entitys.Evento;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz de acceso a datos para la entidad Evento.
 *
 * Define operaciones CRUD utilizando entidades del dominio.
 *
 * @author Kaleb
 */
public interface IEventoDAO {

    Evento buscarPorId(String idEvento) throws PersistenciaException;

    List<Evento> buscarTodosCategoria(Categoria categoria) throws PersistenciaException;

    Evento guardar(Evento evento) throws PersistenciaException;

    Evento actualizarEvento(Evento evento) throws PersistenciaException;
    
    boolean reducirDisponibilidad(String idEvento) throws PersistenciaException;
}
