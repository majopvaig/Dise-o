package interfaz;

import Entitys.Evento;
import Entitys.Usuario;
import java.util.List;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public interface IControlOperaciones {

    public List<Evento> obtenerEventosDisponibles();

    public List<Usuario> obtenerUsuarios();
    
    
    
}
