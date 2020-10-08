import java.util.Scanner;

public class EjemploIf {

    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);


        /*System.out.println("Introduce el sueldo del empleado: ");
        double sueldo = src.nextDouble();

        if(sueldo>=3000) {

            System.out.println("El empleado debe pagar " + (sueldo * 0.25) + " en impuestos");
        }
        else if (sueldo>=2000){

            System.out.println("El empleado debe pagar "+(sueldo*0.23));
        }else {
            System.out.println("El empleado debe pagar " + (sueldo * 0.20) + " en impuestos.");
        }*/

        System.out.println("Introduce un número entero: ");
        int num1= src.nextInt();

        System.out.println("Introduce un segundo número entero: ");
        int num2=src.nextInt();

        if(num1>num2) {
            System.out.println("El primer número " + num1 + " es mayor que el segundo " + num2);
        }else System.out.println("El segundo número "+num2+" es mayor que el primero "+num1);
    }

}
