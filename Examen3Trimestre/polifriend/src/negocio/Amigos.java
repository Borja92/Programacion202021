package negocio;

import modelo.Seguridad;
import persistencia.AmigosDAO;
import persistencia.UsuariosDAO;
import vista.Mensajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Amigos {

    private final int NUM_PERFILES_ELECCION=3;
    private Seguridad loggedin;
    private vista.Amigos vistaAmigos;

    /**
     * Constructor de clase
     * @param seg -> Instancia de la clase seguridad con la identidad de inicio de sesión
     */
    public Amigos(Seguridad seg)
    {
        if (seg==null)
        {
            Mensajes.mostrarMensaje("not_auth");
        }
        else {
            loggedin = seg;
            vistaAmigos=new vista.Amigos();
        }
    }

    public Seguridad getLoggedin() {
        return loggedin;
    }

    /**
     * Escoge un elemento al azar de una lista pasada por parámetro
     * @param list -> Lista de enteros
     * @return El elemento
     */
    public int escogeAlAzar(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Genera una lista aleatoria de candidatos a amigo obtenida de la BD
     * @return Una lista de identificadores de usuarios de longitud denfinida en una
     * constante declarada en la clase
     */
    public List<Integer> generarListaCandidatos() {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List<Integer> listaCandidatos = usuariosDAO.getCandidatos(getLoggedin().getUserID());
        List<Integer> listaElegidos = new ArrayList<>();
        Integer i;
        for (int c = 0; c < NUM_PERFILES_ELECCION; c++) {
            i = escogeAlAzar(listaCandidatos);
            listaElegidos.add(i);
            listaCandidatos.remove(i);
        }
        return listaElegidos;
    }

    /**
     * Muestra los perfiles de usuario de una lista de identificadores para la eleccion por parte
     * del usuario de dicho perfil a su lista de amigos
     * @param lista -> Lista de identificadores de usuario
     */
    public void elegirAmigos(List<Integer> lista) {
        int opcion;
        for (Integer usuario : lista)
        {
            new vista.Usuario().mostrarPerfil(new negocio.Usuario(getLoggedin()).cargarPerfil(usuario));
            vistaAmigos.menuEleccion();
            opcion = Mensajes.menu();
            if (opcion==0) break;
            if (opcion==2) addToAmigosList(usuario);
        }
    }

    /**
     * Activa el semáforo para la notificación de nueva amistad tras recibirse una nueva amistad
     * por parte de otro usuario
     * @param activar -> Valor del semáforo
     * @param usuario -> Identificador de usuario
     * @return Verdadero en caso de la actualización con éxito en BD - Falso en caso contrario
     */
    public boolean activarNotificacionNuevaAmistad(boolean activar,Integer usuario)
    {
        if (activar) {
            UsuariosDAO usuariosDAO = new UsuariosDAO();
            return usuariosDAO.notificarAmistad(usuario);
        }
        return false;
    }

    /**
     * Añade un usuario a la lista de amigos del perfil activo
     * @param usuario -> Identificador de usuario a añadir
     * @return Verdadero en caso de la actualización con éxito en BD - Falso en caso contrario
     */
    public boolean addToAmigosList(Integer usuario)
    {
        AmigosDAO amigosDAO = new AmigosDAO();
        return activarNotificacionNuevaAmistad(amigosDAO.establecerAmistad(getLoggedin().getUserID(),usuario),usuario);
    }

    /**
     * Genera una lista de candidatos para añadirlos o no como amigos
     */
    public void buscarNuevosAmigos()
    {
        elegirAmigos(generarListaCandidatos());
    }

    /**
     * Añade un asterisco rojo a la lista de amigos que hayan enviado un mensaje y no haya sido Leidos
     * @param lista -> Mapa con la lista de amigos del usuario identificado en la sesión
     * @return Una nueva lista con los amigos con notificación marcados
     */
    public HashMap<Integer,String> addNotificacionesAmigos(HashMap<Integer,String> lista)
    {
        HashMap<Integer,String> listaAmigos = new HashMap<>();
        String nickname;
        Inbox inbox = new Inbox(getLoggedin());
        for (Integer key : lista.keySet()) {
            nickname=lista.get(key);
            if (inbox.mensajesNoLeidos(key)) nickname+="\u001B[31m"+"*"+"\u001B[0m";
            listaAmigos.put(key,nickname);
        }
        return listaAmigos;
    }


    /**
     * Muestra la lista de amigos y el menú de selección correspondiente
     */
    public void mostrarAmigos() {
        int rdo;
        AmigosDAO amigosDAO = new AmigosDAO();
        HashMap<Integer, String> listaAmigos;
        do {
            listaAmigos = addNotificacionesAmigos(amigosDAO.getAll(getLoggedin().getUserID()));
            vistaAmigos.mostrarMisAmigos(listaAmigos);
            new UsuariosDAO().desactivarNotificacionNuevaAmistad(getLoggedin().getUserID());
            rdo = menuAmigos(amigosDAO.getAll(loggedin.getUserID()));
         }while (rdo!=0);
//        Usuario usuario = new Usuario(getLoggedin());
//        usuario.index();
    }


    /**
     * Escoge un elemento al azar de una lista pasada por parámetro
     * @param amigos -> Mapa con el identificador de usuario como indice y Nickname como valor
     * @return El elemento identificador de usuario elegido
     */
    public int menuAmigos(HashMap<Integer,String> amigos)
    {
        int opcion,usuario;
        do {
            System.out.print("Selecciona a un amigo: (0 Para salir)");
            usuario = Mensajes.menu();
            if ((usuario!=0) && (!amigos.containsKey(usuario))) Mensajes.mostrarMensaje("code_dont_apply_friendlist");
        }  while (!amigos.containsKey(usuario) && usuario!=0);
        if (usuario!=0) {
            Inbox inbox = new Inbox(getLoggedin());
            do {
                vistaAmigos.menuAmigos(inbox.mensajesNoLeidos(usuario));
                opcion = Mensajes.menu();
                switch (opcion) {
                    case 1:
                        new vista.Usuario().mostrarPerfil(new negocio.Usuario(getLoggedin()).cargarPerfil(usuario));
                        break;
                    case 2:
                        new vista.Inbox().mostrarMensajes(inbox.leerMensajes(usuario), getLoggedin().getUserID());
                        inbox.actualizarMensajesLeidos(usuario);
                        inbox.enviarMensaje(usuario);
                        break;
                }
            } while (opcion != 0);
        }
        return usuario;
    }



}

