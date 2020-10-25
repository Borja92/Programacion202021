/*2. Escribe un programa que lance y capture una excepción.*/

public class Ejemplo2 {

    public static void main(String[] args) {

        try {
            System.out.println("Mensaje mostrado por pantalla");
            Exception e = new Exception("Esto es un objeto Exception");
            throw e;
        } catch (Exception ex) {
            System.out.println("Excepcion capturada con mensaje: " + ex.getMessage());
        }
        System.out.println("Programa terminado");
    }


    }


