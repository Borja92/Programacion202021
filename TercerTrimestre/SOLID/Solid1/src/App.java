import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        catalogo.add(new Coche("Ford Mustang","1234ABC",50000));
        catalogo.add(new Coche("Skoda Fabia","2345CDE",20000));

        ClaseCliente claseCliente = new ClaseCliente(catalogo);
        claseCliente.ejecutar();
    }
}
