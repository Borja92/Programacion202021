
/*1. Confeccionar un programa que lea n pares de datos, cada par de datos
        corresponde a la medida de la base y la altura de un triángulo. El programa
        deberá informar:

        a) De cada triángulo la medida de su base, su altura y su superficie.
        b) La cantidad de triángulos cuya superficie es mayor a 12.*/


import java.util.Scanner;

public class Prac1 {

    public static void main(String[] args) {

        Scanner src= new Scanner(System.in);

        int base, altura, superficie, triangulosSuperficieMayorDoce = 0;

        for (int i=0; i<3;i++){

            System.out.println("\nIndica la base de un triangulo: ");
            base=src.nextInt();
            System.out.println("\nIndica la altura de un triangulo: ");
            altura=src.nextInt();

            System.out.println("\nLa base del triangulo es de: "+base+"m y tiene una altura de: "+altura+"m");

            superficie=base*altura/2;

            System.out.println("\nTeniendo en cuenta la base y la altura, tiene una superficie de: "+superficie+"m");

        if (superficie>12){

            triangulosSuperficieMayorDoce++;
        }
        }
        System.out.println("\nNúmero de triangulos cuya superficie sea mayor a 12m: "+triangulosSuperficieMayorDoce+"m");
    }
}
