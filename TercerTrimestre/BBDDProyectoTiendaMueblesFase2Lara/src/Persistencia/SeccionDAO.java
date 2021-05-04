package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeccionDAO {
    Connection conn;

    public SeccionDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean crear(String seccion) {
        try {
            return conn.prepareStatement("INSERT INTO seccion (nombre) VALUES ('" + seccion + "')").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean exists(String nombre){
        try {
            ResultSet result = conn.prepareStatement("SELECT COUNT(nombre) FROM seccion WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next())
                return result.getInt(1) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(String seccion, String nuevoNombre) {
        try {
            return conn.prepareStatement("UPDATE seccion SET nombre='" + nuevoNombre + "' WHERE nombre='" + seccion + "'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            System.out.print(throwables.getMessage());
            return false;
        }
    }

    public boolean borrar(String nombre) {
        try {
            return conn.prepareStatement("DELETE FROM seccion WHERE nombre = '" + nombre + "'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            System.out.print(throwables.getMessage());
            return false;
        }
    }

    public int getId(String seccion) {
        try {
            ResultSet result = conn.prepareStatement("SELECT id FROM seccion WHERE nombre='" + seccion + "'").executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.print(throwables.getMessage());
        }
        return -1;
    }

    public String getSeccionById(int id){
        try {
            ResultSet result = conn.prepareStatement("SELECT nombre FROM seccion WHERE id = '"+id+"'").executeQuery();
            if (result.next()){
                return result.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<String> getAll(){
        List<String> secciones = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT nombre FROM seccion").executeQuery();
            secciones = new ArrayList<>();
            while (result.next())
                secciones.add(result.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return secciones;
    }

}
