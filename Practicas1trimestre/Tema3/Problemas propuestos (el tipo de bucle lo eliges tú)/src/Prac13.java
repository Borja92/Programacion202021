/*
13- Escribir un programa que lea una fecha “dd/mm/aaaa”.
        Por ejemplo, 08/10/2014 y debe visualizar 8 de octubre de 2014.
        Además nos indicara si el año es bisiesto o no.

        Un año es bisiesto si se cumple:
        Si es divisible por 4 y no por 100
        Caso de ser divisible por 100 que lo sea también por 400
*/


import java.util.GregorianCalendar;
import java.util.Scanner;

public class Prac13 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in).useDelimiter("/");
        GregorianCalendar calendario = new GregorianCalendar();

        System.out.println("Introduce una fecha con el siguiente formato dd/mm/aaaa");

        String fechaUsuario= src.nextLine();

String dia=fechaUsuario.substring(0,2);
String mes=fechaUsuario.substring(3,5);
String anno=fechaUsuario.substring(6,10);



        if (mes.equals("01") ){
            mes = "enero";
        }
        if (mes.equals("02")){
            mes = "febrero";
        }
        if (mes.equals("03")){
            mes = "marzo";
        }
        if (mes.equals("04")){
            mes = "abril";
        }
        if (mes.equals("05")){
            mes = "mayo";
        }
        if (mes.equals("06")){
            mes = "junio";
        }
        if (mes.equals("07")){
            mes = "julio";
        }
        if (mes.equals("08")){
            mes = "agosto";
        }
        if (mes.equals("09")){
            mes = "septiembre";
        }
        if (mes.equals("10")){
            mes = "octubre";
        }
        if (mes.equals("11")){
            mes = "noviembre";
        }
        if (mes.equals("12")){
            mes = "diciembre";
        }




      /*  if ((anno % 4 == 0) && ((anno % 100 != 0) || (anno % 400 == 0)))
            System.out.println("El año es bisiesto");
        else
            System.out.println("El año no es bisiesto");*/

        System.out.println("\n"+dia+" de "+mes+" del " +anno);
if (calendario.isLeapYear(Integer.parseInt(anno))){
    System.out.println("\nEl año es bisiesto!!");
} else {

    System.out.println("\nEl año no es bisiesto!!");
}

    }

}
