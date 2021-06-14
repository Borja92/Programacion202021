package persistencia;

import modelo.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    private Connection conn;

    public UsuariosDAO(){
        this.conn = DBConn.conectar();
    }

    /**
     * Comprueba si un email ya está registrado como email de usuario en la tabla usuarios
     * @param email -> Cadena que contiene el email a buscar
     * @return Verdadero si ya existe en la BD / Falso en caso contrario
     */
    public boolean exists(String email){
        try {
            ResultSet result =  conn.prepareStatement("SELECT user FROM usuarios WHERE email='"+email+"'").executeQuery();
            if (result.next())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Añade un nuevo usuario a la tabla de usuarios
     * @param user -> NickName del nuevo usuario
     * @param pass -> Contraseña
     * @param email -> Identificador del email de usuario
     * @return Verdadero si la creación se produce con éxito / Falso en caso contrario
     */
    public boolean crear(String user, String pass, String email){
        try {
            return conn.prepareStatement("INSERT INTO usuarios (user,password,email) VALUES ('"+user+"','"+pass+"','"+email+"')").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Comprueba si un email y contraseña dados existen como perfil de usuario en la tabla usuarios
     * @param email -> Dirección de email de usuari
     * @param pass -> Contraseña de usuario
     * @return Verdadero en caso de credenciales correctas del usuario - Falso en caso contrario
     */
    public int check(String email,String pass){
        try {
            ResultSet result =  conn.prepareStatement("SELECT id FROM usuarios WHERE email='"+email+"' AND password='"+pass+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * Carga los datos de un usuario basasdos en un modelo Usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return Modelo Usuario con los datos obtenidos de la BD
     */
    public modelo.Usuario loadUser(int id){
        try{
            ResultSet result = conn.prepareStatement("SELECT user,avatar,descripcion FROM usuarios WHERE id = '"+id+"'").executeQuery();
            if (result.next()){
                AvatarDAO avatarDAO = new AvatarDAO();
                modelo.Usuario usuario=new Usuario();
                usuario.setId(id);
                usuario.setUser(result.getString("user"));
                usuario.setAvatar(avatarDAO.getAll().get(result.getInt("avatar")));
                usuario.setDescription(result.getString("descripcion"));
                return usuario;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza el nickname de un usuario
     * @param newUsername -> Nuevo nickname a mostrar en el perfil de usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return El resultado de actualizar dicho nickname en la tabla usuarios (Verdadero si éxito / Falso en caso contrario)
     */
    public boolean actualizarNickname(String newUsername,Integer id){
        try{
            return conn.prepareStatement("UPDATE usuarios SET user = '"+newUsername+"' WHERE id = '"+id+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Actualiza el nickname de un usuario
     * @param descripcion -> Nueva descripción a mostrar en el perfil de usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return El resultado de actualizar dicha descripción en la tabla usuarios (Verdadero si éxito / Falso en caso contrario)
     */
    public boolean actualizarDescripcion(String descripcion,Integer id){
        try{
            return conn.prepareStatement("UPDATE usuarios SET descripcion = '"+descripcion+"' WHERE id = '"+id+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Actualiza el avatar de un usuario
     * @param avatar -> Nuevo identificador del avatar asignado a un perfil de usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return El resultado de actualizar dicho identificador de avatar en la tabla usuarios (Verdadero si éxito / Falso en caso contrario)
     */
    public boolean actualizarAvatar(Integer avatar ,Integer id){
        try{
            return conn.prepareStatement("UPDATE usuarios SET avatar = '"+avatar+"' WHERE id = '"+id+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Activa el semáforo de notificaciones de un usuario tras recibir una amistad
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return Verdadero si la actualización se realizó / Falso en caso contrario
     */
    public boolean notificarAmistad(Integer id){
        try{
            return conn.prepareStatement("UPDATE usuarios SET nuevosAmigos = 1 WHERE id = '"+id+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Desactiva el semáforo de notificaciones de nueva amistad
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return Verdadero si la actualización se realizó con éxito / Falso en caso contrario
     */
    public boolean desactivarNotificacionNuevaAmistad(Integer id){
        try{
            return conn.prepareStatement("UPDATE usuarios SET nuevosAmigos = 0 WHERE id = '"+id+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene la lista de usuarios a ofrecer como posibles nuevos amigos a un usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return Lista con los identificadores de todos los usuarios que no son amigos actualmente de un usuario
     * (Esta implementación por simplificación, lee todos los registros de la tabla usuarios, en un caso real con
     * gran cantidad de perfiles de usuario habría que obtener una sección limitada de usuarios desde la consulta,
     * usando (por ejemplo) un valor de pesos establecidos como un campo dentro el perfil de usuarios, pero ha sido
     * simplificado por no añadir dificultad a la implementación.
     */

    public List<Integer> getCandidatos(Integer id){
        List<Integer> candidatos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT id FROM usuarios WHERE id<>"+id+" AND NOT EXISTS " +
                    " (SELECT id FROM matches WHERE usuario1=usuarios.id OR usuario2=usuarios.id)").executeQuery();
            candidatos = new ArrayList<>();
            while (result.next())
                candidatos.add(result.getInt(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return candidatos;
    }


    /**
     * Notifica si se han incorporado nuevos usuarios a la lista de amigos de un usuario
     * @param id -> Identificador del usuario en la tabla usuarios
     * @return Verdadero si la se han incorporado nuevos usuarios / Falso en caso contrario
     */
    public boolean nuevosAmigos(Integer id){
        try {
            ResultSet result =  conn.prepareStatement("SELECT user FROM usuarios WHERE id="+id+" AND nuevosAmigos=1").executeQuery();
            if (result.next())
                return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * getIDsUsuarios
     * @return List<Usuario>
     */

public List<Integer> getIdUsuarios(){
List<Integer>listIdUsuarios= new ArrayList<>();
    try {
        ResultSet resultSet= conn.prepareStatement("SELECT * from usuarios").executeQuery();
while (resultSet.next()){

    listIdUsuarios.add(resultSet.getInt(1));
}

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
return listIdUsuarios;
}

}
