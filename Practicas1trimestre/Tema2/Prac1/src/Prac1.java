import java.util.Scanner;

public class Prac1 {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        int N=5;
        double A=4.56;
        char C='a';

        System.out.println("El valor de N= "+N+"\nEl valor de A= "+A+ "\nEl valor de C= "+C);

        System.out.println("=====Operaciones=====\n");

   double suma= N+A;
        System.out.println(N+" + "+A+" = "+suma);
        double diferencia=A-N;
        System.out.println(A+" - "+N+" = "+diferencia);
        System.out.println("El valor numérico del carácter  a es: " +(int)C);// parseamos el carácter a al tipo int, y nos sale automáticamente su valor numérico en UTF-8 (97)

    }

}
