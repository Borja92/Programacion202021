/*10- Realizar un programa que permita cargar dos listas de 15 valores
cada una. Informar con un mensaje cual de las dos listas tiene un
valor acumulado mayor (mensajes "Lista 1 mayor", "Lista 2 mayor",
"Listas iguales")*/


import java.util.Scanner;

public class Prac10 {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);


int suma1 = 0, suma2=0, valorTeclado=0, contador1=0, contador2=0;

while (contador1<15){
    System.out.println("\nIntroduce valores enteros de la primera lista: " +
            "\nValor Nº"+(contador1+1));
    valorTeclado=src.nextInt();

    suma1+=valorTeclado;

    contador1++;
}



while (contador2<15){
    System.out.println("\nIntroduce valores enteros de la segunda lista: " +
            "\nValor Nº"+(contador2+1));
    valorTeclado=src.nextInt();

    suma2+=valorTeclado;

    contador2++;
}

if (suma1>suma2){

    System.out.println("\nLista 1 mayor");
} else {

    System.out.println("\nLista 2 mayor");
}

if (suma1==suma2){
    System.out.println("\nListas iguales");
}

        System.out.println("\nTotal valor de la lista 1: "+suma1);
        System.out.println("\nTotal valor de la lista 2: "+suma2);

    }
}
