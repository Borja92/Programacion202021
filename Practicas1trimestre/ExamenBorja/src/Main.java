import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [] array = {10,2,0,6,9,3,8,5,6};
        int [] array2 = {777,2,0,66,99,3,8,5,6};
        Parray parray = new Parray(array);

        //Pruebas de métodos de la clase Parray
        //Contador de valores en un array
        System.out.println(parray.ContadorValoresArray(array));

        //Devuelve un valor pasando la posición por parámetros
        System.out.println(parray.DevuelveValorEnArraySegunIndice(array,2));

        //Introduce un valor en un indice del array
        System.out.println(parray.IntroduceValorEnIndice(array, 1, 999));

        //Comprueba si un valor existe en el array del objeto
        System.out.println(parray.ValorEnArray(array,88));
        System.out.println(parray.ValorEnArray(array,999));
//Llena el array con valores
        System.out.println(Arrays.toString(parray.RellenarArrayConValoresApartirDeIndiceIndicado(array, 2, 288, 3)));
//Devuelve un array con los elementos en orden inverso
        System.out.println(Arrays.toString(parray.DevolverArrayInvertido(array)));
        //Calcula la diferencia entre arrays y devuelve los valores no repetidos
        System.out.println(Arrays.toString(parray.ValoresDiferentesEnArrays(array, array)));


    }


}
