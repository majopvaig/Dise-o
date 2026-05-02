/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.CategoriaDTO;
import dtos.EventoDTO;
import excepciones.GestionEventoException;
import java.util.List;

/**
 *
 * @author maria
 */
public interface IFachadaGestionEvento {
    
    EventoDTO consultarEvento(Long idEvento);
    
    List<EventoDTO> consultarEventos();
    
    List<EventoDTO> consultarEventosPorCategoria(CategoriaDTO categoria);
    
    List<CategoriaDTO> consultarCategorias() throws GestionEventoException;
}
