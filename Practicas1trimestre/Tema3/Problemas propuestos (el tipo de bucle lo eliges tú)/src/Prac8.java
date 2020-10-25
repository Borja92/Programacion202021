/*8- Realizar un programa que acumule (sume) valores ingresados por
teclado hasta ingresar el 9999 (no sumar dicho valor, indica que ha
finalizado la carga). Imprimir el valor acumulado e informar si dicho
valor es cero, mayor a cero o menor a cero.*/


import java.util.Scanner;

public class Prac8 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        int valorPorTeclado=0, aux=0;

        while (true){
            System.out.println("Introduce una cifra para ir sumandola: ");
            valorPorTeclado=src.nextInt();
            if(valorPorTeclado!=9999){

            aux+=valorPorTeclado;

        } else {
                break;}
        }
        System.out.println("\nLa suma total de valores introducidos sin contar el 9999 es: "+aux);

        if (aux==0){
            System.out.println("\nLa sumatoria da 0.");

        }

        if(aux<0){
            System.out.println("\nLa sumatoria es negativa. Menor que 0.");

        }
        if (aux>0){

            System.out.println("\nLa sumatoria es positiva. Mayor que 0.");
        }

    }

}
