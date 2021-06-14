package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AficionesDAO {

    private Connection conn;

    public AficionesDAO(){
        this.conn = DBConn.conectar();
    }

    /**
     * Devuelve la lista de todas las aficiones almacenadas en la tabla aficiones
     * @return Mapa con el identificador de afición como indice y el nombre de la afición como valor
     */
    public HashMap<Integer,String> getAll(){
        HashMap<Integer,String> aficiones = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM aficiones").executeQuery();
            aficiones = new HashMap<>();
            while (result.next())
                aficiones.put(result.getInt("id"),result.getString("nombre"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aficiones;
    }

    /**
     * Devuelve una mapa de aficiones no asignadas para seleccionar
     * @param selec -> Lista de identificadores de afición del usuario de la sesión activa
     * @return Mapa con el identificador de afición como indice y el nombre de la afición como valor
     */
    public HashMap<Integer,String> getUnselected(List<Integer> selec){
        HashMap<Integer,String> aficiones = null;
        String clausulaWhere = "";
        if (selec.size() > 0) {
            clausulaWhere = "WHERE id not in (";
            int c = 0;
            for (Integer codigo : selec) {
                c++;
                clausulaWhere += codigo.toString();
                if (c < selec.size()) clausulaWhere += ",";
            }
            clausulaWhere += ")";
        }

        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM aficiones "+clausulaWhere).executeQuery();
            aficiones = new HashMap<>();
            while (result.next())
                aficiones.put(result.getInt("id"),result.getString("nombre"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aficiones;
    }


    /**
     * Devuelve una mapa de las aficiones pertenecientes al usuario de la sesión activa
     * @param selec -> Lista de identificadores de afición del usuario de la sesión activa
     * @return Mapa con el identificador de afición como indice y el nombre de la afición como valor
     */
    public HashMap<Integer,String> getSelected(List<Integer> selec){
        HashMap<Integer,String> aficiones = null;
        String cadena = "(";
        int c=0;
        for (Integer codigo:selec) {
            c++;
            cadena += codigo.toString();
            if (c<selec.size()) cadena += ",";
        }
        cadena += ")";

        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM aficiones WHERE id in "+cadena).executeQuery();
            aficiones = new HashMap<>();
            while (result.next())
                aficiones.put(result.getInt("id"),result.getString("nombre"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aficiones;
    }

    /**
     * Comprueba que una afición con determinado nombre existe en la tabla de aficiones
     * @return Verdadero si existe / Falso en caso contrario
     */
    public boolean exists(String aficion){
        try {
            ResultSet result =  conn.prepareStatement("SELECT nombre FROM aficiones WHERE nombre='"+aficion+"'").executeQuery();
            if (result.next())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }






}
