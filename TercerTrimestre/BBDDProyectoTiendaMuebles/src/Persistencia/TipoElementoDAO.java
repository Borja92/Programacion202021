package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoElementoDAO {
    private Connection conn;
    private DBConn dbConn;

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

    public boolean crear(String nombre) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO tipo_elemento(nombre) VALUES ('" + nombre + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }


    public String getTipoElementoById(int id) throws SQLException {

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
        return tipoElemento + null;
    }

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

                } else return Integer.parseInt(null);

            }
            dbConn.desconectar();

        } catch (SQLException sqle) {
            System.out.println(indice);
        }
        return indice;
    }

    public boolean actualizar(String tipoElemento, String nuevoNombre) throws SQLException {


        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE tipo_elemento SET nombre =" + "'" + nuevoNombre + "'" + " where nombre=" + "'" + tipoElemento + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

    public boolean exists(String tipoElemento) throws SQLException {
        conn = dbConn.conectar();

        PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM tipo_elemento");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString(1).equalsIgnoreCase(tipoElemento)) {
                return true;
            }

        }
        dbConn.desconectar();
        return false;
    }

    public boolean borrar(String tipoElemento) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM tipo_elemento WHERE nombre=" + "'" + tipoElemento + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;

    }

    public List<String> getAll() {
        List<String> tipoElementoDAOList = null;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT id, nombre  FROM  tipo_elemento");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tipoElementoDAOList = new ArrayList<>();
            }
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                tipoElementoDAOList.add(id + "-" + nombre);
            }

        } catch (SQLException sqle) {
            tipoElementoDAOList = null;
        }
        return tipoElementoDAOList;

    }


}
