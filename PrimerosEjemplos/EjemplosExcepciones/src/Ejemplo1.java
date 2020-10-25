/*1. Escribe un programa que genere un número aleatorio e indique si el número generado
        es par o impar. El programa utilizará para ello el lanzamiento de una excepción.*/


public class Ejemplo1 {

    public static void main(String[] args) {


        try {
            System.out.println("Generando número aleatorio");
            int entero = (int) (Math.random() * 1000);
            if (entero % 2 == 0) {
                throw new Exception("Se genero un numero par");
            } else {
                throw new Exception("Es impar");
            }
        }
        catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }

    }
}
