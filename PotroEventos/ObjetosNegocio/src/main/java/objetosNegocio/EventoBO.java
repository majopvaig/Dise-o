package objetosNegocio;

import Entitys.ENUMS.CategoriaEvento;
import Entitys.Categoria;
import adapters.EventoAdapter;
import daos.EventoDAO;
import dtos.CategoriaDTO;
import dtos.EventoDTO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IEventoBO;
import interfaces.IEventoDAO;
import java.util.List;

/**
 * Objeto de negocio para Evento. Implementa patrón Singleton.
 */
public class EventoBO implements IEventoBO {

    private static EventoBO instancia;
    private final IEventoDAO eventoDAO = EventoDAO.getInstance();

    private EventoBO() {

    }

    public static EventoBO getInstance() {
        if (instancia == null) {
            instancia = new EventoBO();
        }
        return instancia;
    }

    @Override
    public EventoDTO guardarEvento(EventoDTO evento) throws NegocioException {
        if (!validarDatos(evento)) {
            throw new NegocioException("Evento inválido.");
        }
        try {
            return EventoAdapter.entidadADTO(eventoDAO.guardar(EventoAdapter.dtoAEntidad(evento)));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<EventoDTO> obtenerEventosPorCategoria(CategoriaDTO categoria) throws NegocioException {
        try {
            return EventoAdapter.listaDTOs(eventoDAO.buscarTodosCategoria(new Categoria(categoria.getIdCategoria(), CategoriaEvento.valueOf(categoria.getNombreCategoria().name()), categoria.getUrlImagen())));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public EventoDTO obtenerEventoPorId(String id) throws NegocioException {
        try {
            return EventoAdapter.entidadADTO(eventoDAO.buscarPorId(id));
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    @Override
    public boolean reducirDisponibilidadEvento(String id) throws NegocioException {
        try{
            return eventoDAO.reducirDisponibilidad(id);
        } catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    public boolean validarDatos(EventoDTO eventoDTO) {
        // 1. Validar que el objeto no sea nulo
        if (eventoDTO == null) {
            return false;
        }

        // 2. Validar Nombre (No nulo, no vacío y aplicar trim/lowercase)
        if (eventoDTO.getNombreEvento() == null || eventoDTO.getNombreEvento().isBlank()) {
            return false;
        }
        // Formateo simple
        eventoDTO.setNombreEvento(eventoDTO.getNombreEvento().trim().toLowerCase());

        // 3. Validar Ubicación
        if (eventoDTO.getUbicacion() == null) {
            return false;
        }
        eventoDTO.setUbicacion(eventoDTO.getUbicacion());

        // 4. Validar Categoría y Estado (Enums)
        if (eventoDTO.getCategoriaEvento() == null || eventoDTO.getEstadoEvento() == null || eventoDTO.getTipoEvento() == null) {
            return false;
        }

        // 5. Validar Fecha (Que no sea nula)
        if (eventoDTO.getFechaHora() == null) {
            return false;
        }

        // 6. Formatear campos opcionales (Información)
        if (eventoDTO.getInformacionEvento() != null) {
            eventoDTO.setInformacionEvento(eventoDTO.getInformacionEvento().trim().toLowerCase());
        }

        if (eventoDTO.getDisponibilidad() == null || eventoDTO.getDisponibilidad() < 0) {
            return false;
        }

        return true; // Si pasó todos los filtros
    }

    @Override
    public boolean aumentarDisponibilidadEvento(String idEvento) throws NegocioException {
        try{
            return eventoDAO.aumentarDisponibilidad(idEvento);
        } catch(PersistenciaException pe){
            throw new NegocioException(pe.getMessage());
        }
    }
}
