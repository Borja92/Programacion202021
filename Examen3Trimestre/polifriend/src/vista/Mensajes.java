package vista;

import java.util.Scanner;

public class Mensajes {

    public static void mostrarMensaje(String codigo)
    {
        System.out.println(mensaje(codigo));
    }

    public static String mensaje(String codigo)
    {
        String mensaje="";
        switch (codigo)
        {
            case "email_format_not_valid" : mensaje = "El formato del email no es válido"; break;
            case "email_already_exists" : mensaje = "El email ya existe en nuestra base de datos."; break;
            case "error_user_creation" : mensaje = "No se ha podido crear el usuario."; break;
            case "registration_sucessful" : mensaje = "El usuario se ha regitrado con éxito"; break;
            case "login_ok" : mensaje = "Login Correcto"; break;
            case "login_ko" :  mensaje = "El email o la contraseña no son correctos"; break;
            case "not_auth" :  mensaje = "Usuario no autentificado"; break;
            case "code_dont_apply_friendlist" : mensaje = "El código seleccionado no pertenece a ninguno de tus amigos"; break;
            case "new_notifications" : mensaje = "\u001B[31m"+"TIENE NUEVOS MENSAJES \n(Vaya a su lista de amigos)"+"\u001B[0m"; break;
            case "new_friends" : mensaje = "\u001B[32m"+"TIENE NUEVOS AMIGOS \n(Vaya a su lista de amigos)"+"\u001B[0m"; break;
        }
        return mensaje;
    }


    public static String requestString(String mensaje)
    {
        Scanner input = new Scanner(System.in);
        String cadena;
        System.out.println(mensaje);
        cadena=input.nextLine();
        if (cadena!="") return cadena;
        else return null;
    }

    public static int menu()
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=-1;
        try {
            opcion = entrada.nextInt();
        } catch (Exception e) {
            System.out.println("Error: La opción debe ser un número entero.");
            entrada.next();
        }
        return opcion;
    }
}
