/*5. Crear un programa en Java en el que se almacenen 10 números introducidos por
        teclado en un array.
        Una vez introducidos, se desean mostrar todos los números ignorando los duplicados.*/

import java.util.Scanner;

public class Prac5 {

    static  boolean valorRepetido(int x, int [ ] array){
        boolean resultado = false;
        int valor = array[x];
        for (int i=x-1;i>=0;i--)
        {
            resultado = valor == array[i];
            if (resultado) break;
        }
        return resultado;
    }

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        final int N=10;
        int[] miArray = new int[10];
        int indice;

        for (  indice=0; indice<miArray.length; indice++) {

            System.out.println("Introduce un valor para almacenar en el array: ");
           miArray[indice]= src.nextInt();
        }

        for (int i = 0; i <N ; i++) {
            if (!valorRepetido(i,miArray)){

                System.out.print(miArray[i]+" ");
            }

        }

        }

    }



