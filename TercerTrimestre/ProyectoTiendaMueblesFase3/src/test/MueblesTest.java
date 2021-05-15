package test;

import modelo.Modelo;
import negocio.Muebles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MueblesTest {



    private negocio.Muebles muebles;

    public void init()
    {
        muebles = new Muebles();
    }

    @BeforeAll
    public static void start()
    {
        test.TestInit.loadTestDATA();
    }


    @Test
    void refresh() {
    }

    @Test
    void cargarModelos() {
        init();

        muebles.cargarModelos();

        List<modelo.Modelo> listaEsperada = new ArrayList<Modelo>();
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        listaEsperada.add(m1);

        assertFalse(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

        Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOF26"));
        listaEsperada.add(m2);

        assertTrue(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));


    }

    @Test
    void cargarModelo() {
        init();

        muebles.cargarModelo("MDOS");
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));

        assertFalse(muebles.getModelosDeInteres().contains(m1));

        Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOF26"));

        muebles.cargarModelo("MUNO");

        assertTrue(muebles.getModelosDeInteres().contains(m1));
        assertTrue(muebles.getModelosDeInteres().contains(m2));



    }

    @Test
    void cargarModelosByElemento() {
        init();

        muebles.cargarModelosByElemento("MSAH2");

        List<modelo.Modelo> listaEsperada = new ArrayList<Modelo>();
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        listaEsperada.add(m1);

        assertFalse(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

        Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOF26"));
        listaEsperada.add(m2);

        assertTrue(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));
    }

    @Test
    void cargarModelosBySeccion() {
        init();

        muebles.cargarModelosBySeccion("Cocina");

        List<modelo.Modelo> listaEsperada = new ArrayList<Modelo>();
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        listaEsperada.add(m1);

        assertFalse(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

        Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOF26"));
        listaEsperada.add(m2);

        assertTrue(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

    }

    @Test
    void modificarModelo() {
        init();
        muebles.cargarModelos();
        assertFalse(muebles.modificarModelo("MTRES","M3"));
        assertTrue(muebles.modificarModelo("MDOS","M2"));

        List<modelo.Modelo> listaEsperada = new ArrayList<Modelo>();
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        Modelo m2 = new modelo.Modelo("M2","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOF26"));
        listaEsperada.add(m1);
        listaEsperada.add(m2);
        assertTrue(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

        //Para que las siguientes pruebas sigan funcionando, vuelvo a dejar el código de modelo inicial
        assertTrue(muebles.modificarModelo("M2","MDOS"));
    }

    @Test
    void modificarElemento() {
        init();
        muebles.cargarModelos();
        assertFalse(muebles.modificarElemento("SOFXX","SOFAOK"));
        assertTrue(muebles.modificarElemento("SOF26","SOFNEW"));

        List<modelo.Modelo> listaEsperada = new ArrayList<Modelo>();
        Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        m1.addElemento(new modelo.Elemento("Silla","SLL12"));
        m1.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        m2.addElemento(new modelo.Elemento("Silla","SLLZ2"));
        m2.addElemento(new modelo.Elemento("Mesa","MSAH2"));
        m2.addElemento(new modelo.Elemento("Sofa","SOFNEW"));
        listaEsperada.add(m1);
        listaEsperada.add(m2);
        assertTrue(muebles.getModelosDeInteres().size()==listaEsperada.size() && muebles.getModelosDeInteres().containsAll(listaEsperada));

        //Para que las siguientes pruebas sigan funcionando, vuelvo a dejar el código de Elemento inicial
        //assertTrue(muebles.modificarElemento("SOFNEW","SOF26"));
    }
}