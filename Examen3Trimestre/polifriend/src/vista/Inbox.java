package vista;

import modelo.MensajeChat;

import java.util.List;

public class Inbox {

    public void mostrarMensajes(List<MensajeChat> mensajes,Integer usuario)
    {
        System.out.println();
        System.out.println("Historial Mensajes");
        System.out.println("-------------------");
        String estado;
        for (MensajeChat msj : mensajes)
        {
            estado = "";
            if (msj.getRemitente()==usuario)  {  System.out.print("\u001B[32m"+"   "); }
            else { System.out.print("\033[1;34m"); if (msj.getEstado()==0) estado = " \u001B[31m"+"*"+"\u001B[0m";}

            System.out.println(msj.getTimestamp() + ":  "+ msj.getMensaje()+estado);
        }
        System.out.println("\u001B[0m");
    }



}

