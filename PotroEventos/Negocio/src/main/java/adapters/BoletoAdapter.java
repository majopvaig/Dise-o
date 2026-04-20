package adapters;

import Entitys.Boleto;
import Entitys.ENUMS.EstadoBoleto;
import Entitys.Usuario;
import dtos.BoletoDTO;
import dtos.ENUMS.EstadoBoletoDTO;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class BoletoAdapter {

    public BoletoDTO entidadADTO(Boleto boletoEntidad) {

        if (boletoEntidad == null) {
            return null;
        }

        Long idUsuario = null;

        if (boletoEntidad.getUsuario() != null) {
            idUsuario = boletoEntidad.getUsuario().getIdUsuario();
        }

        return new BoletoDTO(
                boletoEntidad.getIdBoleto(),
                boletoEntidad.getCodigoQR(),
                boletoEntidad.getPrecio(),
                boletoEntidad.getFechaCompra(),
                convertirEstadoADTO(boletoEntidad.getEstadoBoleto()),
                idUsuario
        );
    }

    public Boleto dtoAEntidad(BoletoDTO boletoDTO) {

        if (boletoDTO == null) {
            return null;
        }

        Boleto boleto = new Boleto();

        boleto.setIdBoleto(boletoDTO.getIdBoleto());
        boleto.setCodigoQR(boletoDTO.getCodigoQR());
        boleto.setPrecio(boletoDTO.getPrecio());
        boleto.setFechaCompra(boletoDTO.getFechaCompra());
        boleto.setEstadoBoleto(convertirEstadoAEntidad(boletoDTO.getEstadoBoleto()));

        if (boletoDTO.getIdUsuario() != null) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(boletoDTO.getIdUsuario());
            boleto.setUsuario(usuario);
        }

        return boleto;
    }

    private EstadoBoletoDTO convertirEstadoADTO(EstadoBoleto estadoEntidad) {

        if (estadoEntidad == null) {
            return null;
        }

        return EstadoBoletoDTO.valueOf(estadoEntidad.name());
    }

    private EstadoBoleto convertirEstadoAEntidad(EstadoBoletoDTO estadoDTO) {

        if (estadoDTO == null) {
            return null;
        }

        return EstadoBoleto.valueOf(estadoDTO.name());
    }
}
