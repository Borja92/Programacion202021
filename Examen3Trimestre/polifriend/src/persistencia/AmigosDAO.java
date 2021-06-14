package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AmigosDAO {

    private Connection conn;

    public AmigosDAO(){
        this.conn = DBConn.conectar();
    }

    /**
     * Devuelve la lista de todos los amigos correspondientes a un usuario
     * @param id El identificador de usuario
     * @return Mapa con el identificador de usuario como indice y su nombre como valor
     * Debido a que no se diferencia entre que usuario agrege a otro como amigo o viceversa,
     * es decir, no se diferencia que A agrege B o B agrega A.
     * Por tanto, para comprobar que dos usuarios son amigos, hay que comprobar si A es amigo de B
     * o B es amigo de A
     */
    public HashMap<Integer,String> getAll(Integer id){
        HashMap<Integer,String> amigos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT usr1.id as id1,usr2.id as id2,usr1.user as user1,usr2.user as user2 FROM matches m INNER JOIN usuarios usr1" +
                    " on m.usuario1=usr1.id INNER JOIN usuarios usr2 on m.usuario2=usr2.id WHERE usuario1="+id+" OR usuario2="+id).executeQuery();
            amigos = new HashMap<>();
            while (result.next())
                if (id==result.getInt("id1"))
                    amigos.put(result.getInt("id2"),result.getString("user2"));
                else
                    amigos.put(result.getInt("id1"),result.getString("user1"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return amigos;
    }

    /**
     * Establece la amistad entre dos usuarios
     * @param solicitante -> Identificador de usuario que inicia la amistad
     * @param destinatario -> Identificador de usuario que recibe la amistad
     * @return Verdadero si se almacena con éxito / Falso en caso contrario
     */
    public boolean establecerAmistad(Integer solicitante, Integer destinatario){
            try {
                return conn.prepareStatement("INSERT INTO matches (usuario1,usuario2) VALUES (" + solicitante + "," + destinatario + ")").executeUpdate() == 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
         return true;
    }


}
