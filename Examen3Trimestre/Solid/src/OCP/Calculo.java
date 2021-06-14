package OCP;

import java.util.Scanner;

public class Calculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("1. OCP.Suma\n2. OCP.Resta\nOpcion: ");
        int opcion = sc.nextInt();

        System.out.print("Número (operando a): ");
        int a = sc.nextInt();

        System.out.print("Número (operando b): ");
        int b = sc.nextInt();

        int resultado = 0;

        // APLICA OCP DESDE AQUÍ

        if (opcion == Operaciones.SUMA) {
            Suma suma = new Suma();
            resultado = suma.operacion(a,b);
        } if (opcion == Operaciones.RESTA) {
            Resta resta = new Resta();
            resultado = resta.operacion(a, b);
        }
        // APLICA OCP HASTA AQUÍ

        System.out.println("El resultado es : " + resultado);
    }
}
