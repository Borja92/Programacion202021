/*Escribe un Programa en Java que lea una cadena por teclado y genere una excepción en el caso de que la cadena sea vacia.*/

import java.util.Scanner;

public class Ejemplo4 {
    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        String cadena;

        try {


            System.out.println("Introduce una cadena de caracteres y comprobaremos si está vacía o no: ");
            cadena = src.nextLine();
            if (!cadena.equals("")) {

         //   throw new Exception("Cadena introducida: " + cadena);
                System.out.println("Cadena introducida: " + cadena);
        } else {

                throw  new Exception("La cadena está vacía");
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());        }


    }




/*
    String cadena;
    Exception miExceptionCadenaVacia = new Exception("Error: La cadena es vacia");
    Scanner entrada_teclado = new Scanner(System.in);
        System.out.println("Introduce una cadena");
    cadena=entrada_teclado.nextLine();

        try
    {
        if (cadena.equals("")) throw miExceptionCadenaVacia;

    }
        catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
*/




}
