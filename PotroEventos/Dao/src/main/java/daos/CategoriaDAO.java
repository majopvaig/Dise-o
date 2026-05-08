/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entitys.Categoria;
import adaptadores.CategoriaPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import conexion.ConexionMongo;
import entidadesmongo.CategoriaMongoEntidad;
import excepciones.PersistenciaException;
import interfaces.ICategoriaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria
 */
public class CategoriaDAO implements ICategoriaDAO {

    private final MongoCollection<CategoriaMongoEntidad> coleccionCategorias;
    private static CategoriaDAO instance;

    private CategoriaDAO() {
        this.coleccionCategorias = ConexionMongo.obtenerColeccionCategorias();
    }

    public static CategoriaDAO getInstance() {
        if (instance == null) {
            instance = new CategoriaDAO();
        }
        return instance;
    }

    @Override
    public List<Categoria> consultarCategorias() throws PersistenciaException {
        try {
            List<CategoriaMongoEntidad> categorias = coleccionCategorias.find().into(new ArrayList<>());
            return CategoriaPersistenciaAdapter.convertirListaADominio(categorias);
        } catch (MongoException e) {
            throw new PersistenciaException("No fue posible obtener las categorías");
        }
    }
}
