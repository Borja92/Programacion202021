import java.util.Scanner;

public class ActividadExtraIf {

    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        System.out.println("¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2.cm\n" +
                "3.m\n" +
                "\nElija  una opción: ");
    int unidad=src.nextInt();

    String unidadDemedida = null;

    if(unidad==1) {
        unidadDemedida="mm";
                
    }
    else if(unidad==2) {

        unidadDemedida="cm";
    }
    else if(unidad==3){
        unidadDemedida="m";

    }
        System.out.println("¿Qué operación desea realizar?\n" +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
                "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
                "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa\n" +
                "4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
                "\nElija una opción: ");
int opcion=src.nextInt();


//incio bloque 1

if(opcion==1) {
    System.out.println("introduce el primer cateto: ");
    double cateto1=src.nextDouble();
    System.out.println("introduce el segundo cateto: ");
double cateto2=src.nextDouble();

/*double hipotenusa= Math.sqrt(Math.pow(cateto1, 2)+ Math.pow(cateto2, 2)); // método antiguo
   System.out.printf("%nLa hipotenusa es %.2f.", hipotenusa+unidadDemedida);*/
double hipotenusa=Math.hypot(cateto1, cateto2); //nuevo método
    System.out.printf("%nLa hipotenusa es de: %.2f%s. ", hipotenusa, unidadDemedida);
   // System.out.println("La hipotenusa es de: "+ hipotenusa+unidadDemedida);

    System.out.println("\n=====Fin de programa=====");
//fin bloque 1

    //inicio bloque 2
}else if (opcion==2){

    System.out.println("Introduce el primer cateto: ");
    double cateto1=src.nextDouble();

    System.out.println("Introduce el valor de la hipotenusa: ");
double hipotenusa= src.nextDouble();

double cateto2= Math.sqrt(Math.pow(hipotenusa, 2)- Math.pow(cateto1, 2));

System.out.printf("%nEl cateto a despejar del triángulo tiene una longitudo de: %.2f%s.", cateto2, unidadDemedida);
//fin bloque 2
}
//inicio bloque 3
else if (opcion==3){

    System.out.println("Introduce el primer cateto: ");
    double cateto1=src.nextDouble();

    System.out.println("Introduce el valor de la hipotenusa: ");
    double hipotenusa= src.nextDouble();

    double cateto2= Math.sqrt(Math.pow(hipotenusa, 2)- Math.pow(cateto1, 2));

   // System.out.println("cateto2 "+cateto2);
    double area=cateto1*cateto2/2;

    System.out.printf("%nEl área del triagulo calculado a partir de sus dos catetos es: %.2f%s.", area,unidadDemedida);


    System.out.println("\n=====Fin Programa=====");

}
//fin bloque 3

//Inicio bloque 4
else if(opcion==4) {

    System.out.println("Introduce el primer cateto: ");
    double cateto1 = src.nextDouble();
    System.out.println("Introduce el segundo cateto: ");
    double cateto2 = src.nextDouble();

double area=cateto1*cateto2/2;

    System.out.printf("%nEl área del triagulo calculado a partir de sus dos catetos es: %.2f%s.", area,unidadDemedida);
    System.out.println("\n=====Fin Programa=====");
}

    }
}
