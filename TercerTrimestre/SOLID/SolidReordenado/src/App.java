import Modelo.Coche;
import Negocio.Catalogo;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        catalogo.add(new Coche("Ford Mustang","1234ABC",50000));
        catalogo.add(new Coche("Skoda Fabia","2345CDE",20000));

        System.out.print("1. HTML\n2. HTML navegable\n3. XML\n4. CSV\nopcion:");
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int opcion = sc.nextInt();

        ClaseCliente claseCliente = new ClaseCliente(catalogo);
        claseCliente.ejecutar(opcion);
    }
}
