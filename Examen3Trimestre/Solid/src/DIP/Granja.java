package DIP;

import java.util.Scanner;

public class Granja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.print("¿Qué animal quieres?\n" +
                AnimalDeGranja.VACA + ". Vaca\n" +
                AnimalDeGranja.GALLINA + ". Gallina\n" +
                AnimalDeGranja.CERDO + ". Cerda\n" +
                "opcion: ");
        int opcion = sc.nextInt();

        // Aplica DIP a partir de aquí

        AnimalDeGranja animal = null;
        MenuOnomatopeya menuOnomatopeya= new MenuOnomatopeya();
        /* switch (opcion){
            case AnimalDeGranja.VACA:
                animal = new Vaca();
                break;
            case AnimalDeGranja.GALLINA:
                animal = new Gallina();
                break;
            default: // AnimalDeGranja.CERDO
                animal = new Cerdo();}*/
   animal=menuOnomatopeya.eligeAnimal(opcion);
    ;
        // Aplica DIP hasta aquí

        System.out.println(animal.habla());
    }
}
