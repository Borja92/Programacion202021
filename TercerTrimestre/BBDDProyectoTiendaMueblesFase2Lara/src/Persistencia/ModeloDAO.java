package Persistencia;

import modelo.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {
    private final static int CRITERIO_CATEGORIA = 1;
    private final static int CRITERIO_SECCION = 2;

    Connection conn;
    SeccionDAO seccionDAO;
    CategoriaDAO categoriaDAO;

    public ModeloDAO(Connection conn){
        this.conn = conn;
        seccionDAO = new SeccionDAO(conn);
        categoriaDAO = new CategoriaDAO(conn);
    }

    public boolean crear(Modelo modelo) {
        try {
            int idSeccion = seccionDAO.getId(modelo.getSeccion());
            int idCategoria = categoriaDAO.getId(modelo.getCategoria());
            if ((idSeccion > -1) && (idCategoria > -1))
                return (conn.prepareStatement("INSERT INTO modelo(codigo,id_seccion,id_categoria) VALUES ('"+modelo.getCodigo()+"','"+idSeccion+"','"+idCategoria+"')").executeUpdate() == 1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Modelo leer(String codigo){
        try{
            int idModelo = getId(codigo);
            ResultSet result = conn.prepareStatement("SELECT id_seccion,id_categoria FROM modelo WHERE id='"+idModelo+"'").executeQuery();
            if (result.next()){
                String seccion = seccionDAO.getSeccionById(result.getInt(1));
                String categoria = categoriaDAO.getCategoriaById(result.getInt(2));
                if ((seccion != null) && (categoria != null))
                    return new Modelo(codigo,seccion,categoria);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getId(String codigo){
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM modelo WHERE codigo='"+codigo+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public boolean actualizar(String codigo, String nuevoCodigo){
        try{
            return conn.prepareStatement("UPDATE modelo SET codigo = '"+nuevoCodigo+"' WHERE codigo='"+codigo+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean borrar(String codigo){
        try {
            return conn.prepareStatement("DELETE FROM modelo WHERE codigo = '"+codigo+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<String> getCodigosModelos(){
        List<String> codigosModelos = null;

        try{
            ResultSet result = conn.prepareStatement("SELECT codigo FROM modelo").executeQuery();
            codigosModelos = new ArrayList<>();
            while (result.next()){
                codigosModelos.add(result.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codigosModelos;
    }

    public List<String> getCodigosModelosByCategoria(String categoria){
        CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
        int idCategoria = categoriaDAO.getId(categoria);

        List<String> codigosModelos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT codigo FROM modelo WHERE id_categoria = '"+idCategoria+"'").executeQuery();
            codigosModelos = new ArrayList<>();
            while (result.next())
                codigosModelos.add(result.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codigosModelos;
    }

    public List<String> getCodigosModelosBySeccion(String seccion){
        SeccionDAO seccionDAO = new SeccionDAO(conn);
        int idSeccion = seccionDAO.getId(seccion);

        List<String> codigosModelos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT codigo FROM modelo WHERE id_seccion = '"+idSeccion+"'").executeQuery();
            codigosModelos = new ArrayList<>();
            while (result.next())
                codigosModelos.add(result.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codigosModelos;
    }

}
