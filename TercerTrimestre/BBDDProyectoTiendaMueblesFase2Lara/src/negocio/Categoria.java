package negocio;

import Persistencia.CategoriaDAO;
import Persistencia.DBConn;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Categoria
 */
public class Categoria {

    /**
     * Atributos de la clase
     */
    List<String> categorias;
    private Connection conn;
    private CategoriaDAO categoriaDao;

    /**
     * Constructor predeterminado
     */
    public Categoria() {
        this.categorias = new ArrayList<>();
        this.conn = new DBConn().conectar();
        this.categoriaDao = new CategoriaDAO(conn);
    }

    /**
     * getCategorias
     *
     * @return List<String>
     */
    public List<String> getCategorias() {
        return categorias;
    }

    /**
     * refresh
     */
    public void refresh() {
            this.categorias = categoriaDao.getAll();
    }

    /**
     * CategoriaExist
     *
     * @param categoria
     * @return boolean
     */
    public boolean categoriaExist(String categoria) {
        refresh();
            if (getCategorias().contains(categoria)) {
                return true;
            }

        return false;
    }

    /**
     * crearCategoria
     *
     * @param categoria
     * @return
     */
    public boolean crearCategoria(String categoria) {
            if (categoriaDao.crear(categoria)) {
               categorias.add(categoria);
                refresh();
                return true;
        }
        return false;
    }



    /**
     * modificarCategoria
     *
     * @param categoria
     * @param nuevaCategoria
     * @return boolean
     */
    public boolean modificarCategoria(String categoria, String nuevaCategoria) {

            if (categoriaDao.actualizar(categoria, nuevaCategoria)) {
                refresh();
                return true;
            }
        return false;
    }

    /**
     * deleteCategoria
     *
     * @param categoria
     * @return
     */
    public boolean deleteCategoria(String categoria) {

            if (categoriaDao.borrar(categoria)) {
                refresh();
                return true;
            }

        return false;
    }


}
