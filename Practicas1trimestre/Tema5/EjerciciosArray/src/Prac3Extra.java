/*3. Escriba un programa simule varios lanzamientos de un dado y
        muestre la frecuencia de cada una de las caras así como la
        proporción del número de veces que haya salido cada cara con
        respecto al total. Para ello simule 6000 lanzamientos de un dado
        utilizando la función Math.random()*6 para simular cada
        lanzamiento.*/


import java.util.Random;

public class Prac3Extra {
   //Declaramos una constante con el número de lanzamietos
    private final int NUM_LANZAMIENTOS = 6000;

  //Método que retorna un número aleatorio entre 1-6
    int numAletorio() {

        Random rdn = new Random();

        return rdn.nextInt(6) + 1;

    }

//Método que se encarga de toda la lógica
    void lanzaDados() {
//Declaro variables y array
        int dado, aux;
        double frecuencia, porcentaje;
        int[] arrayTiradasDados = new int[6];

        //Bucle for para hacer  las tiradas el número determinado por la constante
        for (int tirada = 0; tirada < NUM_LANZAMIENTOS; tirada++) {
          //Asigno valor a la variable dado mediante método numAleatorio
            dado = numAletorio();

          //Relleno el array con los números dados por la variable dado y
            arrayTiradasDados[dado - 1]++;
        }

        //Recorro con un bucle el contenido del array
        for (aux = 0; aux < arrayTiradasDados.length; aux++) {

       //Se realizan los calculos necesarios para calcular las variables frecuencia y porcentaje
            frecuencia = (double) arrayTiradasDados[aux] / NUM_LANZAMIENTOS;
            porcentaje = frecuencia * 100;

            //Imprimimos por pantalla los datos interesantes, la cara del dado, el número de veces que sale, su frecuencia y el porcentaje
            System.out.println("\t Cara: " + (aux + 1) + "\n " +
                    "\t Número de veces: " + arrayTiradasDados[aux] + "\n" +
                    "\t Frecuencia: " + frecuencia + "\n" +
                    "\t Porcentaje: " + String.format("%.2f", porcentaje) + "%" + "\n");
        }


    }


    public static void main(String[] args) {


        Prac3Extra prac3Extra = new Prac3Extra();

        prac3Extra.lanzaDados();


    }
}
