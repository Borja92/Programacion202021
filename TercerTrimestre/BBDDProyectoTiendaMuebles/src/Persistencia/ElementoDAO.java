package Persistencia;

import TiendaMuebles.Elemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ElementoDAO {
    private TipoElementoDAO tipoElementoDAO;
    private Connection conn;
   private DBConn dbConn;
    public ElementoDAO(){
        dbConn= new DBConn();
    }

    /*public boolean crear(Elemento elemento)
    public Elemento leer(String codigo)
    public int getId(String codigo)
    public Elemento getElementoById(int id)
    public boolean actualizar(String codigo, String nuevoCodigo)
    public boolean borrar(String codigo)*/

    public boolean crear(Elemento elemento) throws SQLException {
        String codigo;
        int id_tipo_elemento;
        conn = dbConn.conectar();
elemento= elemento.getElemento();
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento(codigo,id_tipo_elemento) VALUES ('" + elemento + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }



}
