package vista;

import java.util.HashMap;

public class Amigos {

    public void menuAmigos(boolean tick)
    {
        System.out.println("------------------------");
        System.out.println("MENU FRIENDS POLITECNICO");
        System.out.println("1. Ver Perfil");
        if (tick) System.out.println("2. Mensajes"+"\u001B[31m"+"*"+"\u001B[0m"); else  System.out.println("2. Mensajes");
        System.out.println("0. Volver al menú");
    }


    public void mostrarMisAmigos(HashMap<Integer,String> amigos)
    {
        System.out.println();
        System.out.println("Estos son tus amig@s");
        System.out.println("--------------------");
        for (Integer clave : amigos.keySet())
        {
            System.out.println(clave + ":"+ amigos.get(clave));
        }
    }


    public void menuEleccion()
    {
        System.out.println("------------------------------------------------");
        System.out.println("¿Deseas Añadir este Perfil a tu lista de Amig@s?");
        System.out.println("1. NO"+"\u001B[31m"+" -- "+"\u001B[0m"+" 2. SI (Let's be Friends)");
        System.out.println("0. Volver al menú");
    }


}
