import java.util.Scanner;

public class PracticaEvaluable1 {

    public static void main(String[] args) {


        Scanner src = new Scanner(System.in);

        //Declaramos las variables
        String usuario = "usr2482", contrasenna = "Rr983dj#3";
        boolean accesoPermitido = false;
        int intentosFallidos = 0;

        do {

            //Pido al usuario introducir las credenciales

            System.out.println("\nIntroduzca usuario: ");
            String usuarioPorTeclado = src.nextLine();

            System.out.println("\nIntroduzaca la contraseña: ");
            String contrasennaPorTeclado = src.nextLine();

            //Compruebo si las credenciales se corresponden. Debiendo ser idénticas respetando minúsculas y mayúsculas

            if (usuarioPorTeclado.equals(usuario) & contrasennaPorTeclado.equals(contrasenna)) {

                //Si el usuario acierta. Muestro mensaje y finalizo el programa

                System.out.println("\nACCESO CONCEDIDO");
accesoPermitido=true;

//En caso de error al introducir credenciales. Salta aviso y cuenta como intento fallido
            } else {

                System.out.println("\nUSUARIO O CONTRASEÑA INCORRECTO");
                intentosFallidos++;
            }

//El bucle se repite mientras el accesoPermitido sea falso y los intentos no superen el tercero. El programa se detiene si el accesoPermitido es true o los intentos fallidos superan el número 3

        } while ((!accesoPermitido) & (intentosFallidos < 3));

        //Si el usuario falla 3 veces salta el siguiente mensaje. Y el programa finaliza

        if (intentosFallidos == 3) {

            System.out.println("\nUsuario bloqueado. Contacte con el dpto. de informática.");
        }

    }
}
