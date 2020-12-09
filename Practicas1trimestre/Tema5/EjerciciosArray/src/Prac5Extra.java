/*5. Escriba un programa que, dado un array de enteros, busque si un número obtenido por
        la entrada estándar se encuentra en el array e imprima la primera posición en la que se
        encuentra el número.*/


import java.util.Arrays;
import java.util.Scanner;

public class Prac5Extra {

    //Método que pide un número entero y lo devulve
    int introDuceUnEntero() {

        Scanner src = new Scanner(System.in);

        System.out.println("Introduce un número entero: ");
        return src.nextInt();
    }

    //Método que compara el número entero introducido por el usuario y lo compara con los valores del array
    void numeroEnArray(int[] array) {

        boolean flag = false;
        int aux = 0;
        int numUsuario = introDuceUnEntero();


        for (int i = 0; i < array.length; i++) {
            aux = i + 1;

            if (numUsuario == array[i]) {

                flag = true;
                        /*System.out.print("\nEnhorabuena el número coincide con un valor ya existente en el array!!!\n" +
                                "El número es " + numUsuario + " y se encuentra en la posición: " + (aux));
                    } else {
                    System.out.print("\nEl número " + numUsuario + " no coincide con ningún valor del array.");
                }*/
            }
        }
        
        if (flag=true){
            System.out.print("\nEnhorabuena el número coincide con un valor ya existente en el array!!!\n" +
                "El número es " + numUsuario + " y se encuentra en la posición: " + (aux));
        } else {
            System.out.print("\nEl número " + numUsuario + " no coincide con ningún valor del array.");
        }
        
        
    }
            

    public static void main(String[] args) {
        Prac5Extra prac5Extra = new Prac5Extra();

        int[] array1 = {4, 3, 2, 1, 9, 11, -15, 200, 15, 39, 0, 64};
        System.out.println(Arrays.toString(array1));
        prac5Extra.numeroEnArray(array1);
    }
}
