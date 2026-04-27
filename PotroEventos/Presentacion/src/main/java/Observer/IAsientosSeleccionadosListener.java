/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observer;

import dtos.AsientoDTO;
import dtos.AsientoEventoDTO;
import dtos.SeccionDTO;
import java.util.List;

/**
 * Interfaz para escuchar la selección de múltiples asientos.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public interface IAsientosSeleccionadosListener {

    /**
     * Método invocado cuando la lista de asientos seleccionados cambia.
     *
     * @param secciones Lista de secciones correspondientes a los asientos.
     * @param asientosInfo Lista de información técnica (fila, número).
     * @param asientosEventos Lista de datos del asiento (estado, precio).
     */
    void onSeleccionCambiada(List<SeccionDTO> secciones, List<AsientoDTO> asientosInfo, List<AsientoEventoDTO> asientosEventos);
}
