package pruebas;

import negocio.Seccion;

import java.util.List;

public class TestControllerSeccion {


    private negocio.Seccion seccion;
    private String[] seccionesTestSet = {"Sección A","Sección B","Sección C","Sección Z"};
    private String[] casosNoExistentes = {"Sección No Existente"};


    public TestControllerSeccion()
    {
        seccion = new Seccion();
    }

    public void ejecutar(){
        System.out.println("--- BEGIN TEST Controller SECCIÓN ---");
        crearSeccion();
        getSecciones();
        seccionExists();
        modificarSeccion();
        getSecciones();
        deleteSeccion();
        getSecciones();
        System.out.println("--- END TEST Controller SECCIÓN");
        System.out.println("-");
    }


    public void crearSeccion(){
        boolean rdo;

        for (String sec : seccionesTestSet) {
            System.out.print("Prueba negocio.Seccion::crearSeccion('"+sec+"');");
            rdo = seccion.crearSeccion(sec);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }
    }


    public void getSecciones(){

        boolean rdo;

        System.out.println("Prueba negocio.Seccion::getSecciones();");

        // Casos en los que se espera Éxito
        for (String sec : seccion.getSecciones()) {
            System.out.println(sec);
        }

    }


    public void seccionExists(){

        boolean rdo;

        // Casos en los que se espera Éxito
        for (String sec : seccionesTestSet) {
            System.out.print("Prueba negocio.Categoria::seccionExists("+sec+");");
            rdo = seccion.seccionExists(sec);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

        // Casos en los que se espera Fallo
        for (String sec : casosNoExistentes) {
            System.out.print("Prueba negocio.Categoria::seccionExists("+sec+");");
            rdo = seccion.seccionExists(sec);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }


    public void modificarSeccion(){

        boolean rdo;

        // Casos en los que se espera Éxito
        for (String sec : seccionesTestSet) {
            System.out.print("Prueba negocio.Seccion::modificarSeccion('"+sec+"','"+sec+"_MODIFICADA"+"');");
            rdo = seccion.modificarSeccion(sec,sec+"_MODIFICADA");
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

        // Casos en los que se espera Fallo
        for (String sec : casosNoExistentes) {
            System.out.print("Prueba negocio.Seccion::modificarSeccion('"+sec+"','"+sec+"_MODIFICADA"+"');");
            rdo = seccion.modificarSeccion(sec,sec+"_MODIFICADA");
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }


    public void deleteSeccion(){
        boolean rdo;
        // Casos en los que se espera Éxito
        System.out.print("Prueba negocio.Seccion::deleteTiposElemento('"+seccion.getSecciones().get(3)+"');");
        rdo = seccion.deleteSeccion(seccion.getSecciones().get(3));
        System.out.println((rdo) ? " Éxito": " Fallo");


        // Casos en los que se espera Fallo
        for (String sec : casosNoExistentes) {
            System.out.print("Prueba negocio.Seccion::deleteTiposElemento('"+seccion.getSecciones().get(2)+"');");
            rdo = seccion.deleteSeccion(sec);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }
    }



}
