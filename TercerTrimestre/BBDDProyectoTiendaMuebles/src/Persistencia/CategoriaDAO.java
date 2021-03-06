package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CategoriaDAO
 */
public class CategoriaDAO {

    private Connection conn;
    DBConn dbConn;

    /**
     * Constructor predeterminado
     */
    public CategoriaDAO() {

        dbConn = new DBConn();
    }
/*
    public boolean crear(String categoria)
    public boolean actualizar(String categoria, String nuevoNombre)
    public String getCategoriaById(int id)
    public int getId(String categoria)
    public boolean borrar(String categoria)
    public boolean exists(String categoria)
    public List<String> getAll(){}
*/

    /**
     * Método crear
     *
     * @param categoria
     * @return boolean
     * @throws SQLException
     */
    public boolean crear(String categoria)  {
        try {
            conn = dbConn.conectar();

            //PreparedStatement statement = conn.prepareStatement("INSERT INTO categoria(nombre) VALUES ('" + categoria + "')", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO categoria(nombre) VALUES ('" + categoria + "')");
            int numFilas = statement.executeUpdate();
            //ResultSet result = statement.getGeneratedKeys();
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
     * Método actualizar
     *
     * @param categoria
     * @param nuevoNombre
     * @return boolean
     * @throws SQLException
     */
    public boolean actualizar(String categoria, String nuevoNombre)  {
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("UPDATE categoria SET nombre =" + "'" + nuevoNombre + "'" + " where nombre=" + "'" + categoria + "'");
            int numFilas = statement.executeUpdate();
            dbConn.desconectar();
            if (numFilas > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
return false;
    }

    /**
     * Método getAll
     *
     * @return Lis<String> or null
     */
    public List<String> getAll() {
        List<String> categoriaDAOS = new ArrayList<>();
        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("SELECT id, nombre  FROM categoria");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
               // int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                categoriaDAOS.add(nombre);
            }
        } catch (SQLException sqle) {
            return null;
        }
        return categoriaDAOS;

    }

    /**
     * getCategoriaById
     *
     * @param id
     * @return String or null
     * @throws SQLException
     */
    public String getCategoriaById(int id) {
        String categoria = "";

        try {
            conn = dbConn.conectar();

            int indice;
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM categoria WHERE id=" + "'" + id + "'");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                indice = resultSet.getInt(1);

                if (indice == id) {
                    categoria = resultSet.getString(2);
                    return categoria;
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
     * @param categoria
     * @return int
     */
    public int getId(String categoria) {
        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM categoria WHERE nombre=" + "'" + categoria + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cat = resultSet.getString(2);
                if (categoria.equalsIgnoreCase(cat)) {
                    indice = resultSet.getInt(1);
                }
            }
            dbConn.desconectar();

        } catch (SQLException sqle) {
            System.out.println(indice);
        }
        return indice;
    }

    /**
     * exists
     *
     * @param categoria
     * @return boolean
     * @throws SQLException
     */
    public boolean exists(String categoria)  {
        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM categoria");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(1).equalsIgnoreCase(categoria)) {
                    return true;
                }
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * borrar
     *
     * @param categoria
     * @return boolean
     * @throws SQLException
     */
    public boolean borrar(String categoria)  {
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM categoria WHERE nombre=" + "'" + categoria + "'");
            int valor = statement.executeUpdate();
            if (valor > 0) {
                return true;
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
return false;
        }
        return false;
    }


}
