package fachada;

import dtos.AsientoDTO;
import dtos.AsientoEventoDTO;
import dtos.EventoDTO;
import dtos.SeccionDTO;
import excepciones.CompraBoletoException;
import interfaz.ICompraBoleto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kaleb
 */
public class CompraBoletoFachada implements ICompraBoleto {

    @Override
    public EventoDTO obtenerEvento(Long idEvento) throws CompraBoletoException {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody      
    }

    @Override
    public List<SeccionDTO> obtenerSeccionesPorEvento(Long idEvento) throws CompraBoletoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AsientoDTO> obtenerAsientosPorSeccion(Long idSeccion) throws CompraBoletoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AsientoEventoDTO> obtenerEstadoAsientosPorEvento(Long idEvento) throws CompraBoletoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
