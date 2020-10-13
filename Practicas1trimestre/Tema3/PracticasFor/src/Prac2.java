
/*2. Desarrollar un programa que solicite la lectura de 10 números e imprima la
        suma de los últimos 5 valores.*/

import java.util.Scanner;

public class Prac2 {
    public static void main(String[] args) {
        Scanner src= new Scanner(System.in);

        int resultadoSuma=0,numero;

        for (int i=0; i<10;i++){

            System.out.println("\nIntroduce un número entero: ");
             numero=src.nextInt();

            System.out.println(i);
        if (i>4){
resultadoSuma=resultadoSuma+numero;
        }
        }
        System.out.println("\nLa suma de los últimos 5 valores es: "+resultadoSuma);
    }

}
