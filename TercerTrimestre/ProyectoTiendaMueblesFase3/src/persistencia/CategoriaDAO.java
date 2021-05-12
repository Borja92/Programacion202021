package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection conn;

    public CategoriaDAO(Connection conn){
        this.conn = conn;
    }

    public boolean crear(String categoria){
        try {
            return conn.prepareStatement("INSERT INTO categoria(nombre) VALUES ('"+categoria+"')").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(String categoria, String nuevoNombre){
        try{
            return conn.prepareStatement("UPDATE categoria SET nombre = '"+nuevoNombre+"' WHERE nombre = '"+categoria+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
             throwables.printStackTrace();
        }
        return false;
    }

    public String getCategoriaById(int id){
        try{
            ResultSet result = conn.prepareStatement("SELECT nombre FROM categoria WHERE id = '"+id+"'").executeQuery();
            if (result.next()){
                return result.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getId(String categoria){
        try{
            ResultSet result = conn.prepareStatement("SELECT id FROM categoria WHERE nombre = '"+categoria+"'").executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public boolean borrar(String categoria){
        try{
            return conn.prepareStatement("DELETE FROM categoria WHERE nombre = '"+categoria+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean exists(String categoria){
        try {
            ResultSet result =  conn.prepareStatement("SELECT nombre FROM categoria WHERE nombre='"+categoria+"'").executeQuery();
            if (result.next())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<String> getAll(){
        List<String> categorias = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT nombre FROM categoria").executeQuery();
            categorias = new ArrayList<>();
            while (result.next())
                categorias.add(result.getString(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categorias;
    }
}
