package vista;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Avatar {


    public void mostrarAvataresDisponibles(HashMap<Integer,String> avatares)
    {
        System.out.println("Conjunto de Avatares");
        System.out.println("--------------------");
        for (Integer clave : avatares.keySet())
        {
            System.out.println(clave + ":"+ avatares.get(clave));
        }
        System.out.println("0: Salir");
        System.out.println("Elegir una opción:");
    }




}
