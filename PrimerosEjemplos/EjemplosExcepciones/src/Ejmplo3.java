/*3. Solicita un número entero por pantalla y controla un posible error de entrada con
        tratamiento de excepciones*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejmplo3 {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        int numeroIntroducido=0;

        try {
            System.out.println("Asignando un double a un entero");
           numeroIntroducido =src.nextInt();
            System.out.println("El numero es "+numeroIntroducido);
        } catch (InputMismatchException excpt) {
            System.out.println("Algo ha salido mal");
        }
        System.out.println("El numero es "+(double)numeroIntroducido);
    }


}
