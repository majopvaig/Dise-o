/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entitys.Asiento;
import dtos.AsientoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author maria
 */
public interface IAsientoBO {
    
    List<AsientoDTO> consultarTodosLosAsientos() throws NegocioException;
    
    public List<AsientoDTO> consultarPorSeccion(Long idSeccion);
}
