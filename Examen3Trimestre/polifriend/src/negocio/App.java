package negocio;

import modelo.Seguridad;
import persistencia.UsuariosDAO;
import vista.Mensajes;

import java.util.regex.Pattern;

/**
 * Clase principal del proyecto que contiene el método main para su ejecución
 * @author Antonio Caballero
 * @date 2021-05-18
 */
public class App {

    private Seguridad loggedin;
    private Login login;
    private vista.App vista = new vista.App();


    private void ejecuta(int opcion)
    {
        switch (opcion) {
                         case 1:    registrar();
                                    break;
                         case 2:    iniciarSesion();
                                    break;
        }
    }

    private void registrar()
    {
        modelo.Usuario nuevoUsuario = vista.getValoresRegistro();
        String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
        if (Pattern.matches(EMAIL_VERIFICATION,nuevoUsuario.getEmail())) {
            Login login = new Login();
            if (login.crear(nuevoUsuario.getUser(), nuevoUsuario.getPassword(), nuevoUsuario.getEmail())) {
                Mensajes.mostrarMensaje("registration_sucessful");
            } else {
                Mensajes.mostrarMensaje("error_user_creation");
            }
        } else Mensajes.mostrarMensaje("email_format_not_valid");
    }


    private void iniciarSesion()
    {
        modelo.Usuario nuevoUsuario = vista.getValoresLogin();
        Login login = new Login();
        int id = login.check(nuevoUsuario.getEmail(), nuevoUsuario.getPassword());
        if (id>0) {
            this.loggedin = new Seguridad(id);
            Mensajes.mostrarMensaje("login_ok");
            Usuario usuario = new Usuario(getLoggedin());
            usuario.index();
        }
        else {
            Mensajes.mostrarMensaje("login_ko");
        }
    }

    public Seguridad getLoggedin() {
        return loggedin;
    }

    /**
     * Metodo main del proyecto
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
        int opcion=-1;
        do
            {
                opcion = app.vista.menu();
                app.ejecuta(opcion);
            }
        while (opcion!=0 && app.getLoggedin()==null);
        app.vista.salida();


       /* UsuariosDAO usuariosDAO= new UsuariosDAO();
        System.out.println(usuariosDAO.getIdUsuarios());*/
    }


}
