package Persistencia;

import TiendaMuebles.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {
    private Connection conn;
    private SeccionDAO seccionDAO;
    private CategoriaDAO categoriaDAO;
    private DBConn dbConn;

    public ModeloDAO() {
        dbConn = new DBConn();
        seccionDAO = new SeccionDAO();
        categoriaDAO = new CategoriaDAO();
    }

    /*
        public boolean crear(Modelo modelo)
        public Modelo leer(String codigo)
        public int getId(String codigo)
        public boolean actualizar(String codigo, String nuevoCodigo)
        public boolean borrar(String codigo)
        public List<String> getCodigosModelos()
        public List<String> getCodigosModelosByCategoria(String
                                                                 categoria)
        public List<String> getCodigosModelosBySeccion(String seccion)
    */
    public boolean crear(Modelo modelo) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO modelo(codigo, id_seccion, id_categoria) VALUES ('" + modelo.getCodigo() + "','" + getIdSeccion(modelo.getSeccion()) + "','" + getIdCategoria(modelo.getCategoria()) + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;


    }

    private int getIdSeccion(String seccion) {
        return seccionDAO.getId(seccion);
    }

    private int getIdCategoria(String categoria) {
        return categoriaDAO.getId(categoria);
    }

    private String getSeccionById(int id) throws SQLException {

        return seccionDAO.getSeccionById(id);
    }

    private String getCategoriaById(int id) throws SQLException {

        return categoriaDAO.getCategoriaById(id);
    }

    public Modelo leer(String codigo) {
        Modelo modelo = new Modelo();
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM modelo WHERE codigo=" + "'" + codigo + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String codd = resultSet.getString(2);

                if (codigo.equalsIgnoreCase(codd)) {
                    modelo.setCodigo(resultSet.getString(2));
                    modelo.setSeccion(getSeccionById(resultSet.getInt(3)));
                    modelo.setCategoria(getCategoriaById(resultSet.getInt(4)));
                } else return null;
            }
            dbConn.desconectar();
        } catch (SQLException throwables) {
            return null;
        }
        return modelo;
    }

    public int getId(String codigo) {
        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM modelo WHERE codigo=" + "'" + codigo + "'");
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

    public boolean actualizar(String codigo, String nuevoCodigo) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE modelo SET codigo =" + "'" + nuevoCodigo + "'" + " where codigo=" + "'" + codigo + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

    public boolean borrar(String codigo) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM modelo WHERE codigo=" + "'" + codigo + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;
    }

    public List<String> getCodigosModelos() {
        List<String> listaCodigosModelo = new ArrayList<>();
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT codigo  FROM modelo");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listaCodigosModelo.add(resultSet.getString(1));
            }

        } catch (SQLException sqle) {
            return null;
        }
        return listaCodigosModelo;
    }

    public List<String> getCodigosModelosByCategoria(String categoria)  {
        List<String> listaCodigosModelo = new ArrayList<>();

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT codigo  FROM modelo WHERE id_categoria=" + "'" + getIdCategoria(categoria) + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listaCodigosModelo.add(resultSet.getString(1));
            }

        } catch (SQLException sqle) {
            return null;
        }
        return listaCodigosModelo;
    }

    public List<String> getCodigosModelosBySeccion(String seccion) {
        List<String> listaCodigosModelos = new ArrayList<>();

        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT codigo  FROM modelo WHERE id_seccion=" + "'" + getIdSeccion(seccion) + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                listaCodigosModelos.add(resultSet.getString(1));
            }

        } catch (SQLException sqle) {
            return null;
        }
        return listaCodigosModelos;
    }


}




