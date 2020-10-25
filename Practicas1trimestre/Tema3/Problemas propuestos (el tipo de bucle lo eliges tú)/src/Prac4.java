/*4 - Se cuenta con la siguiente información:

        Las edades de 5 estudiantes del turno mañana.
        Las edades de 6 estudiantes del turno tarde.
        Las edades de 11 estudiantes del turno noche.
        Las edades de cada estudiante deben ingresarse por teclado.

        a) Obtener el promedio de las edades de cada turno (tres promedios)
        b) Imprimir dichos promedios (promedio de cada turno)
        c) Mostrar por pantalla un mensaje que indique cuál de los tres
        turnos tiene un promedio de edades mayor.*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Prac4 {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#######.##");
        double edadPromedioMannana, edadPromedioTarde, edadPromedioNoche;
        int edadAxuliarManna = 0;
        int edadAxuliarTarde = 0;
        int edadAxuliarNoche = 0;


        for (int i = 0; i <5 ; i++) {
            System.out.println("Introduce la edad de un estudiante del turno de mañana Nº"+(i+1)+": ");
            int edadMannana = src.nextInt();
            edadAxuliarManna+=edadMannana;


        }
        edadPromedioMannana=edadAxuliarManna/5;
        System.out.println("\nLa edad promedio del turno de mañana es: "+edadPromedioMannana);

        for (int i = 0; i <6 ; i++) {
            System.out.println("Introduce la edad de un estudiante del turno de tarde Nº"+(i+1)+": ");
            int edadTarde = src.nextInt();
            edadAxuliarTarde+=edadTarde;
        }
edadPromedioTarde=edadAxuliarTarde/6;
        System.out.println("\nLa edad promedio del turno de tarde es: "+ edadPromedioTarde);

        for (int i = 0; i <11 ; i++) {
            System.out.println("Introduce la edad de un estudiante del turno de noche Nº"+(i+1)+": ");
            int edadNoche = src.nextInt();
            edadAxuliarNoche+=edadNoche;
        }

        edadPromedioNoche=edadAxuliarNoche/11;
        System.out.println("\nLa edad promedio del turno de noche es: "+ edadPromedioNoche);


        double edadPromedioTotal=edadPromedioMannana+edadPromedioTarde+edadPromedioNoche/3;

        System.out.println("\n==========" +
                "\nEdad promedio total de todos los turnos:" +
                "\n"+df.format(edadPromedioTotal)+
        "\n==========");
    }

}
