/*8. Una orquesta está formada por n músicos, escribir un programa que lea
        dos vectores nombre y edad, para luego determinar cual de las
        personas es mayor y cual es más joven, se debe mostrar el nombre del
        músico con su respectiva edad.*/

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

        Musicos m = new Musicos();

        int[] vectorEdadMusicos = new int[]{21, 29, 35, 99, 18};
        String[] vectorNombreMusicos = new String[]{"P1", "P2", "P3", "P4", "P5"};

        System.out.println("Edades: "+ Arrays.toString(vectorEdadMusicos) +"\nNombres: " + Arrays.toString(vectorNombreMusicos));

        System.out.println(m.elMusicoMayorYelMenor(vectorNombreMusicos, vectorEdadMusicos));

    }
}
