package negocio;

import persistencia.UsuariosDAO;
import vista.Mensajes;

/**
 * Clase para el Control de acceso e Inicio de sesión
 * @author Antonio Caballero
 */
public class Login {
    /**
     * Registra un nuevo usuario en el sistema utilizando el email como campo de ocurrencia única
     * @param user -> Nombre "NickName" a mostrar en el perfil del nuevo usuario
     * @param pass -> Contraseña empleada para acceder al sistema
     * @param email -> Dirección de email usada para el registro
     * @return Verdadero en caso de creación correcta del usuario - Falso en caso contrario
     */
    public boolean crear(String user, String pass, String email)
    {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        if (usuariosDAO.exists(email)) {
            Mensajes.mostrarMensaje("email_already_exists");
            return false;
        }
        return usuariosDAO.crear(user,pass,email);
    }

    /**
     * Comprueba la correspondencia de un email registrado con su contraseña
     * @param pass -> Contraseña de usuario
     * @param email -> Dirección de email de usuario
     * @return Verdadero en caso de creación correcta del usuario - Falso en caso contrario
     */
    public int check(String email, String pass)
    {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        return usuariosDAO.check(email,pass);
    }



}
