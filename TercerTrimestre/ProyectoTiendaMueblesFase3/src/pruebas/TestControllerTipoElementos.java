import negocio.TipoElementos;
import persistencia.TipoElementoDAO;

import java.util.List;

public class TestControllerTipoElementos {


    private negocio.TipoElementos tipoElementos;
    private String[] elementosTestSet = {"TipoElemento A","TipoElemento B","TipoElemento C","TipoElemento Z"};
    private String[] tipoElementoTestSet = {"Silla","Mesa","Estanteria","TV Unit"};

    private String[] casosNoExistentes = {"TipoElemento No Existente"};

    public TestControllerTipoElementos(){
        tipoElementos = new TipoElementos();
    }



    public void ejecutar(){
        System.out.println("--- BEGIN TEST Controller TIPOELEMENTOS ---");
        crearTipoElemento();
        getTiposElementos();
        TipoElementosExists();
        modificarTipoElemento();
        getTiposElementos();
        deleteTiposElemento();
        getTiposElementos();
        System.out.println("--- END TEST Controller TIPOELEMENTOS");
        System.out.println("-");
    }

    public void crearTipoElemento(){
        boolean rdo;

        for (String tip : elementosTestSet) {
            System.out.print("Prueba negocio.TipoElemento::crearTipoElemento('"+tip+"');");
            rdo = tipoElementos.crearTipoElemento(tip);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }
    }


    public void getTiposElementos(){

        boolean rdo;

        System.out.println("Prueba negocio.TipoElementos::getTipoElementos();");

        // Casos en los que se espera Éxito
        for (String tip : tipoElementos.getTiposElementos()) {
            System.out.println(tip);
        }

    }


    public void TipoElementosExists(){

        boolean rdo;

        // Casos en los que se espera Éxito
        for (String tip : elementosTestSet) {
            System.out.print("Prueba negocio.Categoria::TipoElementosExists("+tip+");");
            rdo = tipoElementos.tipoElementoExists(tip);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

        // Casos en los que se espera Fallo
        for (String tip : casosNoExistentes) {
            System.out.print("Prueba negocio.Categoria::TipoElementosExists("+tip+");");
            rdo = tipoElementos.tipoElementoExists(tip);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }


    public void modificarTipoElemento(){

        boolean rdo;
        int i = 0;

        // Casos en los que se espera Éxito
        for (String tip : elementosTestSet) {
            System.out.print("Prueba negocio.TipoElementos::modificarTipoElemento('"+tip+"','"+tipoElementoTestSet[i]+"');");
            rdo = tipoElementos.modificarTipoElemento(tip,tipoElementoTestSet[i]);
            System.out.println((rdo) ? " Éxito": " Fallo");
            i++;
        }

        // Casos en los que se espera Fallo
        for (String tip : casosNoExistentes) {
            System.out.print("Prueba negocio.TipoElementos::modificarTipoElemento('"+tip+"','"+tip+"_MODIFICADO"+"');");
            rdo = tipoElementos.modificarTipoElemento(tip,tip+"_MODIFICADO");
            System.out.println((rdo) ? " Éxito": " Fallo");
        }

    }


    public void deleteTiposElemento(){
        boolean rdo;
        // Casos en los que se espera Éxito
            System.out.print("Prueba negocio.Categoria::deleteTiposElemento('"+tipoElementos.getTiposElementos().get(2)+"');");
            rdo = tipoElementos.deleteTiposElemento(tipoElementos.getTiposElementos().get(2));
            System.out.println((rdo) ? " Éxito": " Fallo");


        // Casos en los que se espera Fallo
        for (String tip : casosNoExistentes) {
            System.out.print("Prueba negocio.Categoria::deleteTiposElemento('"+elementosTestSet[2]+"');");
            rdo = tipoElementos.deleteTiposElemento(elementosTestSet[2]);
            System.out.println((rdo) ? " Éxito": " Fallo");
        }
    }


}
