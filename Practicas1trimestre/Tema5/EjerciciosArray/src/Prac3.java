/*
3.Hacer un programa que dados dos arrays determine si son iguales.
Probarlo con los arrays [1,2,3] y [1,2,3], [1,2,3,4] y [1,2,3] y [1,2,3] y [1,2,2]
*/


import java.util.Arrays;

public class Prac3 {


//Sencillo método que compara los valores de dos arrays pasados por parámetros
     private void sonIguales(int[] a, int[] b){

        boolean sonIguales;

        sonIguales=Arrays.equals(a,b);
        System.out.println("\n¿Son los Arrays idénticos?\n"+sonIguales);

    }


    public static void main(String[] args) {

        Prac3 prac3 = new Prac3();

        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {1, 2, 3};
        int[] array5 = {1, 2, 3};
        int[] array6 = {1, 2, 2};

        prac3.sonIguales(array1,array2);
        prac3.sonIguales(array3,array4);
        prac3.sonIguales(array5,array6);



    }


}
