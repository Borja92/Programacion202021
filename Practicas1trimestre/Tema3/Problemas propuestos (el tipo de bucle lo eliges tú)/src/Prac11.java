/*11- Haz un programa para adivinar un número, este se generara
aleatoriamente, y será un numero entre 1 y 100. Al introducir el
 número, si la diferencia con el que hay que adivinar es mayor de 50
diremos “Muy frio”, entre 10 y 50 “frio”, entre 5 y 10 “caliente”
 y menos de 5 “muy caliente”, al acertarlo, diremos en cuantas tiradas
lo hemos adivinado*/

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Prac11 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        Random rdn=new Random();

        Date date = new Date();

        rdn.setSeed(date.getTime());
        int numeroAadivinar=rdn.nextInt(100+1);
        System.out.println(numeroAadivinar);
        int N=0, resultado=0,numIntentos=0;


        while (true) {

            System.out.println("\nIntroduce un número entre el 1 y el 100 \n");
                    N = src.nextInt();

            resultado = numeroAadivinar - N;

        if (resultado>50){

            System.out.println("\nMuy frío!!");
        }

        if ((resultado>=10)&(resultado<=50)){

            System.out.println("\nFrío!!");

        }

        if ((resultado>=5)&(resultado<10)){

            System.out.println("\nCaliente!!");
        }

        if (resultado>0&resultado<5){
            System.out.println("\nMuy caliente!!");
        }

        if (resultado==0){

            System.out.println("\nEnhorabuena has acertado en "+numIntentos+" intentos!!!!");

        break;
        }

            numIntentos++;
        }
    //    System.out.println("Has acertado en "+numIntentos+" intentos.");


    }
}
