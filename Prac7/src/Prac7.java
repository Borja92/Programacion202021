import java.util.Scanner;

public class Prac7 {
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

        System.out.println("=====Operaciones=====");
        int resultadoSuma=num1+num2+num3+num4;

        System.out.println("La suma de "+num1+", "+num2+", "+num3+" y "+num4+
                " es igual a: "+resultadoSuma);
        System.out.println("La media de los números introducidos  es: "+resultadoSuma/4);

    }
}
