import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        int [] array = {10,2,0,6,9,3,8,5,6};
        int [] array2 = {777,2,0,66,99,3,8,5,6};
        Parray parray = new Parray(array);
        Parray parray2 = new Parray(array2);

        //Pruebas de métodos de la clase Parray
        //Contador de valores en un array
        System.out.println("Contador valores en un array: "+parray.count());
        //Devuelve un valor pasando la posición por parámetros
        System.out.println("Devuelve el valor de un indice: "+parray.getIndex(5));

        //Introduce un valor en un indice del array
        System.out.println("Introduce un valor en un indice dado: ");
        parray.setIndex(4,666);
parray.mostrar();
        //Comprueba si un valor existe en el array del objeto
        System.out.println("Está el valor indicado en el array? "+parray.in_array(666));
        System.out.println("Está el valor dado en el array? "+parray.in_array(999));
//Rellena el array con el valor indicado, apartir del indice indicado el número indicado de veces
        System.out.println("Rellena el array, a partir de un indice dado, un valor dado y un número de veces dado");
        parray.array_fill(5,3,88);
        System.out.println("Se encuentra el valor en el array? "+parray.in_array(88));
parray.mostrar();
//Devuelve un array con los elementos en orden inverso
        System.out.println("Pone un array del revés");
        parray.array_reverse();
        parray.mostrar();
    //Calcula la diferencia entre arrays y devuelve los valores no repetidos
        Parray parrayVAloresDiferentes;
        System.out.println("Valores diferentes en un array: ");
    parrayVAloresDiferentes=parray.array_diff(parray2);
        System.out.println("Parray2: ");
        parray2.mostrar();
        System.out.println("Parray con valores resultante diferentes entre arrays: ");
        parrayVAloresDiferentes.mostrar();
    }


}
