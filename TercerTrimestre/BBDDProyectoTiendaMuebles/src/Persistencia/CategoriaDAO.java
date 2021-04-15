package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conn;
    DBConn dbConn;


    public CategoriaDAO() {

        dbConn = new DBConn();
    }
/*
    public boolean crear(String categoria)
    public boolean actualizar(String categoria, String nuevoNombre)
    public String getCategoriaById(int id)
    public int getId(String categoria)
    public boolean borrar(String categoria)
    public boolean exists(String categoria)
    public List<String> getAll(){}
*/

    public boolean crear(String categoria) throws SQLException {
        conn = dbConn.conectar();

        //PreparedStatement statement = conn.prepareStatement("INSERT INTO categoria(nombre) VALUES ('" + categoria + "')", Statement.RETURN_GENERATED_KEYS);
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO categoria(nombre) VALUES ('" + categoria + "')");
        int numFilas = statement.executeUpdate();
        //ResultSet result = statement.getGeneratedKeys();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;
    }

    public boolean actualizar(String categoria, String nuevoNombre) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("UPDATE categoria SET nombre =" + "'" + nuevoNombre + "'" + " where nombre=" + "'" + categoria + "'");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }

    public List<String> getAll()  {
        List<String> categoriaDAOS = new ArrayList<>();
        try {
            conn = dbConn.conectar();


            PreparedStatement statement = conn.prepareStatement("SELECT id, nombre, dni  FROM categoria");
           /* if (!statement.execute()) {//No sé cómo gestionar, el devolver un null si la sentecia falla
                return null;
            }*/


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                categoriaDAOS.add("id: " + id + " Nom.Categoría: " + nombre);
            }

        } catch (SQLException sqle) {
            System.out.println((String) null);
        }
        return categoriaDAOS;

    }

    public String getCategoriaById(int id) throws SQLException {
        conn = dbConn.conectar();
        String categoria = "";
        int indice;
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM categoria WHERE id=" + "'" + id + "'");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            indice = resultSet.getInt(1);

            if (indice == id) {
                categoria = resultSet.getString(2);
                return categoria;
            }
        }

        dbConn.desconectar();
        return categoria + null;
    }

    public int getId(String categoria)  {
        int indice = -1;
        try {
            conn = dbConn.conectar();

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM catAgoria WHERE nombre=" + "'" + categoria + "'");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cat = resultSet.getString(2);

                if (categoria.equalsIgnoreCase(cat)) {
                    indice = resultSet.getInt(1);

                } else return Integer.parseInt(null);

            }
            dbConn.desconectar();


        } catch (SQLException sqle) {
            System.out.println(indice);
        }
        return indice;
    }

    public boolean exists(String categoria) throws SQLException {
        conn = dbConn.conectar();

        PreparedStatement statement = conn.prepareStatement("SELECT nombre FROM categoria");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getString(1).equalsIgnoreCase(categoria)) {
                return true;
            }

        }
        dbConn.desconectar();
        return false;
    }

    public boolean borrar(String categoria) throws SQLException {
        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM categoria WHERE nombre=" + "'" + categoria + "'");
        int valor = statement.executeUpdate();
        dbConn.desconectar();
        if (valor > 0) {
            return true;
        }
        return false;
    }


}
