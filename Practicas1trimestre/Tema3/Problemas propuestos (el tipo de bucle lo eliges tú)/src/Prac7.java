/*7- Haz un programa que pregunte el nombre y los dos apellidos en
una variable y después escriba las iniciales seguida por un „.‟, controla
que la cadena introducida no este vacía, en ese caso volverás a pedir
otra, y se podrán introducir nombres compuestos.*/

import java.util.Scanner;
import java.util.StringTokenizer;

public class Prac7 {

    public static void main(String[] args) {

      //  Scanner src = new Scanner(System.in);

     /*   String nombreCompleto = "", iniciales;


        do {
            try {

                System.out.println("\nIntroduzaca nombre y apellidos: ");
                nombreCompleto = src.nextLine();

                if (nombreCompleto != null && !nombreCompleto.isEmpty()) {

                    StringTokenizer stringTokenizer = new StringTokenizer(nombreCompleto);
                    while (stringTokenizer.hasMoreTokens()) {

                        iniciales = stringTokenizer.nextToken();

                        System.out.print(iniciales.substring(0, 1) + ".");
                    }

                } else {

                    throw new Exception("La cadena es nula o está vacía. Intentalo de nuevo.");

                }
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());

            }
        } while (nombreCompleto.isEmpty());
*/


        Scanner teclado = new Scanner(System.in);
        String nombreApellidos;
        int contador,mayuscula;

        do {
            System.out.println("Introduce tu nombre y tus apellidos y te dire tus iniciales");
            nombreApellidos= teclado.nextLine();
        }
        while(nombreApellidos.length()==0);
        System.out.print(nombreApellidos.charAt(0)+".");
        for(contador=0;contador< nombreApellidos.length() ;contador++)
        {
            if (nombreApellidos.charAt(contador)==' '){
                mayuscula=contador+1;
                System.out.print(nombreApellidos.charAt(mayuscula)+".");
            }

        }


    }

}

