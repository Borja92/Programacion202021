package test;

import negocio.Modelo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModeloTest {



    private negocio.Modelo modelo;
    List<String> listaEsperada = Arrays.asList("MUNO","MDOS");

    public void init()
    {
        modelo = new Modelo();

    }

    @BeforeAll
    public static void start()
    {
       TestInit.loadTestDATA();
    }

    @Test
    void getCodigosModelos() {
        init();
        assertTrue(modelo.getCodigosModelos().size()==listaEsperada.size() && modelo.getCodigosModelos().containsAll(listaEsperada));
    }

    @Test
    void refresh() {
        init();
        assertTrue(modelo.getCodigosModelos().size()==listaEsperada.size() && modelo.getCodigosModelos().containsAll(listaEsperada));
    }


    @Test
    void crearElemento() {
        init();
        assertNotNull(modelo.crearElemento("SOF26","Silla","MUNO"));
        assertNull(modelo.crearElemento("M03","NOTEXIST","MUNO"));
        assertNull(modelo.crearElemento("M03","Mesa","NOTESIST"));
    }



}