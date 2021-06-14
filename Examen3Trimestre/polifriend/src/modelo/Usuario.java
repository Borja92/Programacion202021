package modelo;

import persistencia.AficionesDAO;
import persistencia.UsuarioAficionesDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que implementa el modelo de un Usuario del sistema.
 * Un usuario consta de los siguientes elementos:
 *  - user : NickName del Usuario (Es el nombre que se muestra a los demás usuarios)
 *  - password : contraseña para autentificación del usuario.
 *  - email : dirección de correo del usuario
 *  - id : identificador el usuario en el sistema
 *  - idAvatar : identificador del Avatar del usuario
 *  - avatar : Para agilizar el mostrado del avatar, se almacena en el mismo objeto.
 *  - description : Pequeña descripción personal del usuario
 *  - aficiones: Contiene la lista de aficiones del usuario
 * @author Antonio Caballero
 */
public class Usuario {

    String user;
    String password;
    String email;
    Integer id;
    Integer idAvatar;
    String avatar;
    String description;
    List<String> aficiones;


    public Integer getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(Integer idAvatar) {
        this.idAvatar = idAvatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        if (avatar == null) return "Avatar no definido - Complete su perfil";
        else return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.idAvatar = avatar;
    }

    public String getDescription() {
        if (description == null) return "Descripción No definida - Complete su perfil";
        else return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    /**
     * Setter de la lista aficiones a partir de los valores de los identificadores numéricos
     * de una lista de aficiones para almacenar su lista de texto asociado a dichos identificadores.
     * @param aficiones -> La lista numérica de identificadores de aficiones
     * @return Lista con las cadenas asociadas a los distintos identificadores
     */
    public void setAficiones(List<Integer> aficiones) {
        this.aficiones= new ArrayList<>();
        UsuarioAficionesDAO usuarioAficionesDAO = new UsuarioAficionesDAO();
        AficionesDAO aficionesDAO = new AficionesDAO();
        HashMap<Integer,String> mapaAficiones = aficionesDAO.getAll();
        for (Integer aficion: usuarioAficionesDAO.getAficionesUsuarioList(getId())) {
            getAficiones().add(mapaAficiones.get(aficion));
        }
    }


}
