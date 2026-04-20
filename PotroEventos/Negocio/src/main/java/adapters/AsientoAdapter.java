package adapters;

import Entitys.Asiento;
import Entitys.Seccion;
import dtos.AsientoDTO;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoAdapter {

    public AsientoDTO entidadADTO(Asiento asientoEntidad) {

        if (asientoEntidad == null) {
            return null;
        }

        Long idSeccion = null;

        if (asientoEntidad.getSeccion() != null) {
            idSeccion = asientoEntidad.getSeccion().getIdSeccion();
        }

        return new AsientoDTO(
                asientoEntidad.getIdAsiento(),
                asientoEntidad.getFila(),
                asientoEntidad.getNumero(),
                idSeccion
        );
    }

    public Asiento dtoAEntidad(AsientoDTO asientoDTO) {

        if (asientoDTO == null) {
            return null;
        }

        Asiento asiento = new Asiento();

        asiento.setIdAsiento(asientoDTO.getIdAsiento());
        asiento.setFila(asientoDTO.getFila());
        asiento.setNumero(asientoDTO.getNumero());

        if (asientoDTO.getIdSeccion() != null) {
            Seccion seccion = new Seccion();
            seccion.setIdSeccion(asientoDTO.getIdSeccion());
            asiento.setSeccion(seccion);
        }

        return asiento;
    }
}
