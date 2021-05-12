package test;

import negocio.Seccion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeccionTest {


    private Seccion seccion;
    List<String> listaEsperada = Arrays.asList("Cocina","Salon","Baño","Jardin");


    public void init()
    {
        seccion = new Seccion();
    }

    @BeforeAll
    public static void start()
    {
        TestInit.loadTestDATA();
    }

    @Test
    void getSecciones() {
        init();
        assertTrue(seccion.getSecciones().size()==listaEsperada.size() && seccion.getSecciones().containsAll(listaEsperada));
    }


    @Test
    void seccionExists() {
        init();
        assertTrue(seccion.seccionExists("Cocina"));
        assertTrue(seccion.seccionExists("Salon"));
        assertTrue(seccion.seccionExists("Jardin"));
        assertFalse(seccion.seccionExists("UNA que no eXsite"));
    }

    @Test
    void modificarSeccion() {
        init();
        seccion.modificarSeccion("Baño","Dormitorio");
        assertTrue(seccion.seccionExists("Dormitorio"));
        assertFalse(seccion.seccionExists("Baño"));
    }


    @Test
    void deleteSeccion() {
        init();
        assertTrue(seccion.seccionExists("Salon"));
        assertTrue(seccion.deleteSeccion("Salon"));
        assertFalse(seccion.seccionExists("Salon"));
    }
}
