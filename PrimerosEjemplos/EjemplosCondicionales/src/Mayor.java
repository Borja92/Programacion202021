import java.util.Scanner;

public class Mayor {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Introduce un número: ");
        int num1 = src.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = src.nextInt();


        int mayor;

        if (num1 > num2) {
            mayor = num1;
        } else {
            mayor = num2;
        }

        System.out.println("El número mayor es "+mayor);
    }


}
