package daos;

import Entitys.Usuario;
import adaptadores.UsuarioPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import entidadesmongo.UsuarioMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.IUsuarioDAO;
import org.bson.types.ObjectId;

/**
 *
 * @author aaron
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static UsuarioDAO instance;

    private MongoCollection<UsuarioMongoEntidad> coleccionUsuarios;

    private UsuarioDAO() {
        this.coleccionUsuarios = ConexionMongo.obtenerColeccionUsuarios();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    @Override
    public Usuario obtenerUsuario(Usuario usuario) throws PersistenciaException {
        if (usuario == null) {
            throw new PersistenciaException("El usuario no puede ser null.");
        }

        try {
            UsuarioMongoEntidad u = UsuarioPersistenciaAdapter.convertirAMongo(usuario);
            UsuarioMongoEntidad resultado = coleccionUsuarios.find(
                    and(eq("correo", usuario.getCorreo()), eq("contrasenia", u.getContrasenia()))
            ).first();
            return UsuarioPersistenciaAdapter.convertirADominio(resultado);
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener al usuario");
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) throws PersistenciaException {
        if (usuario == null) {
            throw new PersistenciaException("El usuario no puede ser null.");

        }

        try {
            UsuarioMongoEntidad u = UsuarioPersistenciaAdapter.convertirAMongo(usuario);
            InsertOneResult resultado = this.coleccionUsuarios.insertOne(u);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar al usuario");
            }

            //String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            ObjectId idGenerado = resultado.getInsertedId().asObjectId().getValue();
            
            u.setId(idGenerado);

            return UsuarioPersistenciaAdapter.convertirADominio(u);

        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible guardar al usuario");
        }
    }

    @Override
    public Usuario obtenerPorId(String idUsuario) throws PersistenciaException {
        try{
            UsuarioMongoEntidad seccion = coleccionUsuarios
                    .find(eq("_id", new ObjectId(idUsuario)))
                    .first();
            return UsuarioPersistenciaAdapter.convertirADominio(seccion);
        } catch(MongoException me){
            throw new PersistenciaException("No fue posible obtener al usuario.");
        }
    }

}
