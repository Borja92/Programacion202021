package negocio;

import persistencia.CategoriaDAO;
import persistencia.DBConn;

import java.sql.Connection;
import java.util.List;

public class Categoria {

    // contiene las categorías existentes en la base de datos.
    List<String> categorias;
    private CategoriaDAO categoriaDAO;

    public Categoria() {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.conectar();
        categoriaDAO = new CategoriaDAO(conn);
        refresh();
    }

    private void refresh() {
        categorias = categoriaDAO.getAll();
    }


    public List<String> getCategorias() {
        return categorias;
    }

    //  Devuelve true si la categoría existe o false en caso contrario.
    public boolean categoriaExists(String categoria)
    {
        return categoriaDAO.exists(categoria);
    }

    //    Inserta una nueva categoría. Si la categoría es creada en la base de datos,
    //    se añade en la lista categoría y se devuelve true. En cualquier otro caso, se devuelve false.
    public boolean crearCategoria(String categoria)
    {
        boolean sucsessful;
        sucsessful = categoriaDAO.crear(categoria);
        if (sucsessful) refresh();
        return sucsessful;
    }

    /*
    Modifica la categoría, asignándole el nombre nuevaCategoria. La modificación afecta tanto a la base de datos como al atributo categorias.
    Además, el atributo modeloActual es modificado en caso de pertenecer a dicha categoría.
    Si la modificación es exitosa, devuelve true, y en caso contrario false. boolean deleteCategoria(String categoria)
    Elimina una categoría, siempre que no hayan modelos en esta categoría.
    Si el borrado de la lista categorias y de la base de datos es exitosa devuelve true. En cualquier otro caso, devuelve false.
     */
    public boolean modificarCategoria(String categoria, String nuevaCategoria)
    {
        boolean sucsessful;
        sucsessful = categoriaDAO.actualizar(categoria,nuevaCategoria);
        if (sucsessful) refresh();
        return sucsessful;

    }






}
