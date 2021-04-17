package Persistencia;

import TiendaMuebles.Elemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ElementoModeloDAO {
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;
    private DBConn dbConn;

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


    public boolean crear(String codigoElemento, String codigoModelo) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento_modelo( id_elemento, id_modelo) VALUES ('" + getIdElemento(codigoElemento) + "','" + getIdModelo(codigoModelo) + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

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

    private int getIdElemento(String codigoElemento) {
        return elementoDAO.getId(codigoElemento);

    }

    private int getIdModelo(String codigoModelo) {
        return modeloDAO.getId(codigoModelo);
    }

    public boolean actualizarModelo(String codigoElemento, String codigoModelo, String codigoNuevoModelo) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE elemento_modelo SET id_modelo =" + "'" + codigoNuevoModelo + "'" + " where id_elemento=" + "'" + codigoElemento + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }

    public List<Elemento> getElementosByCodigoModelo(String codigoModelo) {
        List<Elemento> listaElementos = new ArrayList<>();
        try {
            conn = dbConn.conectar();
           //System.out.println(elementoDAO.getElementoById(56));

            //PreparedStatement statement = conn.prepareStatement("SELECT id_elemento FROM elemento_modelo WHERE id_modelo =" + "'" + getIdElemento(codigoModelo) + "'");
           ResultSet resultSet = conn.prepareStatement("SELECT id_elemento FROM elemento_modelo WHERE id_modelo =" + getIdModelo(codigoModelo)).executeQuery();
//listaElementos.add(elementoDAO.getElementoById(resultSet.getInt(1)));
            while (resultSet.next()) {
                System.out.println("Holaaaa");
                listaElementos.add(elementoDAO.getElementoById(resultSet.getInt(1)));
            }

        } catch (SQLException throwables) {
            return null;
        }
        return listaElementos;
    }

    public boolean borrar(String codigoElemento, String codigoModelo) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM elemento_modelo WHERE id_elemento=" + "'" + getIdElemento(codigoElemento) + "' AND  id_modelo=" + " '" + getIdModelo(codigoModelo) + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;
    }
}
