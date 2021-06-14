package persistencia;

import modelo.MensajeChat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InboxDAO {


    private Connection conn;

    public InboxDAO(){
        this.conn = DBConn.conectar();
    }

    /**
     * Almacena un mensaje nviado por un usuario remitente a un amigo destinatario
     * @param remitente -> Identificador de usuario remitente del mensaje
     * @param destinatario -> Identificador de usuario destinatario del mensaje
     * @param mensaje -> Identificador de usuario remitente del mensaje
     * @return Un modelo Usuario  con todos sus datos del perfil indicado por parámetro.
     */
    public boolean crear(Integer remitente, Integer destinatario, String mensaje){
        if (mensaje!=null) {
            try {
                return conn.prepareStatement("INSERT INTO inbox (remitente,destinatario,mensaje) VALUES (" + remitente + "," + destinatario + ",'" + mensaje + "')").executeUpdate() == 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        } return true;
    }

    /**
     * Almacena un mensaje nviado por un usuario remitente a un amigo destinatario
     * @param user1 -> Identificador de usuario remitente del mensaje
     * @param user2 -> Identificador de usuario destinatario del mensaje
     * @return Una lista de los mensajes  enviados entre dos usuarios.
     */
    public List<MensajeChat> leer(Integer user1, Integer user2){
        List<MensajeChat> mensajes = new ArrayList<>();
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM inbox WHERE (remitente="+user1+" AND destinatario="+user2+") " +
                    " OR (remitente="+user2+" AND destinatario="+user1+") order by fecha").executeQuery();
            while (result.next())
                    mensajes.add(new MensajeChat(result.getInt("remitente"),result.getString("mensaje"),result.getTimestamp("fecha"),result.getInt("estado")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mensajes;
    }

    /**
     * Devuelve un valor booleano que indica si un usuario tiene mensajes no leidos de cualquier usuario amigo
     * @param destinatario -> Identificador de usuario receptor del mensaje
     * @return Verdadero si el destinatario tiene mensajes no leidos / Falso en caso contrario
     */
    public boolean notificacionesPendientes(Integer destinatario){
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM inbox WHERE destinatario="+destinatario+" AND estado=0").executeQuery();
            while (result.next())
                return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    /**
     * Devuelve un valor booleano que indica si un usuario tiene mensajes no leidos de un determinado usuario amigo
     * @param remitente -> Identificador de usuario que envia el mensaje
     * @param destinatario -> Identificador de usuario receptor del mensaje
     * @return Verdadero si el destinatario tiene mensajes no leidos / Falso contrario
     */
    public boolean mensajesNoLeidos(Integer remitente,Integer destinatario){
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM inbox WHERE  remitente="+remitente+" AND destinatario="+destinatario+" AND estado=0").executeQuery();
            while (result.next())
                return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }

    /**
     * Establece el valor del estado de los mensajes enviados de un usuario a otro como Leidos
     * @param remitente -> Identificador de usuario que envia el mensaje
     * @param destinatario -> Identificador de usuario receptor del mensaje
     * @return Verdadero si la actualización tuvo éxito / Falso contrario
     */
    public boolean actualizarMensajesLeidos(Integer remitente, Integer destinatario){
            try {
                return conn.prepareStatement("UPDATE inbox SET estado=1 where remitente="+remitente+" AND destinatario="+destinatario).executeUpdate() == 1;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;

    }

}
