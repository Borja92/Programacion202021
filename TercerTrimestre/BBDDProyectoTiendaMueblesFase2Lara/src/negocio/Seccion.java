package negocio;

import Persistencia.DBConn;
import Persistencia.SeccionDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Seccion
 */
public class Seccion {
    /**
     * Atributos de la clase
     */
    List<String> secciones;
    private Connection conn;
    private SeccionDAO seccionDAO;

    /**
     * Constructor
     */
    public Seccion() {
        this.secciones = new ArrayList<>();
        this.conn = new DBConn().conectar();
        this.seccionDAO = new SeccionDAO(conn);
    }

    /**
     * getSecciones
     *
     * @return List<String>
     */
    public List<String> getSecciones() {

        return secciones;
    }

    /**
     * refresh
     */
    public void refresh() {
        this.secciones = seccionDAO.getAll();
    }

    /**
     * seccionExist
     *
     * @param seccion
     * @return boolean
     */
    public boolean seccionExists(String seccion) {
        refresh();
        if (getSecciones().contains(seccion)) {
            return true;
        }
        return false;
    }

    /**
     * crearSeccion
     *
     * @param seccion
     * @return boolean
     */

    public boolean crearSeccion(String seccion) {

        if (seccionDAO.crear(seccion)) {
            refresh();
            return true;
        }
        return false;
    }


    /**
     * modificarSeccion
     *
     * @param seccion
     * @param nuevaSeccion
     * @return boolean
     */
    public boolean modificarSeccion(String seccion, String nuevaSeccion) {

        if (seccionDAO.actualizar(seccion, nuevaSeccion)) {
            refresh();
            return true;
        }
        return false;
    }

    /**
     * deleteSeccion
     *
     * @param seccion
     * @return boolean
     */
    public boolean deleteSeccion(String seccion) {

        if (seccionDAO.borrar(seccion)) {
            refresh();
            return true;
        }

        return false;
    }


}
