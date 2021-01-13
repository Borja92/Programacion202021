/*8. Una orquesta está formada por n músicos, escribir un programa que lea
        dos vectores nombre y edad, para luego determinar cual de las
        personas es mayor y cual es más joven, se debe mostrar el nombre del
        músico con su respectiva edad.*/

import java.util.Arrays;

public class main {

    public static void main(String[] args) {

       /* Musicos m = new Musicos();

        int[] vectorEdadMusicos = new int[]{21, 29, 35, 99, 18};
        String[] vectorNombreMusicos = new String[]{"P1", "P2", "P3", "P4", "P5"};

        System.out.println("Edades: "+ Arrays.toString(vectorEdadMusicos) +"\nNombres: " + Arrays.toString(vectorNombreMusicos));

        System.out.println(m.elMusicoMayorYelMenor(vectorNombreMusicos, vectorEdadMusicos));
*/
       Orquesta orquesta = new Orquesta();

        int[] vectorEdadMusicos = new int[]{21, 99, 35, 18, 23};
        String[] vectorNombreMusicos = new String[]{"P1", "P2", "P3", "P4", "P5"};

        orquesta.setEdadMusicos(vectorEdadMusicos);
        System.out.println(Arrays.toString(orquesta.getEdadMusicos()));

        orquesta.setNombreMusicos(vectorNombreMusicos);
        System.out.println(Arrays.toString(orquesta.getNombreMusicos()));

        System.out.println(orquesta.musicoMayor(vectorEdadMusicos)+" el mayor");
        System.out.println(orquesta.musicoMenor(vectorEdadMusicos)+" el menor");

        System.out.println(orquesta.elMusicoMayorYelMenor(vectorNombreMusicos, vectorEdadMusicos));
   Musicas musicas = new Musicas();


    }
}
