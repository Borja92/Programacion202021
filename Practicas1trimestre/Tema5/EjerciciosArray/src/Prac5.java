/*5. Crear un programa en Java en el que se almacenen 10 números introducidos por
        teclado en un array.
        Una vez introducidos, se desean mostrar todos los números ignorando los duplicados.*/

import java.util.Scanner;

public class Prac5 {

    //Comprobamos si el valor se repite pasando por parámetros un array
   private    boolean valorRepetido(int x, int [ ] array){
        boolean numeroRepetido = false;
        int valor = array[x];
        for (int i=x-1;i>=0;i--)
        {
            numeroRepetido = valor == array[i];
            if (numeroRepetido) break;
        }
        return numeroRepetido;
    }

    public static void  main(String[] args) {

          Prac5 prac5 = new Prac5();

        Scanner src = new Scanner(System.in);

        //Definimos una constante que será la que determine cuántos valores tendrá el array
        final int N=10;

      //Definimos el array y variables
        int[] miArray = new int[10];

//Con un for recorremos el array e introducimos los valores pedidos por consola
        for (  int i=0; i<miArray.length; i++) {

            System.out.println("Introduce un valor para almacenar en el array: ");
           miArray[i]= src.nextInt();
        }
//Recorremos de nuevo el array, y usando el metodo valorRepetido, descartamos los valores repetidos y mostramos los valores obviando estos
        for (int i = 0; i <N ; i++) {
            if (!prac5.valorRepetido(i,miArray)){

                System.out.print(miArray[i]+" ");
            }

        }

        }

    }



