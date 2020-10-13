
/*3. Se realiza la carga de 10 valores enteros por teclado. Se desea conocer:
        a) La cantidad de valores introducidos negativos.
        b) La cantidad de valores introducidos positivos.
        c) La cantidad de múltiplos de 15.
        d) El valor acumulado de los números introducidos que son pares.*/

import java.util.Scanner;

public class Prac3 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        int valor, numerosNegativos = 0, numerosPositivos=0, multiplosQuince=0, sumaNumerosPares=0, multiplo=15, cantidadNumerosPares=0;

        for (int i=0; i<10;i++){

            System.out.println("Introduce un número entero: ");
            valor=src.nextInt();

            if(valor<0){
                numerosNegativos++;

            } else {
                numerosPositivos++;
            }
          /*  } else if(valor%multiplo==0){

                multiplosQuince++;
            } else if (valor%2==0){
sumaNumerosPares=sumaNumerosPares+valor;

cantidadNumerosPares++;
            }*/
if(valor%15==0){
    multiplosQuince++;
}

if(valor%2==0){
    sumaNumerosPares=sumaNumerosPares+valor;
    cantidadNumerosPares++;

} }

        System.out.println("Cantidad de números negativos: "+numerosNegativos);
        System.out.println("\nCantidad de números positivos: "+numerosPositivos);
        System.out.println("\nCantidad de números que son múltiplos de 15: "+multiplosQuince);
        System.out.println("\nValor acumulado de la suma de los números pares: "+sumaNumerosPares);

        System.out.println(+cantidadNumerosPares);
    }
}
