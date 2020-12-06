/*7. Declarar e inicializar una matriz de enteros de 2x3 e imprimirla.*/

import java.util.Scanner;

public class Prac7 {

    public static void main(String[] args) {

        //Declaramos una matriz  de dos dimensiones y tres columnas
        int matriz[][] = {{1, 2, 3}, {4, 5, 6}};

        //Recorremos las filas
        for (int i = 0; i < matriz.length; i++) {

            //Y por cada fila, recorremos sus columnas e imprimimos sus valores
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j]);
            }
        }


    }

}