import com.sun.jdi.connect.Connector;
import modelo.Elemento;
import negocio.Categoria;
import negocio.Modelo;
import negocio.Seccion;
import persistencia.DBConn;
import persistencia.ElementoDAO;
import persistencia.TipoElementoDAO;

import java.sql.Connection;
import java.util.HashMap;

public class TestControllerModelo {



    private negocio.Modelo modelo;
    private negocio.Seccion sec;
    private negocio.Categoria cat;


    private String[] tipoElementoTestSet = {"Silla","Mesa","Estanteria","TV Unit"};
    private HashMap<String, String[]> elementosTestSet = new HashMap<String, String[]>();

    private String[] casosNoExistentes = {"Modelo No Existente"};


    public TestControllerModelo()
    {
        modelo = new Modelo();
        sec = new Seccion();
        cat = new Categoria();
        // Inicializo Elementos  para pruebas
        for (String tipoElemento : tipoElementoTestSet) {
            String[] elementos = new String[10];
            for (int i = 0; i < 10; i++) { elementos[i]=tipoElemento.substring(0,2)+"_"+i; }
            elementosTestSet.put(tipoElemento,elementos);
        }
    }

    public void ejecutar(){
        System.out.println("--- BEGIN TEST Controller MODELO ---");
        crearModelos();
        crearElementos();
        getCodigoModelos();
        addElementosToModelo();
        System.out.println("--- END TEST Controller MODELO");
        System.out.println("-");
    }


    public void crearModelos(){
        boolean rdo;
        int i,j;
        String m;

        System.out.println(" Creando Modelos para "+sec.getSecciones().size()+" secciones y "+cat.getCategorias().size()+"Categorias");
        i=1; j=1;
        modelo.Modelo m1 = new modelo.Modelo("MUNO",sec.getSecciones().get(i),cat.getCategorias().get(i));
        rdo = modelo.crearModelo(m1);
        System.out.println((rdo) ? " Éxito": " Fallo");

        i=2; j=1;
        modelo.Modelo m2 = new modelo.Modelo("MDOS",sec.getSecciones().get(i),cat.getCategorias().get(i));
        rdo = modelo.crearModelo(m2);
        System.out.println((rdo) ? " Éxito": " Fallo");

        i=2; j=2;
        modelo.Modelo m3 = new modelo.Modelo("MTRES",sec.getSecciones().get(i),cat.getCategorias().get(i));
        rdo = modelo.crearModelo(m3);
        System.out.println((rdo) ? " Éxito": " Fallo");


    }


    public void crearElementos() {
        DBConn dbConn = new DBConn();
        Connection conn = dbConn.conectar();
        ElementoDAO elementoDAO = new ElementoDAO(conn);
        for (String tipo : tipoElementoTestSet) {
            for (String elem:elementosTestSet.get(tipo)) {
                elementoDAO.crear(new Elemento(tipo,elem));
            }
        }
    }

    public void addElementosToModelo()
    {

        boolean rdo;
        int i,j,m;

        System.out.println(modelo.getCodigosModelos().size()+" Modelos Disponibles");
        m=1;
        i=1; j=1;
        modelo.crearElemento(elementosTestSet.get(tipoElementoTestSet[i])[j], tipoElementoTestSet[i],modelo.getCodigosModelos().get(m)).toString();
        m=2; i=2; j=4;
        modelo.crearElemento(elementosTestSet.get(tipoElementoTestSet[i])[j], tipoElementoTestSet[i],modelo.getCodigosModelos().get(m)).toString();
         i=3; j=5;
        modelo.crearElemento(elementosTestSet.get(tipoElementoTestSet[i])[j], tipoElementoTestSet[i],modelo.getCodigosModelos().get(m)).toString();

    }




    public void getCodigoModelos(){

        boolean rdo;

        System.out.println("Prueba negocio.Modelos::getCodigosModelos();");

        // Casos en los que se espera Éxito
        for (String mod : modelo.getCodigosModelos()) {
            System.out.println(mod);
        }

    }





}
