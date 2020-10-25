/*Ejercicio 4
        Escribe un programa que dados dos números, uno real (base) y
        un entero positivo (exponente), saque por pantalla todas las
        potencias con base el numero dado y exponentes
        entre uno y el exponente introducido. No se deben utilizar
        funciones de exponenciación. Por ejemplo, si introducimos el 2 y
        el 5, se deberán mostrar 2^1, 2^2, 2^3, 2^4 y 2^5.*/


import java.util.Scanner;

public class Prac4 {
    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        System.out.print("Introduzca un número real como base: ");
        double base = src.nextDouble();

        System.out.print("Introduzca un múmero entero como exponente: ");
        int exponenteFinal = src.nextInt();

        int exponente;

        for (int i = 1; i <= exponenteFinal; i++) {
            exponente = i;

            for (int j = 0; j < exponente; j++) {

            }

            System.out.print(base + "^" + i+", ");
        }

    }

}
