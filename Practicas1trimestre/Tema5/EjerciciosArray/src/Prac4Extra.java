/*4. Escribe un programa que ordene los números de un vector. Utilizar el algoritmo de la
        burbuja y probarlo sobre los vectores [4,3,2,1] y [3,2,1,4]. Algoritmo de la burbuja
        (bubblesort) en pseudocódigo for i from 1 to n for j from i to 2 if (A[j ] < A[j - 1])
        intercambiar los valores entre A[j ] y A[j - 1]*/

import java.util.Arrays;

public class Prac4Extra {

    //Método de ordenación burbuja ascendente
    int[] burbujaAscendente(int[] array) {

        int aux;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length-1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;

    }

    //Método de ordenación burbuja descendente
    int[] burbujaDescendente(int[] array) {
        int aux;
        for (int i =0; i < array.length; i++) {
            for (int j = 0; j < array.length -i - 1; j++) {

                if (array[j + 1] > array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }

    int[][] burbujaAscendenteParaMatrizBideimensional(int[][] matriz) {

        int x, y;
        burbujaAscendente(matriz[0]);
        burbujaAscendente(matriz[1]);

        return matriz;

    }

    int[][] burbujaDescendenteParaMatrizBideimensional(int[][] matriz) {
        int x, y;
        burbujaDescendente(matriz[0]);
        burbujaDescendente(matriz[1]);

        return matriz;

    }

    public static void main(String[] args) {
        Prac4Extra prac4Extra = new Prac4Extra();

        int[] array1 = {4, 3, 2, 1, 9, 11, -15, 200, 15, 39, 0, 64};
        int[] array2 = {3, 2, 1, 4};
        int[][] matriz = {{4, 3, 2, 1, 9}, {3, 2, 1, 4, 88}};
        System.out.println("=====Array=====");
        System.out.println("Arrays sin ordenar: " +
                "\nArray1= " + Arrays.toString(array1) +
                "\nArra2= " + Arrays.toString(array2));
        System.out.println("Array ordenado de forma descendente: " + Arrays.toString(prac4Extra.burbujaAscendente(array1)) + "\n");
        System.out.println("Array ordenado de forma descendente: " + Arrays.toString(prac4Extra.burbujaAscendente(array2)) + "\n");
        System.out.println("Array ordenado de forma ascendente: " + Arrays.toString(prac4Extra.burbujaDescendente(array1)) + "\n");
        System.out.println("Array ordenado de forma ascendente: " + Arrays.toString(prac4Extra.burbujaDescendente(array2)) + "\n");
        System.out.println("=====Matrices bidimensional=====");
        System.out.println("Matriz bidimensional sin ordenar:" +
                "Matriz= " + Arrays.deepToString(matriz));
        System.out.println("Matriz bidimensional ordenada de forma descendente: " + Arrays.deepToString(prac4Extra.burbujaDescendenteParaMatrizBideimensional(matriz)));
        System.out.println("Matriz bidimensional ordenada de forma ascendente: " + Arrays.deepToString(prac4Extra.burbujaAscendenteParaMatrizBideimensional(matriz)));
    }

}
