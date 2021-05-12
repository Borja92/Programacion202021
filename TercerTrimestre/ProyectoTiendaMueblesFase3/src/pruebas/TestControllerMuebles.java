import modelo.Elemento;
import negocio.Muebles;
import persistencia.ElementoModeloDAO;
import persistencia.ModeloDAO;

import java.util.ArrayList;
import java.util.List;

public class TestControllerMuebles {


    negocio.Muebles muebles;


    public TestControllerMuebles()
    {
        muebles = new Muebles();
    }



    public void ejecutar(){
        System.out.println("--- BEGIN TEST Controller MUEBLES ---");
        cargarModelos();
        cargarModelo();
        cargarModelosByElemento();
        cargarModelosBySeccion();
        System.out.println("\nCargamos modelos para prueba modificar");
        cargarModelos();
        modificarModelo();
        modificarElemento();
        System.out.println("--- END TEST Controller MUEBLES");
        System.out.println("-");
    }


    public void cargarModelos() {
        System.out.println("Cargar Modelos ()");
        muebles.cargarModelos();
        System.out.println(muebles.getModelosDeInteres().toString());

    }


    public void cargarModelo()
    {
        boolean rdo;

        System.out.print("Prueba negocio.Muebles::cargarModelo(MTRES);");
        rdo =  muebles.cargarModelo("MTRES");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());

        System.out.print("Prueba negocio.Muebles::cargarModelo(UNO QUE NO EXISTE);");
        rdo =  muebles.cargarModelo("UNO QUE NO EXISTE");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());
    }

    public void cargarModelosByElemento()
    {
        System.out.println("-- cargarModelosByElemento");
        boolean rdo;

        System.out.print("Prueba negocio.Muebles::cargarModelosByElemento('Es_4');");
        rdo =  muebles.cargarModelosByElemento("Es_4");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());

        System.out.print("Prueba negocio.Muebles::cargarModelosByElemento(UNO QUE NO EXISTE);");
        rdo =  muebles.cargarModelosByElemento("UNO QUE NO EXISTE");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());
    }




    public void cargarModelosBySeccion()
    {
        System.out.println("-- cargarModelosBySeccion");
        boolean rdo;

        System.out.print("Prueba negocio.Muebles::cargarModelosBySeccion('Sección C_MODIFICADA');");
        rdo =  muebles.cargarModelosBySeccion("Sección C_MODIFICADA");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());

        System.out.print("Prueba negocio.Muebles::cargarModelosByElemento(UNO QUE NO EXISTE);");
        rdo =  muebles.cargarModelosBySeccion("UNO QUE NO EXISTE");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());
    }

    public void modificarModelo()
    {
        System.out.println("-- modificarModelo(String codigoModelo, String nuevoCodigoModelo)");
        boolean rdo;
        System.out.print("Prueba negocio.Muebles::modificarModelo;");
        rdo =  muebles.modificarModelo("MTRES","M3");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());

        System.out.print("Prueba negocio.Muebles::modificarModelo(UNO QUE NO EXISTE);");
        rdo =  muebles.modificarModelo("UNO QUE NO EXISTE","otro");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());
    }




    public void modificarElemento()
    {
        System.out.println("-- modificarElemento(String codigo, String nuevoCodigo)");
        boolean rdo;
        System.out.print("Prueba negocio.Muebles::modificarElemento;");
        rdo =  muebles.modificarElemento("Es_4","ES0T153");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());

        System.out.print("Prueba negocio.Muebles::modificarElemento(UNO QUE NO EXISTE);");
        rdo =  muebles.modificarElemento("UNO QUE NO EXISTE","otro");
        System.out.println((rdo) ? " Éxito": " Fallo");
        if (rdo)  System.out.println(muebles.getModelosDeInteres().toString());
    }




}
