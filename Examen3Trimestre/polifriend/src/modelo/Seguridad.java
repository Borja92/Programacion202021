package modelo;


import java.util.Date;

/**
 * Esta clase se usa para propagar los datos de la sesión iniciada por un usuario
 * a través de la aplicación, la cual es pasada como parámetro de los constructores
 * de las clases de la lógica de negocio, para asegurar la identidad del usuario
 * de una sesión.
 * @author Antonio Caballero
 * @param
 * @return
 */
public class Seguridad {

    Integer userID;
    Date sessionStart;

    public Seguridad(Integer userID) {
        this.userID = userID;
        this.sessionStart = new Date(System.currentTimeMillis());
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
