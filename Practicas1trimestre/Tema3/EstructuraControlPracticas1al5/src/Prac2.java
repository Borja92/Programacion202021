/*Ejercicio 2
        Escribe un programa que lea una lista de diez números y determine
        cuántos son positivos, y cuántos son negativos.*/

import java.util.Scanner;

public class Prac2 {

    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        int numPositivos = 0, numNegativos=0;

        for (int i=0; i<10;i++){


            System.out.println("Introduce un valor, en total 10: ");
            int valor=src.nextInt();

            if (valor%2==0) {
                numPositivos++;

            } else {
                numNegativos++;

            }

        }

        System.out.println("Total números negativos: "+numNegativos);
        System.out.println("Total números positivos: "+numPositivos);

    }
}
