/*Ejercicio 3
        Escribe un programa que pida una base y un exponente
        (entero positivo) y que calcule la potencia
        utilizando únicamente operaciones de multiplicación.*/

import java.util.Scanner;

public class Prac3 {
    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);

        System.out.println("Introduce una base: ");
        int base=src.nextInt();

        System.out.println("Introduce un exponente: ");
        int exponente=src.nextInt();


for (int i=0;i<=exponente;i++){
    int resultado=0;
    resultado=resultado*base;
    System.out.println(resultado);


}
        double x1 = Math.pow(exponente, base);

        System.out.println(x1);

    }





}
