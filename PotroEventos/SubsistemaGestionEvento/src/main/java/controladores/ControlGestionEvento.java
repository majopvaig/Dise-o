/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dtos.CategoriaDTO;
import dtos.EventoDTO;
import excepciones.GestionEventoException;
import excepciones.NegocioException;
import interfaces.ICategoriaBO;
import interfaces.IEventoBO;
import java.util.List;
import java.util.ArrayList;
import objetosNegocio.CategoriaBO;
import objetosNegocio.EventoBO;

/**
 *
 * @author maria
 */
public class ControlGestionEvento {

    private List<EventoDTO> listaEventos = new ArrayList<>();

    private static ControlGestionEvento instance;

    private ICategoriaBO categoriaBO = CategoriaBO.getInstance();

    private IEventoBO eventoBO = EventoBO.getInstance();

    private ControlGestionEvento() {
    }

    public static ControlGestionEvento getInstance() {
        if (instance == null) {
            instance = new ControlGestionEvento();
        }
        return instance;
    }

    public EventoDTO consultarEvento(String idEvento) throws GestionEventoException {
        try {
            return eventoBO.obtenerEventoPorId(idEvento);
        } catch (NegocioException ne) {
            throw new GestionEventoException(ne.getMessage());
        }
    }

    public List<EventoDTO> consultarEventosPorCategoria(CategoriaDTO categoria) throws NegocioException {
        return eventoBO.obtenerEventosPorCategoria(categoria);
    }

    public List<CategoriaDTO> consultarCategorias() throws GestionEventoException {
        try {
            return categoriaBO.consultarCategorias();
        } catch (NegocioException ex) {
            throw new GestionEventoException(ex.getMessage());
        }
    }
    
    public boolean aumentarCapacidad(String idEvento) throws GestionEventoException {
        try {
            return eventoBO.aumentarDisponibilidadEvento(idEvento);
        } catch (NegocioException ne) {
            throw new GestionEventoException(ne.getMessage());
        }
    }
}
