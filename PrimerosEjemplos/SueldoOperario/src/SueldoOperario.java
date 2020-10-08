import java.text.DecimalFormat;
import java.util.Scanner;

public class SueldoOperario {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);
        DecimalFormat formateador = new DecimalFormat("#######.##");
        System.out.println(formateador.format(23.323232323232323)); // Esto muestra el decimal con el siguiente formato 23.32
        System.out.println("Indica el nombre del empleado: ");
String nombreEmpleado= src.next();
        System.out.println("Introduce las horas trabajadas: ");
        int horasTrabajadas = src.nextInt();

        System.out.println("Introduce el coste por hora: ");
        float costoHoras = src.nextFloat();

        float sueldo=horasTrabajadas*costoHoras;

        System.out.println(nombreEmpleado+ " "+sueldo+"€");
        System.out.println("El empleado "+nombreEmpleado+ " va a percibir un sueldo de "+formateador.format(sueldo)+"€");
    }
}
