import java.util.Scanner;

public class Prac5 {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        System.out.println("Indica el  lado de un cuadrado en Nº entero para calcular su diametro: ");
int ladoCuadrado= src.nextInt();
        System.out.println("El perímetro del cuadrado es "+ladoCuadrado*4);
    }
}
