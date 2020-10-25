/*Ejercicio 1
        Escribe un programa que muestre los n primeros términos de la serie de Fibonacci. El primer término de
        la serie de Fibonacci es 0, el segundo es 1 y el resto se calcula sumando los dos anteriores, por lo que
        tendríamos que los términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... El número n se debe
        introducir por teclado.*/


import java.util.Scanner;

public class Prac1 {

    public static void main(String[] args) {


        Scanner src= new Scanner(System.in);

        int N1=1, N2, suma=0;

        System.out.println("Introduce N (número entero) para calcular N veces la serie Fibonacci: ");
    int valorEntero=src.nextInt();

    for(int i=0;i<valorEntero;i++){

        N2=suma;
        suma=N1+suma;
        N1=N2;
        System.out.println(N1);

    }
    }
}
