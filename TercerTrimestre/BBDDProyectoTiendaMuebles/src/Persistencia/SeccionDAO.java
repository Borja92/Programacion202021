package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeccionDAO {
    private Connection conn;
    DBConn dbConn;
public SeccionDAO(){

    dbConn= new DBConn();
}

/*
    public boolean crear(String seccion)
    public boolean exists(String nombre)
    public boolean actualizar(String seccion, String nuevoNombre)
    public boolean borrar(String nombre)
    public int getId(String seccion)
    public String getSeccionById(int id)
    public List<String> getAll()
*/

    public boolean crear(String seccion) throws SQLException {
        conn = dbConn.conectar();

        //PreparedStatement statement = conn.prepareStatement("INSERT INTO categoria(nombre) VALUES ('" + categoria + "')", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO seccion(nombre) VALUES ('" + seccion + "')");
        int numFilas = statement.executeUpdate();
        //ResultSet result = statement.getGeneratedKeys();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

    public boolean exists(String nombre) throws SQLException {
       conn= dbConn.conectar();

        PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM seccion");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString(1).equalsIgnoreCase(nombre)) {
                return true;
            }

        }
        dbConn.desconectar();
        return false;
    }

    public boolean actualizar(String seccion, String nuevoNombre) throws SQLException {


       conn= dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE seccion SET nombre =" + "'" + nuevoNombre + "'" + " where nombre=" + "'" + seccion + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

    public boolean borrar(String nombre) throws SQLException {

      conn= dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM seccion WHERE nombre=" + "'" + nombre + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;

    }
    public int getId(String seccion){
        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM seccion WHERE nombre=" + "'" + seccion + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String secc = resultSet.getString(2);

                if (seccion.equalsIgnoreCase(secc)) {
                    indice = resultSet.getInt(1);

                } else return Integer.parseInt(null);

            }
            dbConn.desconectar();

        } catch (SQLException sqle) {
            System.out.println(indice);
        }
        return indice;
    }

    public String getSeccionById(int id) throws SQLException {

       conn=dbConn.conectar();
        String seccion = "";
        int indice;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM seccion WHERE id=" + "'" + id + "'");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            indice = resultSet.getInt(1);

            if (indice == id) {
                seccion = resultSet.getString(2);
                return seccion;
            }
        }
        dbConn.desconectar();
        return seccion + null;
    }

    public List<String> getAll(){
        List<String> seccionDAO = null;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT id, nombre  FROM seccion");
            ResultSet resultSet = statement.executeQuery();
if (resultSet.next()){
    seccionDAO= new ArrayList<>();
}
        while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                seccionDAO.add( id + nombre);
            }

        } catch (SQLException sqle) {
            seccionDAO=null;
        }
        return seccionDAO;

    }


}
