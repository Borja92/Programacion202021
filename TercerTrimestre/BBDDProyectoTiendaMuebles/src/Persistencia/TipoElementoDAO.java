package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase TipoElementoDAO
 */
public class TipoElementoDAO {
    private Connection conn;
    private DBConn dbConn;

    /**
     * Constructor predeterminado
     */
    public TipoElementoDAO() {
        dbConn = new DBConn();
    }


    /*public boolean crear(String nombre)
    public String getTipoElementoById(int id)
    public int getId(String nombre)
    public boolean actualizar(String nombre, String nuevoNombre)
    public List<String> getAll()
    public boolean exists(String tipoElemento)
    public boolean borrar(String nombre)*/

    /**
     * Crear
     *
     * @param nombre
     * @return boolean
     * @throws SQLException
     */
    public boolean crear(String nombre) {

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO tipo_elemento(nombre) VALUES ('" + nombre + "')");
            int numFilas = statement.executeUpdate();
            dbConn.desconectar();
            if (numFilas > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            return false;
        }
        return false;

    }

    /**
     * getTipoElementoById
     *
     * @param id
     * @return String or null
     * @throws SQLException
     */
    public String getTipoElementoById(int id) {

        try {
            conn = dbConn.conectar();

            String tipoElemento = "";
            int indice;
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tipo_elemento WHERE id=" + "'" + id + "'");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                indice = resultSet.getInt(1);

                if (indice == id) {
                    tipoElemento = resultSet.getString(2);
                    return tipoElemento;
                }
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            return null;
        }
        return null;
    }

    /**
     * getId
     *
     * @param tipoElemento
     * @return int
     */
    public int getId(String tipoElemento) {
        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM tipo_elemento WHERE nombre=" + "'" + tipoElemento + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String tpElemento = resultSet.getString(2);

                if (tipoElemento.equalsIgnoreCase(tpElemento)) {
                    indice = resultSet.getInt(1);
                }
            }
            dbConn.desconectar();
        } catch (SQLException sqle) {
            return -1;
        }
        return indice;
    }

    /**
     * actualizar
     *
     * @param tipoElemento
     * @param nuevoNombre
     * @return boolean
     * @throws SQLException
     */
    public boolean actualizar(String tipoElemento, String nuevoNombre) {

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("UPDATE tipo_elemento SET nombre =" + "'" + nuevoNombre + "'" + " where nombre=" + "'" + tipoElemento + "'");
            int numFilas = statement.executeUpdate();
            if (numFilas > 0) {
                return true;
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            return false;

        }
        return false;
    }

    /**
     * exists
     *
     * @param tipoElemento
     * @return boolean
     * @throws SQLException
     */
    public boolean exists(String tipoElemento)  {
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM tipo_elemento");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(1).equalsIgnoreCase(tipoElemento)) {
                    return true;
                }
            }
            dbConn.desconectar();

        } catch (SQLException throwables) {
            return false;
        }

        return false;
    }

    /**
     * borrar
     *
     * @param tipoElemento
     * @return boolean
     * @throws SQLException
     */
    public boolean borrar(String tipoElemento) {

        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM tipo_elemento WHERE nombre=" + "'" + tipoElemento + "'");
            int valor = statement.executeUpdate();
            dbConn.desconectar();
            if (valor > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    /**
     * getAll
     *
     * @return List<String> or null
     */
    public List<String> getAll() {
        List<String> tipoElementoDAOList = new ArrayList<>();
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT id, nombre  FROM  tipo_elemento");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                tipoElementoDAOList.add(nombre);
            }

        } catch (SQLException sqle) {
            return null;
        }
        return tipoElementoDAOList;

    }


}
