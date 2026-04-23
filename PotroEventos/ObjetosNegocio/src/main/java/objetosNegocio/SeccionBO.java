/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adapters.SeccionAdapter;
import daos.SeccionDAO;
import dtos.SeccionDTO;
import excepciones.NegocioException;
import interfaces.ISeccionBO;
import java.util.List;

/**
 *
 * @author maria
 */
public class SeccionBO implements ISeccionBO {

    private static SeccionBO instancia;

    private SeccionDAO seccionDAO = new SeccionDAO();

    private SeccionBO() {
    }

    public static SeccionBO getInstance() {
        if (instancia == null) {
            instancia = new SeccionBO();
        }
        return instancia;
    }

    @Override
    public List<SeccionDTO> consultarSeccionesPorEvento(Long idEvento) throws NegocioException {
        return SeccionAdapter.listaEntidadADTO(seccionDAO.buscarPorEvento(idEvento));
    }

}
