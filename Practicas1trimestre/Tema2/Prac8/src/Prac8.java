import java.text.DecimalFormat;
import java.util.Scanner;

public class Prac8 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        DecimalFormat format = new DecimalFormat("#######.##");

        System.out.println("Indique precio unitario del artículo: ");
        double preciUnitarioArticulo = src.nextDouble();

        System.out.println("Indique el número de artículos: ");
        int numeroArticulos = src.nextInt();

        System.out.println("El precio total, incluyendo IVA del 21% es: "+format.format(numeroArticulos*preciUnitarioArticulo*1.21)+"€");
    }
}
