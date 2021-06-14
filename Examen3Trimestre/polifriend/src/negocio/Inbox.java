package negocio;

import modelo.MensajeChat;
import modelo.Seguridad;
import persistencia.InboxDAO;
import vista.Mensajes;

import java.util.List;

public class Inbox {

    InboxDAO inboxDAO = new InboxDAO();
    Seguridad loggedin;
    //vista.Inbox vistaInbox;

    public Inbox(Seguridad seg)
    {
        if (seg==null)
        {
            Mensajes.mostrarMensaje("not_auth");
        }
        else {
            loggedin = seg;
            //vistaInbox=new vista.Amigos();
        }
    }

    public Seguridad getLoggedin() {
        return loggedin;
    }


    public boolean enviarMensaje(int destinatario){
        String msg = Mensajes.requestString("Escriba su mensaje (ENTER para salir): ");
        return inboxDAO.crear(loggedin.getUserID(),destinatario,msg);
    }



    public List<MensajeChat> leerMensajes(int destinatario){
        return inboxDAO.leer(loggedin.getUserID(),destinatario);
    }


    public boolean notificaciones()
    {
       return inboxDAO.notificacionesPendientes(getLoggedin().getUserID());
    }

    public boolean mensajesNoLeidos(int remitente)
    {
        return inboxDAO.mensajesNoLeidos(remitente,getLoggedin().getUserID());
    }

    public boolean actualizarMensajesLeidos(int remitente)
    {
        return inboxDAO.actualizarMensajesLeidos(remitente,loggedin.getUserID());

    }

}
