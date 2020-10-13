import java.util.Scanner;

public class UsandoSwitch {
    public static void main(String[] args) {

        double cateto1, cateto2, hipotenusa, area;
        Scanner src = new Scanner(System.in);

        System.out.println("¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2.cm\n" +
                "3.m\n" +
                "\nElija  una opción: ");
        int unidad = src.nextInt();

        String unidadDemedida = null;

        switch (unidad) {

            case 1:
                unidadDemedida = "mm";
                break;
            case 2:
                unidadDemedida = "cm";
                break;
            case 3:
                unidadDemedida = "m";
                break;
            default:
                unidadDemedida = "no ha introducido una opción válida";
                System.exit(0);
        }

        System.out.println("¿Qué operación desea realizar?\n" +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
                "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
                "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa\n" +
                "4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
                "\nElija una opción: ");
        int opcion = src.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.");
                System.out.println("introduce el primer cateto: ");
                cateto1 = src.nextDouble();
                System.out.println("introduce el segundo cateto: ");
                cateto2 = src.nextDouble();
                hipotenusa = Math.hypot(cateto1, cateto2); //nuevo método
                System.out.printf("%nLa hipotenusa es de: %.2f%s. ", hipotenusa, unidadDemedida);
                break;

            case 2:
                System.out.println("2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa");

                System.out.println("Introduce el primer cateto: ");
                cateto1 = src.nextDouble();

                System.out.println("Introduce el valor de la hipotenusa: ");
                hipotenusa = src.nextDouble();

                cateto2 = Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2));

                System.out.printf("%nEl cateto a despejar del triángulo tiene una longitudo de: %.2f%s.", cateto2, unidadDemedida);
                break;

            case 3:
                System.out.println("3. Calcular el área de un triángulo a partir un cateto y la hipotenusa");

                System.out.println("Introduce el primer cateto: ");
                cateto1 = src.nextDouble();

                System.out.println("Introduce el valor de la hipotenusa: ");
                hipotenusa = src.nextDouble();

                cateto2 = Math.sqrt(Math.pow(hipotenusa, 2) - Math.pow(cateto1, 2));

                // System.out.println("cateto2 "+cateto2);
                area = cateto1 * cateto2 / 2;

                System.out.printf("%nEl área del triagulo calculado a partir de sus dos catetos es: %.2f%s.", area, unidadDemedida);
                break;

            case 4:
                System.out.println("4. Caluclar el área de un triángulo a partir de dos catetos.");

                System.out.println("Introduce el primer cateto: ");
                cateto1 = src.nextDouble();
                System.out.println("Introduce el segundo cateto: ");
                cateto2 = src.nextDouble();
                area = cateto1 * cateto2 / 2;
                System.out.printf("%nEl área del triagulo calculado a partir de su dos catetos es: %.2f%s.", area, unidadDemedida);

        }


    }
}
