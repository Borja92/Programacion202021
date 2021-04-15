import java.util.Scanner;

/**
 * Clase Notas - Recuperación primer trimestre - 1º Practica
 *
 * @author A. Borja Badía Checa
 * @version 1.0
 */

public class Notas {

    private double nota;
    private double mediaNotas;
    private double[] notasArray;

    public Notas() {
        this.nota = nota;
        this.mediaNotas = mediaNotas;
        this.notasArray = new double[99];
    }

    private void introducirNuevaNota(double nota){
boolean notaValidad;
do {
    if (nota > 0 && nota <= 10) {
        notaValidad = true;
        for (int i = 0; i < this.notasArray.length; i++) {
            if (notasArray[i] != 0 && i < 99) {
                this.notasArray[i] = nota;
                //break;
            } else
                System.out.println("La nota no ha podido ser añadida. El array está completo!!");
        }
    } else System.out.println("La nota debe ser entre 0-10 y sus decimales!!");
}
    while (notaValidad=false);

    }

    private void mostrarNotas(){

        for (int i = 0; i <this.notasArray.length ; i++) {
            System.out.print(notasArray[i]);
        }
    }

    private double calcularMedia(){

        double mediaNotas=0.0;
        for (int i = 0; i <this.notasArray.length ; i++) {
            mediaNotas=mediaNotas+this.notasArray[i];
        }
        return mediaNotas=mediaNotas/this.notasArray.length;
    }

public void menuInterfaz(){
    Scanner src= new Scanner(System.in);
int opcion;
    do {


    System.out.println("Bienvenido!!\n" +
            "Qué desea hacer:\n" +
            "1. Introducir Nueva Nota\n" +
            "2. Mostrar todas las Notas\n" +
            "3. Calcular la Nota Media.\n" +
            "4. Salir");
    opcion = src.nextInt();
    if (opcion == 1) {
        System.out.println("Indica la nueva nota(double): ");
        double nuevaNota = src.nextDouble();
        introducirNuevaNota(nuevaNota);
    }
    if (opcion == 2) {
        System.out.println("Las notas: ");
        mostrarNotas();
    }
    if (opcion == 3) {
        System.out.println("El calculo actual de la media es: " + calcularMedia());
    }
}
while (opcion!=4);
}

    public static void main(String[] args) {

        Notas notas= new Notas();
        notas.menuInterfaz();
    }



}
