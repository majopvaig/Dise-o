package adapters;

import Entitys.Asiento;
import Entitys.AsientoEvento;
import Entitys.Evento;
import Entitys.Reservacion;
import dtos.AsientoEventoDTO;
import dtos.ENUMS.EstadoAsientoDTO; // Tu Enum
import java.util.ArrayList;
import java.util.List;

public class AsientoEventoAdapter {

    public static AsientoEventoDTO entidadADTO(AsientoEvento entidad) {
        if (entidad == null) {
            return null;
        }

        AsientoEventoDTO dto = new AsientoEventoDTO();
        if (entidad.getReservacion() != null) {
            dto.setIdReservacion(entidad.getReservacion().getIdReservacion());
        } else {
            dto.setIdReservacion(null);
        }
        //dto.setIdReservacion(entidad.getReservacion().getIdReservacion());

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
    
    public static AsientoEvento dtoAEntidad(AsientoEventoDTO dto) {
        if (dto == null) {
            return null;
        }

        AsientoEvento entidad = new AsientoEvento();

        entidad.setEstadoAsiento(Entitys.ENUMS.EstadoAsiento.valueOf(dto.getEstadoAsiento().name()));

        /*
        ponerle el asiento fake 
         */
        Asiento asiento = new Asiento();
        asiento.setIdAsiento(dto.getIdAsiento());
        entidad.setAsiento(asiento);

        /*
        ponerle el evento fake
        */
        Evento evento = new Evento();
        evento.setIdEvento(dto.getIdEvento());
        entidad.setEvento(evento);

        /*
        ponerle la reservacion fake
        */
        Reservacion reservacion = new Reservacion();
        reservacion.setIdReservacion(dto.getIdReservacion());
        entidad.setReservacion(reservacion);

        return entidad;
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
