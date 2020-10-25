/*Ejercicio 5
        Escribe un programa que diga si un número introducido por teclado es o no primo. Un
        número primo es aquel que sólo es divisible entre él mismo y la unidad.*/


import java.util.Scanner;

public class Prac5 {

    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);

        System.out.println("Introduce un número entero para comprobar si es o no primo!!");
        int numeroIntroducido = src.nextInt();

        int contador=2;

        for (int i=1; i<contador; i++){

            if(numeroIntroducido%contador==0){

                System.out.println("EL número "+numeroIntroducido+ " no es primo!!");
            } else {

                System.out.println("El número "+numeroIntroducido+" es primo!!");
            }

        }

    }
}
