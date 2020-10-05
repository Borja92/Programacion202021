import java.util.Scanner;

public class DobleDeUnNumero {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);


        System.out.println("Dime un número entero: ");

    int numero= src.nextInt();

    int doble = numero*2;

        System.out.println("El doble del número "+numero+ " es: "+doble);


    }
}
