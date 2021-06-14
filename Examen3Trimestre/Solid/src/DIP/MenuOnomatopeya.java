package DIP;

public class MenuOnomatopeya {

    public AnimalDeGranja eligeAnimal(int opcion) {
        AnimalDeGranja animal = null;
        switch (opcion) {
            case AnimalDeGranja.VACA:
                animal = new Vaca();
                break;
            case AnimalDeGranja.GALLINA:
                animal = new Gallina();
                break;
            default: // AnimalDeGranja.CERDO
                animal = new Cerdo();

        }

    return animal;
    }

}