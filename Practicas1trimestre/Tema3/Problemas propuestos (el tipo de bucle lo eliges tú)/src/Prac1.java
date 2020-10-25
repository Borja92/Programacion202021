import java.util.Random;
import java.util.Scanner;

/*1-. Realiza un programa que proponga multiplicar dos números aleatorios
        de una cifra entre sí. el objetivo es que nos permita contestar a modo
        de examen el resultado de la multiplicación.  Repetir el proceso 10 veces
        de manera que al finalizar este, se muestre por pantalla “Apto” o “No Apto”
        en función de la puntuación obtenida.  Siendo 5 la mínima puntuación
        para obtener la calificación de Apto.  El valor de cada respuesta acertada será de un punto.*/
public class Prac1 {

    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        Random rnd = new Random();

        int numero1=0, numero2=0, resultadoUsuario=0,resultadoCalculado=0, numeroAciertos=0;

for (int i=0;i<10;i++){

    numero1=rnd.nextInt(10);
    numero2=rnd.nextInt(10);
    resultadoCalculado=numero1*numero2;

    System.out.println("Cuál es el resultado de "+numero1+"*"+numero2);
resultadoUsuario=src.nextInt();


if(resultadoCalculado==resultadoUsuario) {
    numeroAciertos++;

}

}
        if (numeroAciertos>=5){
            System.out.println("Apto!!\n"+numeroAciertos+" aciertos.");

        } else {

            System.out.println("No apto!!\n"+numeroAciertos+ " aciertos.");

        }
}

    }


