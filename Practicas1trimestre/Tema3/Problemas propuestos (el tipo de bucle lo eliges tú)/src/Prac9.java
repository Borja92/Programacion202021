/*9- Realiza el algoritmo para que se esté introduciendo números
hasta que se introduzca un número negativo y nos diga cuantos
números se han introducido, la media de los impares y el mayor
de los pares.*/

import java.util.Scanner;

public class Prac9 {

    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        int valorPorTeclado, aux,numerosIntroducidos=0,mediaImpares=0, mayorPares=0, auxImpar=0, numImpares=0;

        while (true) {
            System.out.println("Introduce una cifra integer: \n" +
                    "(Hasta introducir un número negativo)");
            valorPorTeclado = src.nextInt();

            numerosIntroducidos++;
if(valorPorTeclado>=0){
    aux=valorPorTeclado;

} else {

    break;
}
if(aux%2==0){


 while (aux>mayorPares){

     mayorPares=aux;
 }

} else {
    numImpares++;
    auxImpar+=aux;
    mediaImpares=auxImpar/numImpares;

}
        }
        System.out.println("\n Se han introducido un total de "+numerosIntroducidos+" números.");

        System.out.println("\nLa media de números impares introducidos es: "+mediaImpares);

        System.out.println("\n El número par mayor introducido ha sido: "+mayorPares);
    }
}
