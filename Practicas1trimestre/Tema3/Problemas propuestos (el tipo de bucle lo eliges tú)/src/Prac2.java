/*
2- Introducir N cadenas siendo N un no aleatorio entre 1 y 10 y decir cuál es la cadena de mayor longitud.
*/


import java.util.Random;
import java.util.Scanner;

public class Prac2 {

    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        String string1, aux = "";

        int numCadenas, longitudCadena, cadenaMasGrande=0;
        numCadenas= (int) (Math.random() * 10) + 1;
        System.out.println("Vámos a introducir "+numCadenas+ " cadenas de caracteres y comprobar cuál es la más larga");

for (int i=0; i<numCadenas;i++){
    System.out.println("Introduce la  cadena Nº "+(i+1)+": ");
    string1=src.nextLine();
longitudCadena=string1.length();

   if(longitudCadena>cadenaMasGrande){

       cadenaMasGrande=longitudCadena;
       aux=string1;

   }


}
        System.out.println("La cadena más larga es:  "+aux+".\nCon una logitud de "+cadenaMasGrande+" caracteres.");
    }
}
