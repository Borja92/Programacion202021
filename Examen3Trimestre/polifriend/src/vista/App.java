package vista;

import modelo.Usuario;

import java.util.Scanner;

public class App {

    Scanner entrada = new Scanner(System.in);

    private void mostrarOpcionesMenu()
    {
        System.out.println("------------------------");
        System.out.println("MENU FRIENDS POLITECNICO");
        System.out.println("1. Registrarte como usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("0. Salir de la aplicación");
    }

    public int menu()
    {
            int opcion=-1;
            mostrarOpcionesMenu();
            try {
                opcion = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Error: La opción debe ser un número entero.");
                entrada.next();
            }
            return opcion;
    }

    public modelo.Usuario getValoresRegistro()
    {
        /*   Falta control de Errores  */
        modelo.Usuario usuario = new Usuario();
        System.out.println("------------------------");
        System.out.println("Introduzca su dirección de email: ");
        usuario.setEmail(entrada.next());
        System.out.println("------------------------");
        System.out.println("Introduzca su nickname: ");
        usuario.setUser(entrada.next());
        System.out.println("------------------------");
        System.out.println("Introduzca su contraseña: ");
        usuario.setPassword(entrada.next());
        return usuario;
    }

    public modelo.Usuario getValoresLogin()
    {
        /*    Falta control de Errores      */
        modelo.Usuario usuario = new Usuario();
        System.out.println("------------------------");
        System.out.println("Introduzca su dirección de email: ");
        usuario.setEmail(entrada.next());
        System.out.println("------------------------");
        System.out.println("Introduzca su contraseña: ");
        usuario.setPassword(entrada.next());
        return usuario;
    }

    public void salida()
    {
        System.out.println("Hasta Pronto!");
    }

}
