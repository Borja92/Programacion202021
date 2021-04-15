package Persistencia;

import TiendaMuebles.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloDAO {
    private Connection conn;
    private SeccionDAO seccionDAO;
    private CategoriaDAO categoriaDAO;
private DBConn dbConn;
    public ModeloDAO() {
        dbConn= new DBConn();
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


        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO modelo(codigo, id_seccion, id_categoria) VALUES ('" + modelo.getCodigo() + "','" + getIdSeccion() + "','" +modelo.getCategoria()+"')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;


    }
    private int getIdSeccion(String seccion){
        return seccionDAO.getId(seccion);
    }
    private int getIdCategoria(String categoria){
        return categoriaDAO.getId(categoria);
    }

}
