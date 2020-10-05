public class Prac4 {

    public static void main(String[] args) {

        int A = 1, B = 2, C = 3, D = 4, aux=0;
//Declarando una variable auxiliar, podremos guardar el valor de otra variable y usarlo más adelante
        System.out.println("===Valores inciales=== \n"
                + "A = " + A + "\n"
                + "B = " + B + "\n"
                + "C = " + C + "\n"
                + "D = " + D);
        System.out.println("===Valores finales===");
        aux=B;
        B=C;
        System.out.println("B toma el valor de C -> B = "+B);
        C=A;
        System.out.println("C toma el valor de A -> C = "+C);
        A=D;
        System.out.println("A toma el valor de D -> A = "+A);
        B=aux;
        D=B;
        System.out.println("D toma el valor de B -> D = "+D);

    }
}
