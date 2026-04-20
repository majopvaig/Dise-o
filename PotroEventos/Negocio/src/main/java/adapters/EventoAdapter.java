package adapters;

import Entitys.ENUMS.CategoriaEvento;
import Entitys.ENUMS.EstadoEvento;
import Entitys.Evento;
import dtos.ENUMS.CategoriaEventoDTO;
import dtos.ENUMS.EstadoEventoDTO;
import dtos.EventoDTO;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class EventoAdapter {

    public EventoDTO entidadADTO(Evento evento) {

        if (evento == null) {
            return null;
        }

        return new EventoDTO(
                evento.getIdEvento(),
                convertirCategoriaADTO(evento.getCategoriaEvento()),
                evento.getNombreEvento(),
                evento.getInformacionEvento(),
                evento.getFechaHora(),
                evento.getUbicacion(),
                convertirEstadoADTO(evento.getEstadoEvento())
        );
    }

    public Evento dtoAEntidad(EventoDTO dto) {

        if (dto == null) {
            return null;
        }

        return new Evento(
                dto.getIdEvento(),
                convertirDTOACategoria(dto.getCategoriaEvento()),
                dto.getNombreEvento(),
                dto.getInformacionEvento(),
                dto.getFechaHora(),
                dto.getUbicacion(),
                convertirDTOAEstado(dto.getEstadoEvento())
        );
    }

    private CategoriaEventoDTO convertirCategoriaADTO(CategoriaEvento categoria) {

        if (categoria == null) {
            return null;
        }

        return CategoriaEventoDTO.valueOf(categoria.name());
    }

    private CategoriaEvento convertirDTOACategoria(CategoriaEventoDTO categoriaDTO) {

        if (categoriaDTO == null) {
            return null;
        }

        return CategoriaEvento.valueOf(categoriaDTO.name());
    }

    private EstadoEventoDTO convertirEstadoADTO(EstadoEvento estado) {

        if (estado == null) {
            return null;
        }

        return EstadoEventoDTO.valueOf(estado.name());
    }

    private EstadoEvento convertirDTOAEstado(EstadoEventoDTO estadoDTO) {

        if (estadoDTO == null) {
            return null;
        }

        return EstadoEvento.valueOf(estadoDTO.name());
    }
}
