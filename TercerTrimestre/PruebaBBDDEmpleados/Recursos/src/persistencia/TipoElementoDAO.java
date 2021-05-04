package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoElementoDAO {
    private Connection conn;

    public TipoElementoDAO(Connection conn){
        this.conn = conn;
    }

    public boolean crear(String nombre){
        try {
            return (conn.prepareStatement("INSERT INTO tipo_elemento(nombre) VALUES ('"+nombre+"')").executeUpdate()==1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public String getTipoElementoById(int id){
        try {
            ResultSet result = conn.prepareStatement("SELECT nombre FROM tipo_elemento WHERE id = '"+id+"'").executeQuery();
            if (result.next())
                return result.getString(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getId(String nombre){
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM tipo_elemento WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next()){
                return result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public boolean actualizar(String nombre, String nuevoNombre){
        try {
            return conn.prepareStatement("UPDATE tipo_elemento SET nombre='"+nuevoNombre+"' WHERE nombre = '"+nombre+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<String> getAll(){
        List<String> tiposElementos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT nombre FROM tipo_elemento").executeQuery();
            tiposElementos = new ArrayList<>();
            while(result.next())
                tiposElementos.add(result.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tiposElementos;
    }

    public boolean exists(String tipoElemento){
        try{
            ResultSet result = conn.prepareStatement("SELECT COUNT(nombre) FROM tipo_elemento WHERE nombre='"+tipoElemento+"'").executeQuery();
            if (result.next())
                return result.getInt(1) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean borrar(String nombre){
        try {
            return conn.prepareStatement("DELETE FROM tipo_elemento WHERE nombre = '"+nombre+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
