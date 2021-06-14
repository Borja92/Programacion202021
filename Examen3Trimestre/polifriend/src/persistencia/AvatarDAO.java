package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AvatarDAO {


    private Connection conn;

    public AvatarDAO(){
        this.conn = DBConn.conectar();
    }


    /**
     * Devuelve la lista de todas las aficiones almacenadas en la tabla aficiones
     * @return Mapa con el identificador del avatar como indice y la figura del avatar como valor
     */
    public HashMap<Integer,String> getAll(){
        HashMap<Integer,String> avatares = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM avatar").executeQuery();
            avatares = new HashMap<>();
            while (result.next())
                avatares.put(result.getInt("id"),result.getString("avatar"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return avatares;
    }

}
