package negocio;

import persistencia.DBConn;
import persistencia.TipoElementoDAO;

import java.sql.Connection;
import java.util.List;

public class TipoElementos {

    //Contiene todos los tipos de elemento existentes en la base de datos.
    List<String> tiposElementos;

    private persistencia.TipoElementoDAO tipoElementoDAO;

    public TipoElementos() {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.conectar();
        tipoElementoDAO = new TipoElementoDAO(conn);
        tiposElementos = tipoElementoDAO.getAll();
    }

    private void refresh() {
        tiposElementos = tipoElementoDAO.getAll();
    }

    public List<String> getTiposElementos() {
        return tiposElementos;
    }

    public boolean crearTipoElemento(String tipoElemento)
    {
        boolean sucsessful;
        sucsessful = tipoElementoDAO.crear(tipoElemento);
        if (sucsessful) refresh();
        return sucsessful;
    }

    /* Devuelve true si el tipo de elemento existe o false en caso contrario. boolean crearTipoElemento(String tipoElemento)
   Inserta un nuevo tipo de elemento. Si el tipo de elemento es creado en la base de datos, se añade en la lista tiposElementos y devuelve true.
   En cualquier otro caso devuelve false.
    */
    public boolean tipoElementoExists(String tipoElemento)
    {
        return tipoElementoDAO.exists(tipoElemento);
    }

    /*  Modifica el tipo de elemento, asignándole el nombre nuevoTipoElemento. La modificación afecta tanto a la base de datos como al atributo tiposElementos.
        Además, todos los elementos del atributo modeloActual son modificados si alguno de ellos es de ese tipo.   */
    public boolean modificarTipoElemento(String tipoElemento, String nuevoTipoElemento)
    {
        boolean sucsessful;
        sucsessful = tipoElementoDAO.actualizar(tipoElemento,nuevoTipoElemento);;
        if (sucsessful) refresh();
        return sucsessful;
    }

    /*  Elimina un tipo de elemento siempre que no hayan elementos de este tipo. Si es borrado de la lista tiposElementos y de la base de datos es exitosa devuelve true.
        En cualquier otro caso, devuelve false.
    */
    public boolean deleteTiposElemento(String tipoElemento)
    {

        boolean sucsessful;
        sucsessful = tipoElementoDAO.borrar(tipoElemento);
        if (sucsessful) refresh();
        return sucsessful;
    }


}
