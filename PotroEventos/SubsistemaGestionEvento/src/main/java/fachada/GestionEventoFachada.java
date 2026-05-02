/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import controladores.ControlGestionEvento;
import dtos.CategoriaDTO;
import interfaces.IFachadaGestionEvento;
import java.util.List;
import dtos.EventoDTO;
import excepciones.GestionEventoException;

/**
 *
 * @author maria
 */
public class GestionEventoFachada implements IFachadaGestionEvento {
    
    private ControlGestionEvento control = ControlGestionEvento.getInstance();

    @Override
    public EventoDTO consultarEvento(Long idEvento) {
        return control.consultarEvento(idEvento);
    }

    @Override
    public List<EventoDTO> consultarEventos() {
        return control.consultarEventos();
    }

    @Override
    public List<EventoDTO> consultarEventosPorCategoria(CategoriaDTO categoria) {
        return control.consultarEventosPorCategoria(categoria);
    }
    
    @Override
    public List<CategoriaDTO> consultarCategorias() throws GestionEventoException {       
        return control.consultarCategorias();
    }
    
}
