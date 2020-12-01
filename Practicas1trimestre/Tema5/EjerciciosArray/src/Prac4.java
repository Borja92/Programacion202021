/*4. Escribir un programa que recoja de la entrada estándar dos arrays de
        enteros de tamaño especificado por el usuario y los multiplique
        dos a dos, guardando el resultado en otro array e imprimiendo
        los valores de este último array.*/

import java.util.Arrays;
import java.util.Scanner;

public class Prac4 {


    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        //Declaración de variables y arrays
        int[] array1;
        int[] array2;
        int[] arrayDeResultados;

        //Pedimos por teclado la logitud de los arrays
        System.out.println("Introduce longitud para los Arrays: ");
        int tamannoArray = src.nextInt();

        //Asignamos el tamaño de los arrays
        array1 = new int[tamannoArray];
        array2 = new int[tamannoArray];
        arrayDeResultados = new int[tamannoArray];

//Recorremos las posiciones de los arrays a la vez que almacenamos los valores pedidos por teclado
        for (int i = 0; i < tamannoArray; i++) {

            System.out.println("Introduce el valor del indice " + i + " del primer Array: ");
            array1[i] = src.nextInt();

            System.out.println("Introduce el valor del indice " + i + " del segundo Array: ");
            array2[i] = src.nextInt();
//Multiplicamos los valores de los arrays de los indices correspondientes y almacenamos el resultado en el array auxiliar
            arrayDeResultados[i] = array1[i] * array2[i];
        }
        System.out.println("Resultados: ");

        //Recorremos el array axualiar con los valores resultantes de las multiplicación y lo mostramos por pantalla
        for (int i = 0; i < tamannoArray; i++) {

            System.out.print("[" + arrayDeResultados[i] + "]");

        }


    }
}
