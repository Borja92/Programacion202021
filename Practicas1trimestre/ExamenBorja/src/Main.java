import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        int [] array = {10,2,0,6,9,3,8,5,6};
        int [] array2 = {777,2,0,66,99,3,8,5,6};
        Parray parray = new Parray(array);
        Parray parray2 = new Parray(array2);

        //Pruebas de métodos de la clase Parray
        //Contador de valores en un array
        System.out.println(parray.count());
        //Devuelve un valor pasando la posición por parámetros
        System.out.println(parray.getIndice(5));

        //Introduce un valor en un indice del array
        parray.setIndex(4,666);

        //Comprueba si un valor existe en el array del objeto
        System.out.println(parray.in_array(666));
        System.out.println(parray.in_array(999));
//Rellena el array con el valor indicado, apartir del indice indicado el número indicado de veces
        parray.array_fill(5,3,88);
        System.out.println(parray.in_array(88));

//Devuelve un array con los elementos en orden inverso
parray.array_reverse();
    //Calcula la diferencia entre arrays y devuelve los valores no repetidos
        parray2.array_diff(parray2);
        System.out.println("Parray2: ");
        parray2.mostrar();
        System.out.println("Parray Resultante: "+ Arrays.toString(array));
    }


}
