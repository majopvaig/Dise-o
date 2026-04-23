package adapters;

import Entitys.AsientoEvento;
import dtos.AsientoEventoDTO;
import dtos.AsientoDTO;
import dtos.SeccionDTO;
import dtos.ENUMS.EstadoAsientoDTO; // Tu Enum
import java.util.ArrayList;
import java.util.List;

public class AsientoEventoAdapter {

    public static AsientoEventoDTO entidadADTO(AsientoEvento entidad) {
        if (entidad == null) {
            return null;
        }

        AsientoEventoDTO dto = new AsientoEventoDTO();

        dto.setIdReservacion(entidad.getIdReservacion());

        if (entidad.getAsiento() != null) {
            dto.setIdAsiento(entidad.getAsiento().getIdAsiento());
        }

        if (entidad.getEvento() != null) {
            dto.setIdEvento(entidad.getEvento().getIdEvento());
        }

        if (entidad.getEstadoAsiento() != null) {
            try {

                dto.setEstadoAsiento(EstadoAsientoDTO.valueOf(entidad.getEstadoAsiento().name()));
            } catch (IllegalArgumentException e) {

                dto.setEstadoAsiento(EstadoAsientoDTO.DISPONIBLE);
            }
        }

        return dto;
    }

    public static List<AsientoEventoDTO> listaEntidadADTO(List<AsientoEvento> entidades) {
        List<AsientoEventoDTO> dtos = new ArrayList<>();
        if (entidades != null) {
            for (AsientoEvento ent : entidades) {
                dtos.add(entidadADTO(ent));
            }
        }
        return dtos;
    }
}
