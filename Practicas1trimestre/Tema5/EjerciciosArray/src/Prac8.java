/*8. Escribir un programa que calcule el determinante de una matriz
    de 3x3. Pruébelo con la matriz [ [1,2,3], [4,5,6], [7,8,8] ]
     cuyo determinante es 3.

        | a b c |
A =  | d e f |
        | g h i |
detA = aei+bfg+cdh-afh-bdi-ceg
     */
public class Prac8 {

    public static void main(String[] args) {

     //Declaramos la matriz
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 8}};
//Asiganmos los valores a variables indepentiendes

        int a = matriz[0][0];
        int b = matriz[0][1];
        int c = matriz[0][2];
        int d = matriz[1][0];
        int e = matriz[1][1];
        int f = matriz[1][2];
        int g = matriz[2][0];
        int h = matriz[2][1];
        int i = matriz[2][2];
//Calculamos la determinante
        int determinanteMatriz = a * e * i + b * f * g + c * d * h - a * f * h - b * d * i - c * e * g;
//Mostramos por pantalla el resultado que debe dar 3
        System.out.println("El resultado de la determinante de la matriz es: "+determinanteMatriz);

    }
}
