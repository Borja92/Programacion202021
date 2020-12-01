/*2. Escribe un programa en Java que encuentre el menor y
        el mayor valor entero de un array.*/

public class Prac2 {

    public static void main(String[] args) {

        //Declaramos un array de tipo entero y dos variables para almacenar los resultados finales
        int[] miArray = {1, 5, 8, 18, 99, 55, 18, 22, 35, 17, -50};

        int elValorMayor = 0, elValorMenor = 0;

//Hacemos uso de foreach para recorrer el Array
        for (int i : miArray) {

            //Dos algoritmos sencillos condicionales. Que se encargan de hallar el valor menor y el valor mayor del array que recorremos
            if (elValorMenor > i) {

                elValorMenor = i;

            }
            if (elValorMayor < i) {

                elValorMayor = i;
            }

        }

        //Imprimimos lo valores ya guardados en variables
        System.out.println("El valor mayor del Array es: " + elValorMayor);

        System.out.println("El valor menor del Array es: " + elValorMenor);
    }

}
