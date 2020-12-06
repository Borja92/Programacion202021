import java.util.Arrays;

public class Prac2Extra {


    int[][] matriz = { {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}};


    public int[][] getMatriz() {

        return this.matriz;

    }

    //Devuelve la media de los valores de la matriz
    public int media() {

        int suma = 0;
        int resultadoMedia = 0;
        for (int fila = 0; fila < getMatriz().length; fila++) {


            for (int columnas = 0; columnas < getMatriz().length; columnas++) {


                suma += getMatriz()[fila][columnas];

                resultadoMedia = suma / getMatriz()[fila][columnas];

            }
        }
        return resultadoMedia;
    }

    //Devuelve el valor más bajo y el más alto del conjunto de la matriz
    public int[] valorMinimoYmaximo() {

        int[] minMax = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        int valor = 0;
        for (int filas = 0; filas < getMatriz().length; filas++) {

            for (int columnas = 0; columnas < getMatriz().length; columnas++) {

                valor = getMatriz()[filas][columnas];
                if (valor > minMax[0]) minMax[0] = valor;
                if (valor < minMax[1]) minMax[1] = valor;

            }
        }
        return minMax;
    }

    //Devuelve la suma de los valores de la diagonal descendente de la matriz
    public int sumaValoresDiagonalDescendente() {


        int suma = 0;

        for (int i = 0; i < getMatriz().length; i++) {

            suma += getMatriz()[i][i];
        }
        return suma;
    }

    //Devulve la suma de los valores que quedan por encima de la diagonal descendente
    public int sumaValoresPorEncimaDiagonalDescendente() {

        int suma = 0;

        for (int fila = 0; fila < getMatriz().length; fila++) {


            for (int columnas = 0; columnas< fila; columnas++) {


                suma += getMatriz()[fila][columnas];
            }
        }
        return suma;

    }

//Devulve el valor de la suma de la diagonal ascendente

    public int sumaDiagonalAscendente() {

        int suma = 0;

        for (int i = 0; i < getMatriz().length; i++) {
            suma += getMatriz()[getMatriz().length - 1-i][i];

        }
        return suma;

    }


    public static void main(String[] args) {

        Prac2Extra miMatriz = new Prac2Extra();

        System.out.println(Arrays.deepToString(miMatriz.getMatriz()));
        System.out.println("Suma de los valores de la diagonal ascendente: " + miMatriz.sumaDiagonalAscendente());
        System.out.println("Suma de valores por encima de la diagonal: " + miMatriz.sumaValoresPorEncimaDiagonalDescendente());

        System.out.println("MIN= " + miMatriz.valorMinimoYmaximo()[1] + " MAX=" + miMatriz.valorMinimoYmaximo()[0]);
        System.out.println("La media de los valores de la matriz es: " + miMatriz.media());
         System.out.println("Suma de valores en diagonal descendente: "+miMatriz.sumaValoresDiagonalDescendente());
    }

}
