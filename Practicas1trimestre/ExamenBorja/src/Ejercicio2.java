public class Ejercicio2 {


    // Esta clase contiene como atributo una matriz cuatrada de 3x3 que inicializaremos unicamente con
    // valores 0 o 1.
    int[][] matriz = {      {1, 0, 1},
                                    {0, 1, 0},
                                     {0, 0, 0}};
    //Asigno a cada valor a una variable para poder calcular comodamente más adelante
    int a = matriz[0][0];
    int b = matriz[0][1];
    int c = matriz[0][2];
    int d = matriz[1][0];
    int e = matriz[1][1];
    int f = matriz[1][2];
    int g = matriz[2][0];
    int h = matriz[2][1];
    int i = matriz[2][2];

    //El métod
    boolean tresEnRaya(int ficha) {
        esGanador0(ficha);
        esGanador1(ficha);


        return tresEnRaya(ficha);
    }

    /*public int[][] getMatriz() {

        return this.matriz;

    }*/

    /* ***************************************************** *
     * Métodos lógicos que se encargan de comprobar la ficha ganadora *
     * ***************************************************** */
    public String esGanador0(int ficha) {
        boolean esGanador0 = false;
        if (ficha == 0) {
            if (sumaValoresEnColumna0() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresEnColumna1() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresEnColumna2() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresDiagonalDescendente() == ficha) {
                esGanador0 = true;
            }
            if (sumaDiagonalAscendente() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresEnDimension0() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresEnDimension1() == ficha) {
                esGanador0 = true;
            }
            if (sumaValoresEnDimension2() == ficha) {
                esGanador0 = true;
            }

            if (esGanador0) {
                System.out.println("El 0 es ganador");
            }
        }
        return "¿Es ganador 0?" + esGanador0;
    }

    public String esGanador1(int ficha) {
        boolean esGanador1 = false;
        if (ficha == 3) {
            if (sumaValoresEnColumna0() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresEnColumna1() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresEnColumna2() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresDiagonalDescendente() == ficha) {
                esGanador1 = true;
            }
            if (sumaDiagonalAscendente() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresEnDimension0() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresEnDimension1() == ficha) {
                esGanador1 = true;
            }
            if (sumaValoresEnDimension2() == ficha) {
                esGanador1 = true;
            }

            if (esGanador1) {
                System.out.println("El 1 es ganador");
            }
        }

        return "¿Es ganador 1?" + esGanador1;
    }

    /**
     * Fin de la declaración de métodos  lógicos
     */

    /* ***************************************************** *
     * Métodos sumatorios de los valores , diferenciados en
     * dimensiones(filas), columnas y diagonals ascendente y descendente *
     * ***************************************************** */
    public int sumaValoresDiagonalDescendente() {


        int suma = a + e + i;


        return suma;
    }

    public int sumaDiagonalAscendente() {

        int suma = g + e + c;


        return suma;

    }

    public int sumaValoresEnDimension0() {

        int suma = a + b + c;
        return suma;
    }

    public int sumaValoresEnDimension1() {

        int suma = d + e + f;

        return suma;
    }


    public int sumaValoresEnDimension2() {

        int suma = g + h + i;

        return suma;
    }

    public int sumaValoresEnColumna0() {

        int suma = a + d + g;


        return suma;
    }

    public int sumaValoresEnColumna1() {

        int suma = b + e + h;


        return suma;
    }

    public int sumaValoresEnColumna2() {

        int suma = c + f + i;


        return suma;
    }

    /**
     * Fin de la declaración de métodos sumatorios
     */

    public static void main(String[] args) {
        Ejercicio2 ejercicio2 = new Ejercicio2();

//ejercicio2.tresEnRaya()

       /* System.out.println("Suma en dimensión 0= "+ejercicio2.sumaValoresEnDimension0());
        System.out.println("Suma en dimensión 1= "+ejercicio2.sumaValoresEnDimension1());
        System.out.println("Suma en dimensión 2= "+ejercicio2.sumaValoresEnDimension2());
        System.out.println("Suma en diagonal ascendente= "+ejercicio2.sumaDiagonalAscendente());
        System.out.println("Suma en diagonal descendente= "+ejercicio2.sumaValoresDiagonalDescendente());

        System.out.println("Suma en columna 0= "+ejercicio2.sumaValoresEnColumna0());
        System.out.println("Suma en columna 1= "+ejercicio2.sumaValoresEnColumna1());
        System.out.println("Suma en columna 2= "+ejercicio2.sumaValoresEnColumna2());
*/


       //Llamadas a métodos
        System.out.println(ejercicio2.esGanador0(0));
        System.out.println(ejercicio2.esGanador1(1));


        // Probar el programa instanciando una variable de la clase Juego en este mismo main que
        // compruebe si existe tres en raya para el jugador 0 mostrando la palabra "GANADOR" o
        // "PERDEDOR" y lo mismo para el jugador 1
    }
}
