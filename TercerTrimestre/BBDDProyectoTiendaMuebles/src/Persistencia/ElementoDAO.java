package Persistencia;

import TiendaMuebles.Elemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase ElementoDAO
 */
public class ElementoDAO {
    private TipoElementoDAO tipoElementoDAO;
    private Connection conn;
    private DBConn dbConn;

    /**
     * Constructor Clase ElementoDAO
     */
    public ElementoDAO() {
        dbConn = new DBConn();
        tipoElementoDAO = new TipoElementoDAO();

    }

    /*public boolean crear(Elemento elemento)
    public Elemento leer(String codigo)
    public int getId(String codigo)
    public Elemento getElementoById(int id)
    public boolean actualizar(String codigo, String nuevoCodigo)
    public boolean borrar(String codigo)*/

    /**
     * Método crear
     *
     * @param elemento
     * @return boolean or int
     * @throws SQLException
     */
    public boolean crear(Elemento elemento) {
        try {
            conn = dbConn.conectar();
            int id_tipo_elemento = getIdTipoElemento(elemento.getTipo());
            PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento(codigo,id_tipo_elemento) VALUES ('" + elemento.getCodigo() + "','" + id_tipo_elemento + "')");
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
     * Método getIdTipoElemento
     *
     * @param tipoElemento
     * @return
     */
    private int getIdTipoElemento(String tipoElemento) {

        return tipoElementoDAO.getId(tipoElemento);
    }

    /**
     * Leer
     *
     * @param codigo
     * @return String or null
     */
    public Elemento leer(String codigo) {

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM elemento WHERE codigo=" + "'" + codigo + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String codd = resultSet.getString(2);

                if (codigo.equalsIgnoreCase(codd)) {
                    Elemento elemento= new Elemento(resultSet.getString(2),
                    tipoElementoDAO.getTipoElementoById(resultSet.getInt(3)));
                return elemento;
                }
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            return null;
        }
        return null;
    }

    /**
     * Método getId
     *
     * @param codigo
     * @return int
     */
    public int getId(String codigo) {

        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM elemento WHERE codigo=" + "'" + codigo + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String codd = resultSet.getString(2);

                if (codigo.equalsIgnoreCase(codd)) {
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
     * Método getElementoById
     *
     * @param id
     * @return Elemento or null
     * @throws SQLException
     */
    public Elemento getElementoById(int id) {
        try {
            conn = dbConn.conectar();

          //  int indice;
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM elemento WHERE id=" + "'" + id + "'");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                    Elemento elemento= new Elemento(resultSet.getString(2),
                    tipoElementoDAO.getTipoElementoById(resultSet.getInt(3)));
                return elemento;
                }

            dbConn.desconectar();

        } catch (SQLException throwables) {
            return null;
        }
        return null;
    }

    /**
     * Método actualizar
     *
     * @param codigo
     * @param nuevoCodigo
     * @return boolean
     * @throws SQLException
     */
    public boolean actualizar(String codigo, String nuevoCodigo) {
        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("UPDATE elemento SET codigo =" + "'" + nuevoCodigo + "'" + " where codigo=" + "'" + codigo + "'");
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
     * Método borrar
     *
     * @param codigo
     * @return boolean
     * @throws SQLException
     */
    public boolean borrar(String codigo) {
        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM elemento WHERE codigo=" + "'" + codigo + "'");
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



