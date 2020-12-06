/*1. Escribir un programa que lea un número de enteros entre 1 y 100 de
        la entrada estándar y genere un histograma con las frecuencias
        de cada entero en la secuencia.
        Para representar las barras del histograma utilizar secuencias
        del carácter ‘#’. Porejemplo, la secuencia:
        1, 1, 20, 1, 2, 20, 3, 3, 3,4,4,4,33,3 generaría la siguiente salida:
        1: ###
        2: #
        3: ####
        4: ###
        20:##
        33:#*/
public class Prac1Extra {


boolean valorRepetidoEnArray(  int x, int[] array){

    boolean valorRepetido=false;

    int valorArray=array[x];
    for (int i = x-1; i>=0 ; i--) {
        valorRepetido=valorArray==array[i];

        if (valorRepetido){
break;        }
    }
    return valorRepetido;

}

int contadorValoresRepetidos(int x, int[] array){
    int contador=0;
    for (int valor:array ) {
        if (valor==x){

            contador++;
        }
    }
return contador;
}

    //Método que hace uso del metodo "imprimirArray" y de nuevo recorre y pinta el carácter # dependiendo de los valores del array
    String almoadillasApintar(int numAlmoadillas) {

String s="";

        for (int i = 0; i <numAlmoadillas ; i++) {
            s+="#";
        }
return s;

}


void imprimirAlmoadillasPorValorEnArray(int [] array){

    for (int i = 0; i <array.length ; i++) {

        if (!valorRepetidoEnArray(i,array)){

            System.out.println(array[i]+"=>"+almoadillasApintar(contadorValoresRepetidos(array[i],array)));

        }
    }
}


    public static void main(String[] args) {
        Prac1Extra prac1Extra= new Prac1Extra();

int [] array1={1, 1, 20, 1, 2, 20, 3, 3, 3,4,4,4,33,3};


prac1Extra.imprimirAlmoadillasPorValorEnArray(array1);


    }
}
