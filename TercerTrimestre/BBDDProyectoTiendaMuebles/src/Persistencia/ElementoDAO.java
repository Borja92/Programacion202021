package Persistencia;

import TiendaMuebles.Elemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementoDAO {
    private TipoElementoDAO tipoElementoDAO;
    private Connection conn;
    private DBConn dbConn;

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


    public boolean crear(Elemento elemento) throws SQLException {
        conn = dbConn.conectar();
        int id_tipo_elemento = getIdTipoElemento(elemento.getTipo());
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento(codigo,id_tipo_elemento) VALUES ('" + elemento.getCodigo() + "','" + id_tipo_elemento + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }


    private int getIdTipoElemento(String tipoElemento) {

        return tipoElementoDAO.getId(tipoElemento);
    }


    public Elemento leer(String codigo) {
        Elemento elemento = new Elemento();

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM elemento WHERE codigo=" + "'" + codigo + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String codd = resultSet.getString(2);

                if (codigo.equalsIgnoreCase(codd)) {
                    elemento.setCodigo(resultSet.getString(2));
                    elemento.setTipo(tipoElementoDAO.getTipoElementoById(resultSet.getInt(3)));
                } else return null;
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            return null;
        }
        return elemento;
    }

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
            System.out.println(indice);
        }
        return indice;

    }

    public Elemento getElementoById(int id) throws SQLException {
        conn = dbConn.conectar();
        Elemento elemento = new Elemento();
        int indice;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM elemento WHERE id=" + "'" + id + "'");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            indice = resultSet.getInt(1);
            if (indice == id) {
                elemento.setCodigo(resultSet.getString(2));
                elemento.setTipo(resultSet.getString(3));
            }
        }
        if (elemento != null) {
            return elemento;
        }
        dbConn.desconectar();
        return null;
    }

    public boolean actualizar(String codigo, String nuevoCodigo) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE elemento SET codigo =" + "'" + nuevoCodigo + "'" + " where codigo=" + "'" + codigo + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }

    public boolean borrar(String codigo) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM elemento WHERE codigo=" + "'" + codigo + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;

    }

}



