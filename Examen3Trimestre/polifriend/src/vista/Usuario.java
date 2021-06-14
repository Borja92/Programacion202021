package vista;


public class Usuario {



    public void mostrarPerfil(modelo.Usuario usuario) {
        System.out.println("");
        System.out.println("");
        System.out.println("Nickname: "+usuario.getUser());
        System.out.println("---------------");
        System.out.println(usuario.getAvatar());
        System.out.println("---------------");
        System.out.println(usuario.getDescription());
        System.out.println("---------------");
        if (usuario.getAficiones()==null) System.out.println("Sin Aficiones - Complete su perfil");
        else System.out.println("Aficiones: "+usuario.getAficiones());
    }

    public void mostrarOpcionesEditar()
    {
        System.out.println("------------------------");
        System.out.println("MENU FRIENDS POLITECNICO");
        System.out.println("1. Editar Nickname");
        System.out.println("2. Cambiar Avatar");
        System.out.println("3. Cambiar Descripción");
        System.out.println("4. Añadir Aficiones");
        System.out.println("5. Eliminar Aficiones");
        System.out.println("0. volver al Perfil");
    }

    public void mostrarOpcionesMenu()
    {
        System.out.println("------------------------");
        System.out.println("MENU FRIENDS POLITECNICO");
        System.out.println("1. Editar Perfil");
        System.out.println("2. Buscar Amigos");
        System.out.println("3. Mostrar tus Amigos");
        System.out.println("0. Salir de la aplicación");
    }


    
}
