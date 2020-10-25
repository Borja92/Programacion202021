/*5- Representa el funcionamiento de un reloj. Ya sabes que
 tiene 24 horas, cada hora 60 minutos y cada minuto 60 segundos.
 El programa pregunta ¿Quieres que funcione el reloj (s/n)?
 En caso afirmativo funcionará durante 24 horas y volverá a preguntar
 una vez que se llegue a 23:59:59 termina al indicar que no queremos
 que funcione.*/

import java.util.Scanner;

public class Prac5 {

    public static void main(String[] args) throws InterruptedException {
        Scanner src = new Scanner(System.in);

        String opcion1, opcion2 = "";
        int hora = 0, minuto = 0, segundo = 0;

        System.out.println("¿Quieres que funcione el reloj (s/n)?");
         opcion1=src.nextLine();



        while (opcion1.equalsIgnoreCase("s")){
//Bloque interfaz/visualización
            if(hora<10){
                System.out.print("0");

            }
            System.out.print(hora+":");

            if (minuto<10) {
                System.out.print("0");
            }


            System.out.print(minuto+":");
        if (segundo<10){

            System.out.print("0");
        }
            System.out.println(segundo);


        //Bloque lógico aumentar tiempo segundo  a segundo
segundo++;


if (segundo==60){

    segundo=0;
minuto++;

if (minuto==60){
    minuto=0;
    hora++;

if (hora==24){

    hora=0;
}
}
}
//Thread.sleep(1000);   //Esta instrucción retrasa la ejeción haciendolo más realista

    //Bloque de código de control sobre seguir o no ejecutando el reloj
     if (hora==23&minuto==59&segundo==59){

         System.out.println("¿Desea salir finalizar el reloj) s/n");
         opcion2=src.nextLine();
     }
     if (opcion2.equalsIgnoreCase("s")){

         break;
     }
        }
       }

    }

