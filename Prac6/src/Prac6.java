import java.util.Scanner;

public class Prac6 {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        System.out.println("Indica un número entero: ");
        int num1=src.nextInt();
        System.out.println("Indica un segundo número entero: ");
        int num2=src.nextInt();

        System.out.println("Indica un tercer número entero: ");
        int num3=src.nextInt();

        System.out.println("Indica un cuarto número entero: ");
        int num4=src.nextInt();

        System.out.println("=====Operaciones=====\n");
        System.out.println("La suma de "+num1+ " y "+num2+" es igual a "+(num1+num2));
        System.out.println("\nEl producto de "+num3+ " y " +num4+" es igual a "+(num3*num4));
    }
}
