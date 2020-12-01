/*1. Escribe un programa que sume todos los elementos de un array
        de enteros.*/


public class Prac1 {

    public static void main(String[] args) {
//Declaracion de variables
        int suma = 0;
        int[] miArray = {1, 5, 8, 18, 99, 55, 18, 22, 35, 17};

//Estructura for que recorra el array y un sencillo algoritmo que sume los valores del Array
        for (int i = 0; i < miArray.length; i++) {
            suma += miArray[i];

            //Pinta la suma secuencial de los valores del array
            System.out.println((suma + "+" + miArray[i] + "=" + suma));

        }
//Pinta el total de la sumtoria de todos los valores del array
        System.out.println("\nEl total de la sumatoria es: " + suma);


    }
}
