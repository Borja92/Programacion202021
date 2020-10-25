/*6- Decir todos los números perfectos entre 2 y 1000.
 Un número es perfecto cuando la suma de sus divisores
 (menos el mismo) es igual a sí mismo. Por ej. 6 sus divisores
 son: 1, 2,3 y 1+2+3=6*/


public class Prac6 {

    public static void main(String[] args) {

        int suma;

        System.out.println("Números perfectos entre 2 y 1000: ");

        for (int numeroAcomprobar = 2; numeroAcomprobar < 1000; numeroAcomprobar++) {

            suma = 0;
            for (int divisores = 1; divisores < numeroAcomprobar; divisores++) {

                if (numeroAcomprobar % divisores == 0) {
                    suma += divisores;
                }
            }

            if (numeroAcomprobar == suma) {

                System.out.println(numeroAcomprobar);
            }
        }
    }
}
