import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class AdivinaUnNumero {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        Random rdn=new Random();

        Date date = new Date();

        rdn.setSeed(date.getTime());
       int numeroAadivinar=rdn.nextInt(100+1);
        System.out.println(numeroAadivinar);
int N=0, resultado=0,numIntentos=0;
        ;

        while (N!=numeroAadivinar) {

            System.out.println("Introduce un número entre el 1 y el 100 \n" +
                    "comprobaremos si has acertado:");
            N = src.nextInt();

            resultado=numeroAadivinar-N;

            if(resultado==0){

                System.out.println("Enhorabuena has acertado el número!!");
            }

            if(resultado>=1&&resultado<=10){

                System.out.println("Caliente!! Hay una diferencia entre 1 y 10");
            }

            if (resultado>10&&resultado<=25){

                System.out.println("Frío!! hay una diferencia entre 10 y 25");

            }

            if (resultado>25&&resultado<=50){

                System.out.println("Muy frío!! Hay una diferencia entre 25 y 50");
            }

            if (resultado>50){

                System.out.println("Ni te has acercado!!! hay una diferencia mayor a 50");
            }
            numIntentos++;

            }
        System.out.println("Has acertado en el siguiente número de intentos: "+numIntentos);

        }}




