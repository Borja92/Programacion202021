package negocio;

import persistencia.DBConn;
import persistencia.SeccionDAO;

import java.sql.Connection;
import java.util.List;

public class Seccion {

    //Contiene las secciones existentes en la base de datos.
    List<String> secciones;

    private SeccionDAO seccionDAO;

    public Seccion(){
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.conectar();
        seccionDAO = new SeccionDAO(conn);
        secciones = seccionDAO.getAll();
    }

    private void refresh()
    {
        secciones = seccionDAO.getAll();
    }

    /*
    Inserta una nueva sección. Si la sección es creada en la base de datos, se añade en la lista categorías y se devuelve true.
    En cualquier otro caso, se devuelve false.
    */
    public boolean crearSeccion(String seccion)
    {
        boolean sucsessful;
        sucsessful = seccionDAO.crear(seccion);
        if (sucsessful) refresh();
        return sucsessful;
    }

    public List<String> getSecciones() {
        return secciones;
    }

    /* Devuelve true si la sección existe o false en caso contrario. boolean crearSeccion(String seccion)
   */
    public boolean seccionExists(String seccion)
    {
        return seccionDAO.exists(seccion);
    }

    //    Modifica la seccion, asignándole el nombre nuevaSeccion. La modificación afecta tanto a la base de datos como al atributo secciones.
    //    Además, el atributo modeloActual es modificado en caso de pertenecer a dicha sección.
    //    Si la modificación es exitosa devuelve true, y en caso contrario false.
    public boolean modificarSeccion(String seccion, String nuevaSeccion)
    {
        boolean sucsessful;
        sucsessful = seccionDAO.actualizar(seccion, nuevaSeccion);
        if (sucsessful) refresh();
        return sucsessful;
    }

    //    Elimina una sección siempre que no hayan modelos que la estén usando. Si el borrado de la lista secciones y de la base de datos es exitosa devuelve true.
    //    En cualquier otro caso, devuelve false.
    public boolean deleteSeccion(String seccion)
    {
        boolean sucsessful;
        sucsessful = seccionDAO.borrar(seccion);;
        if (sucsessful) refresh();
        return sucsessful;
    }

}
