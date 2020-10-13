//4. Realiza el factorial de un número (n! = n*(n-1)*(n-2)*.........*1)

import java.util.Scanner;

public class Prac4 {
    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);

        System.out.println("Introduce un número entero para calcular su factorial: ");
        int numeroAcalcular= src.nextInt();
        int factorial=1;

        for (int i=numeroAcalcular;i>1;i--){

            factorial = factorial*i;
            System.out.println("\nEl factorial de "+numeroAcalcular+" es: "+factorial);
        }


    }

}
