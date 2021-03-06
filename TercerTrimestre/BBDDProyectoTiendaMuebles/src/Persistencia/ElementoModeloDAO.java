package Persistencia;

import TiendaMuebles.Elemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ElementoDAO
 */
public class ElementoModeloDAO {
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;
    private DBConn dbConn;

    /**
     * Constructor predeterminado
     *
     */
    public ElementoModeloDAO() {
        dbConn = new DBConn();
        elementoDAO = new ElementoDAO();
        modeloDAO = new ModeloDAO();
    }
/*
    public boolean crear(String codigoElemento, String codigoModelo)
    public int getId(String codigoElemento, String codigoModelo)
    public boolean actualizarModelo(String codigoElemento, String
            codigoModelo, String codigoNuevoModelo)
    public List<Elemento> getElementosByCodigoModelo(String
                                                             codigoModelo)
    public boolean borrar(String codigoElemento, String codigoModelo)
*/

    /**
     * crear
     *
     * @param codigoElemento
     * @param codigoModelo
     * @return boolean
     * @throws SQLException
     */
    public boolean crear(String codigoElemento, String codigoModelo) {
        /*int idElemento =getIdElemento(codigoElemento);
        int idModelo=getIdModelo(codigoModelo);*/
        try {
            conn = dbConn.conectar();
            PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento_modelo( id_elemento, id_modelo) VALUES ('" + getIdElemento(codigoElemento) + "','" + getIdModelo(codigoModelo) + "')");
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
     * getId
     *
     * @param codigoElemento
     * @param codigoModelo
     * @return int
     */
    public int getId(String codigoElemento, String codigoModelo) {

        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT id FROM elemento_modelo WHERE id_elemento =" + "'" + getIdElemento(codigoElemento) + "' AND  id_modelo=" + " '" + getIdModelo(codigoModelo) + "' ");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                indice = resultSet.getInt(1);
            }

            dbConn.desconectar();

        } catch (SQLException sqle) {
            return -1;
        }

        return indice;
    }

    /**
     * getIdElemento
     *
     * @param codigoElemento
     * @return
     */
    private int getIdElemento(String codigoElemento) {
        return elementoDAO.getId(codigoElemento);

    }

    /**
     * getIdModelo
     *
     * @param codigoModelo
     * @return int
     */
    private int getIdModelo(String codigoModelo) {
        return modeloDAO.getId(codigoModelo);
    }

    /**
     * actualizarModelo
     *
     * @param codigoElemento
     * @param codigoModelo
     * @param codigoNuevoModelo
     * @return boolean
     * @throws SQLException
     */
    public boolean actualizarModelo(String codigoElemento, String codigoModelo, String codigoNuevoModelo) {

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("UPDATE elemento_modelo SET id_modelo =" + "'" + getIdModelo(codigoNuevoModelo) + "'" + " where id_elemento=" + "'" + getIdElemento(codigoElemento) + "' AND  id_modelo=" + " '" + getIdModelo(codigoModelo) +  "'");
           // PreparedStatement statement = conn.prepareStatement("UPDATE elemento_modelo SET id_modelo =" + "'" + "'"+getIdModelo(codigoNuevoModelo)+"'" + "'" + " where id_elemento=" + "'" +"'"+ getIdElemento(codigoElemento)+"'" + "' AND  id_modelo=" + " '" + "'"+getIdModelo(codigoModelo)+"'" +  "'");
            int numFilas = statement.executeUpdate();
            dbConn.desconectar();
            if (numFilas > 0) {
                return true;
            }
conn.close();
        } catch (SQLException throwables) {
            return false;
        }
        return false;

    }

    /**
     * getElementoByCodigoModelo
     *
     * @param codigoModelo
     * @return List<Elemento> or null
     */
    public List<Elemento> getElementosByCodigoModelo(String codigoModelo) {
        List<Elemento> listaElementos = new ArrayList<>();
        try {
            conn = dbConn.conectar();

            ResultSet resultSet = conn.prepareStatement("SELECT id_elemento FROM elemento_modelo WHERE id_modelo =" + getIdModelo(codigoModelo)).executeQuery();
            while (resultSet.next()) {
                listaElementos.add(elementoDAO.getElementoById(resultSet.getInt(1)));
            }


        } catch (SQLException throwables) {
            return null;
        }
        return listaElementos;
    }

    /**
     * borrrar
     *
     * @param codigoElemento
     * @param codigoModelo
     * @return boolean
     * @throws SQLException
     */
    public boolean borrar(String codigoElemento, String codigoModelo) {
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("DELETE FROM elemento_modelo WHERE id_elemento=" + "'" + getIdElemento(codigoElemento) + "' AND  id_modelo=" + " '" + getIdModelo(codigoModelo) + "'");
            int valor = statement.executeUpdate();
            dbConn.desconectar();
            if (valor > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            return false;
        }
        return false;
    }
}
