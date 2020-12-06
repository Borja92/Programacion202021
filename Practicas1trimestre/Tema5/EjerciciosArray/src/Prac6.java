/*6. Escriba un programa que lea de la entrada un número y utilice ese número para crear
        un array de enteros de ese tamaño. A continuación, el programa inicializará el array con
        los valores que el usuario introduzca por la entrada. Finalmente, se deberá recorrer el
        array e imprimir tantos caracteres ‘#’ como indique el valor de cada elemento del array.
        Ejemplo: los valores 5,4,3,2 producirán la siguiente salida:
        #####
        ####
        ###
        ##*/


import java.util.Scanner;

public class Prac6 {

    Scanner src = new Scanner(System.in);

    //Método que crear arrays con la longitud y los valores recogidos por teclado
    int[] nuevoArray() {

        System.out.println("Introduce la longitud del array deseada: ");
        int logintudArray = src.nextInt();

        int[] nuevoArray = new int[logintudArray];

        for (int i = 0; i < nuevoArray.length; i++) {
            System.out.println("Introduce valores mayores a 0 para introducir en el array: ");
            int valorEntradaTeclado = src.nextInt();

            nuevoArray[i] = valorEntradaTeclado;

        }


        return nuevoArray;
    }

    //Método que recorre e imprime el array
    private void imprimirArray(int[] arrayAmostrar) {

        for (int i = 0; i < arrayAmostrar.length; i++) {

            System.out.print("[" + arrayAmostrar[i] + "]");

        }

    }

    //Método que hace uso del metodo "imprimirArray" y de nuevo recorre y pinta el carácter # dependiendo de los valores del array
    void imprimirAlmoadillasPorValorEnArray(int[] array) {

        imprimirArray(array);
        System.out.println();
        for (int i : array) {

            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {

        Prac6 prac6 = new Prac6();

        int[] array1 = prac6.nuevoArray();
        prac6.imprimirAlmoadillasPorValorEnArray(array1);

    }
}
