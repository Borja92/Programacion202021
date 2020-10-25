/*3- Escribe un programa que pinte por pantalla una pirámide rellena a
        base de asteriscos. La base de la pirámide debe estar formada por
        9 asteriscos.*/


public class Prac3 {

    public static void main(String[] args) {

    int filas=5, asteriscos=0;

   /* for (int i=0; i<=filas;i++){

        for (int j = 1; j <=i ; j++) {

            System.out.print("* ");
        }
        System.out.println();
    }
*/

        for (int i = 1; i <=filas ; i++, asteriscos=0) {

            for (int espacioBlanco=0; espacioBlanco<=filas - i; espacioBlanco++) {
                System.out.print("  ");
                // System.out.print(espacioBlanco);

            }
        while (asteriscos !=2*i-1){
            System.out.print("* ");
            asteriscos++;
           //System.out.print(asteriscos);

        }
            System.out.println();
        }


    }

}
