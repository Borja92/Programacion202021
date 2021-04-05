public class Ejercicio2 {


        // Esta clase contiene como atributo una matriz cuatrada de 3x3 que inicializaremos unicamente con
        // valores 0 o 1.
        int [][] matriz = { {1, 1, 0},
                {0, 1, 0},
                {1, 0, 0}};

    /**
     * Logica principal del juego, que comprueba quien de las dos fichas ha ganado
     * @param ficha Ficha que queremos comprobar si ha ganado o no
     * @return un boolean en consonancia si ha ganado o no
     */
        public boolean tresEnRaya(int ficha) {
            // Devolverá verdadero en caso de existir ficha (posibles valores de entrada 0 o 1) con 3 en raya
int countVertical=0, countHorizontal=0,  countDIagonalDescendente=0, countDiagonalAscendente=0, aux=0;
int tamannoMAtriz=matriz.length;

            for (int i = 0; i <tamannoMAtriz ; i++) {

                for (int j = 0; j < tamannoMAtriz; j++) {
                    //System.out.print(matriz[i][j]);
                if (matriz[i][j]==ficha)
                    countHorizontal++;

                if (matriz[j][i]==ficha)
                    countVertical++;

                if (matriz[j][j]==ficha)
                    countDIagonalDescendente++;

                aux=tamannoMAtriz-1-j;
  if (matriz[j][aux]==ficha)
      countDiagonalAscendente++;

  }}
               if (countVertical==3||countHorizontal==3||countDiagonalAscendente==3||countDIagonalDescendente==3){
                   return true;
               }

        return false;
        }

public String esGAnador( int ficha){

            if (tresEnRaya(ficha)){
            return ("ES GANADOR!!");
            } else return ("Es perdedor");

}
        public static void main(String[] args) {

            // Probar el programa instanciando una variable de la clase Juego en este mismo main que
            // compruebe si existe tres en raya para el jugador 0 mostrando la palabra "GANADOR" o
            // "PERDEDOR" y lo mismo para el jugador 1

            Ejercicio2 ejercicio2= new Ejercicio2();
            System.out.println("¿Es ganador 1? "+ejercicio2.tresEnRaya(1));
            System.out.println("¿Es ganador 0? "+ejercicio2.tresEnRaya(0));
            System.out.println(ejercicio2.esGAnador(1));
            System.out.println(ejercicio2.esGAnador(0));

        }



}


