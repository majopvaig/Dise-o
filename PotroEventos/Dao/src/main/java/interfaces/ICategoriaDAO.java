package interfaces;

import Entitys.Categoria;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ICategoriaDAO {

    Categoria consultarPorId(String idCategoria) throws PersistenciaException;
    
    List<Categoria> consultarCategorias() throws PersistenciaException;

}
