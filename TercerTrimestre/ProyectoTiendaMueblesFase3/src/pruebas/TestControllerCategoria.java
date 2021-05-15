package pruebas;

import negocio.Categoria;


public class TestControllerCategoria {

    private negocio.Categoria categoria;
    private String[] categoriasTestSet = {"Gama A","Gama B","Gama C","Gama Z"};
    private String[] casosNoExistentes = {"Gama No Existente"};


    public TestControllerCategoria(){
        categoria = new negocio.Categoria();
    }

    public void ejecutar(){
        System.out.println("--- BEGIN TEST Controller CATEGORIA ---");
        crearCategoria();
        categoriaExists();
        getCategorias();
        modificarCategoria();
        getCategorias();
        System.out.println("--- END TEST Controller CATEGORIA");
        System.out.println("-");
    }

    public void crearCategoria(){

        boolean rdo;

        for (String cat : categoriasTestSet) {
            System.out.print("Prueba negocio.Categoria::crearCategoria('"+cat+"');");
            rdo = categoria.crearCategoria(cat);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }

    public void categoriaExists(){

        boolean rdo;

        // Casos en los que se espera Éxito
        for (String cat : categoriasTestSet) {
            System.out.print("Prueba negocio.Categoria::categoriaExists("+cat+");");
            rdo = categoria.categoriaExists(cat);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

        // Casos en los que se espera Fallo
        for (String cat : casosNoExistentes) {
            System.out.print("Prueba negocio.Categoria::categoriaExists("+cat+");");
            rdo = categoria.categoriaExists(cat);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }

    public void getCategorias(){

        boolean rdo;

        System.out.println("Prueba negocio.Categoria::getCategorias();");

        // Casos en los que se espera Éxito
        for (String cat : categoria.getCategorias()) {
            System.out.println(cat);
        }

    }

    public void modificarCategoria(){

        boolean rdo;

        // Casos en los que se espera Éxito
        for (String cat : categoriasTestSet) {
            System.out.print("Prueba negocio.Categoria::modificarCategoria('"+cat+"','"+cat+"_MODIFICADA"+"');");
            rdo = categoria.modificarCategoria(cat,cat+"_MODIFICADA");
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

        // Casos en los que se espera Fallo
        for (String cat : casosNoExistentes) {
            System.out.print("Prueba negocio.Categoria::modificarCategoria('"+cat+"','"+cat+"_MODIFICADA"+"');");
            rdo = categoria.modificarCategoria(cat,cat+"_MODIFICADA");
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }



}
