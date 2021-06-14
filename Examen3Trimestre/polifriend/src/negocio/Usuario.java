package negocio;

import modelo.Seguridad;
import persistencia.AficionesDAO;
import persistencia.AvatarDAO;
import persistencia.UsuarioAficionesDAO;
import persistencia.UsuariosDAO;
import vista.Aficiones;
import vista.Avatar;
import vista.Mensajes;

import java.util.HashMap;

/**
 * Clase que contiene la lógica de Negocio de Usuario
 *
 * @author Antonio Caballero
 */
public class Usuario {

    Seguridad loggedin;
    vista.Usuario vistaUsuario;
    modelo.Usuario me;

    /**
     * Constructor de clase
     *
     * @param seg -> Instancia de la clase seguridad con la identidad de inicio de sesión
     */
    public Usuario(Seguridad seg) {
        if (seg == null) {
            Mensajes.mostrarMensaje("not_auth");
        } else {
            loggedin = seg;
            me = cargarPerfil(getLoggedin().getUserID());
            vistaUsuario = new vista.Usuario();
        }
    }

    public Seguridad getLoggedin() {
        return loggedin;
    }

    public modelo.Usuario getMe() {
        return me;
    }

    /**
     * Método a ejecutar tras el inicio de sesión, se encarga de mostrar el perfil de usuario,
     * mostrar las notificaciones por Mensajes Recibidos y Registro de nueva Amistad.
     * Se muestran las opciones disponibles tras el inicio de sesión y se procesa la opción del menú elegida.
     */
    public void index() {
        do {
            vistaUsuario.mostrarPerfil(cargarPerfil(getLoggedin().getUserID()));
            if (nuevosAmigos(getLoggedin().getUserID())) Mensajes.mostrarMensaje("new_friends");
            if (new Inbox(getLoggedin()).notificaciones()) Mensajes.mostrarMensaje("new_notifications");
            vistaUsuario.mostrarOpcionesMenu();
        } while (ejecuta(Mensajes.menu()));
    }


    /**
     * Obtiene de la BD los datos necesarios para instanciar un objeto del modelo Usuario
     *
     * @param id -> Identificador de usuario del sistema
     * @return Un modelo Usuario  con todos sus datos del perfil indicado por parámetro.
     */
    public modelo.Usuario cargarPerfil(Integer id) {
        if (getLoggedin() != null) {
            modelo.Usuario usuario;
            UsuariosDAO usuariosDAO = new UsuariosDAO();
            UsuarioAficionesDAO usuarioAficionesDAO = new UsuarioAficionesDAO();

            usuario = usuariosDAO.loadUser(id);
            usuario.setAficiones(usuarioAficionesDAO.getAficionesUsuarioList(id));

            return usuario;
        }

        return null;
    }


    /**
     * Llama a la opción elegida en el menú de Usuario
     */
    public void editarPerfil() {
        int opcion;
        do {
            vistaUsuario.mostrarOpcionesEditar();
            opcion = Mensajes.menu();
            switch (opcion) {
                case 1 -> editarNickname();
                case 2 -> cambiarAvatar();
                case 3 -> cambiarDescripcion();
                case 4 -> addAficiones();
                case 5 -> deleteAficiones();
            }
        } while (opcion != 0);
        index();
    }

    /**
     * Llama al método asociado a la opción elegida del menú Amigos.
     *
     * @param opcion -> Número asociado a la opción elegida
     */
    private boolean ejecuta(int opcion) {
        switch (opcion) {
            case 1:
                editarPerfil();
                break;
            case 2:
                new Amigos(getLoggedin()).buscarNuevosAmigos();
                break;
            case 3:
                new Amigos(getLoggedin()).mostrarAmigos();
                break;
        }
        return (opcion != 0);
    }


    /**
     * Edita el nickname del atributo de clase del modelo Usuario instanciado con el usuario
     * autentificado en la sesión.
     * El cambio se almacena también en el perfil de usuario en la BD
     */
    private void editarNickname() {
        String nickName = Mensajes.requestString("Introduzca un nuevo Nickname:");
        if (nickName != null) {
            getMe().setUser(nickName);
            new UsuariosDAO().actualizarNickname(nickName, getLoggedin().getUserID());
        }

    }

    /**
     * Edita el valor del avatar, en el atributo de clase del modelo Usuario instanciado con el usuario
     * autentificado en la sesión.
     * El cambio se almacena también en el perfil de usuario en la BD
     */
    private void cambiarAvatar() {
        int opcion;
        Avatar vistaAvatar = new Avatar();
        HashMap<Integer, String> avatares = new AvatarDAO().getAll();
        vistaAvatar.mostrarAvataresDisponibles(avatares);
        opcion = Mensajes.menu();
        if (opcion != 0) {
            getMe().setAvatar(opcion);
            getMe().setAvatar(avatares.get(opcion));
            new UsuariosDAO().actualizarAvatar(opcion, getLoggedin().getUserID());
        }
    }


    /**
     * Edita la descripción del atributo de clase del modelo Usuario instanciado con el usuario
     * autentificado en la sesión.
     * El cambio se almacena también en el perfil de usuario en la BD
     */
    private void cambiarDescripcion() {
        String des = Mensajes.requestString("Introduzca una nueva Descripción:");
        if (des != null) {
            getMe().setDescription(des);
            new UsuariosDAO().actualizarDescripcion(des, getLoggedin().getUserID());
        }

    }

    /**
     * Añade una afición de la lista de aficiones disponibles al perfil del usuario autentificado en la sesión
     * El cambio se almacena también en el perfil de usuario en la BD
     */
    private void addAficiones() {
        AficionesDAO aficionesDAO = new AficionesDAO();
        System.out.println(aficionesDAO.getAll().toString());
        System.out.println("Elije una opción entre las aficiones disponibles[OPCION]:");

        int opcion = Mensajes.menu();
        UsuarioAficionesDAO usuarioAficionesDAO = new UsuarioAficionesDAO();
        if (usuarioAficionesDAO.addAficion(opcion, getMe().getId())){
            System.out.println("Afición añadida!!");
        } else System.out.println("No se ha añadido ninguna afición!");
    }

    /**
     * Elimina una afición de la lista de aficiones asignadas al perfil del usuario autentificado en la sesión
     * El cambio se almacena también en el perfil de usuario en la BD
     */
    private void deleteAficiones() {

        UsuarioAficionesDAO usuarioAficionesDAO = new UsuarioAficionesDAO();
        System.out.println("Aficones del Usuario: " + getMe().getUser() + "\n" +
                "ID:"+usuarioAficionesDAO.getAficionesUsuarioList(getMe().getId())+"\n" +
                "Nombres:"+getMe().getAficiones());
        int opcion = Mensajes.menu();
        if (usuarioAficionesDAO.deleteAficion(opcion, getMe().getId())){
           System.out.println("La afición ha sido elimida!");
       } else System.out.println("No se ha elinado ninguna afición!");
    }

    /**
     * Devuelve el valor del semaforo empleado para marcar si un usuario ha sido añadido en la lista de amigos
     * de otro usuario.
     *
     * @param id Identificador de Usuario
     * @return Verdadero/Falso
     */
    private boolean nuevosAmigos(Integer id) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        return usuariosDAO.nuevosAmigos(id);
    }

}
