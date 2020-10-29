/*12- Encontrar y mostrar todos los números de cuatro cifras que
 cumplen la condición de que la suma de las cifras de orden
 impar es igual a la suma de las cifras de orden par.*/

public class Prac12 {
    public static void main(String[] args) {

        System.out.println("Números de 4 cifras cuya suma de las cifras de orden impar es igual a la suma de las cifras de orden par: ");

      //Inciamos el bucle el valor más bajo de 4 cifras que hay
        for (int valorInicial = 1000; valorInicial <=9999 ; valorInicial++) {

            //Convertimos y troceamos el número de 4 cifras en 4 carácteres
char primerValorText= String.valueOf(valorInicial).charAt(0);
char segundoValorText= String.valueOf(valorInicial).charAt(1);
char tercerValorText= String.valueOf(valorInicial).charAt(2);
char cuartoValorText= String.valueOf(valorInicial).charAt(3);

//Ahora convertimos esos 4 carácteres en 4 números diferentes para poder operar con ellos
int primerValorInt= Integer.parseInt(String.valueOf(primerValorText));
int segundoValorInt= Integer.parseInt(String.valueOf(segundoValorText));
int tercerValorInt= Integer.parseInt(String.valueOf(tercerValorText));
int cuartoValorInt= Integer.parseInt(String.valueOf(cuartoValorText));

//Sumamos las cifras, pares con pares, igual con los de posición impar
int resultadoSumaPosicionImpar=primerValorInt+tercerValorInt;
int resultadoSumaPosicionPar=segundoValorInt+cuartoValorInt;

//Si la suma de los valores en posicón impar es igual a la suma de los valores en posición par. Entonces los imprimimos por pantalla. De lo contrario. Los omitimos. Ejemplo SÍ Imprimimos el 1001 pero NO el 1002
if(resultadoSumaPosicionImpar==resultadoSumaPosicionPar){

    System.out.println("\n"+valorInicial);

}


        }




    }


}
