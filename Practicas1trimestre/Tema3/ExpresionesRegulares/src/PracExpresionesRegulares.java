 /*EJERCICIOS

        Escribe las expresiones regulares que apliquen los siguientes criterios:

        1. Nombre de Usuario
        2. Coindidencia de un valor hexadecimal
        3. Dirección de correo electrónico válido.
        4. URL válida.
        5. Dirección IP válida
        6. Etiqueta HTML*/

 import java.util.Scanner;

 public class PracExpresionesRegulares {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);


//Validar nombre de usuario
        String nombreUsuario = "us3r_n4m3";
        String nombreUsuarioNoValido="th1s1swayt00_l0ngt0beausername";

        System.out.println(nombreUsuario.matches("^[a-z0-9_-]{3,16}$")+"\nEl nombre de usuario "+nombreUsuario+" es válido.");
        System.out.println(nombreUsuarioNoValido.matches("^[a-z0-9_-]{3,16}$")+"\n Nombre de usuario no valido");
        //Validar valor hexadecimal

String valorHexadecimal="#a3c113";
String valorHexadecimalNovalido="#4d82h4";
        System.out.println(valorHexadecimal.matches("^#?([a-f0-9]{6}|[a-f0-9]{3})$")+"\nEl valor hexadecimal es válido.");

        System.out.println(valorHexadecimalNovalido.matches("^#?([a-f0-9]{6}|[a-f0-9]{3})$")+"\nEl valor hexadecimal es no válido.");

        //Validar dirección de e-mail


        String email="john@doe.com";
        String emailNoValido="john@doe.algo";


        System.out.println(email.matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")+"\nEl e-mail es válido.");
        System.out.println(emailNoValido.matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")+"\nEl e-mail no es válido.");

///Validar  URL

        String url="https://net.tutsplus.com/about";
        String urlNoValida="http://Google.com/some/File!.html";

        System.out.println(url.matches("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w\\.-]*)*\\/?$")+"\nLa URL es válida.");
        System.out.println(urlNoValida.matches("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w\\.-]*)*\\/?$")+"\nLa URL no es válida.");



        //Validar dirección IP


        String ip="73.60.124.136";
        String ipNoValida="256.60.124.136";

        System.out.println(ip.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")+"\nLa IP es válida.");
        System.out.println(ipNoValida.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$")+"\nLa IP no es válida.");
//Validar etiqueta HTML

        String etiquetaHtml="<img src=\"img.jpg\" alt=\"miimagen\"/>";
        String etiquetaHtmlNoValida="<img src=\"img.jpg\"alt=\"mi imagen\"/>";

        System.out.println(etiquetaHtml.matches("^<([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$")+"La etiqueta HTML es válida.");
        System.out.println(etiquetaHtmlNoValida.matches("^<([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$")+"La etiqueta HTML no es válida.");

    }
}