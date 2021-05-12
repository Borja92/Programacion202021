package test;

import negocio.TipoElementos;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TipoElementosTest {


    private static TipoElementos tipoElementos;
    static List<String> listaEsperada;

    @BeforeAll
    static void init() {
        listaEsperada = Arrays.asList("TIPO1","TIPO2","TIPO3");
        TestInit.truncateTable("tipo_elemento");
        tipoElementos = new TipoElementos();
        for (String tipo:listaEsperada) {
            tipoElementos.crearTipoElemento(tipo);
        }
    }

    @Test
    @Order(1)
    void getTiposElementos() {
        assertTrue(tipoElementos.getTiposElementos().size()==listaEsperada.size() && tipoElementos.getTiposElementos().containsAll(listaEsperada));
    }


    @Test
    @Order(2)
    void tipoElementoExists() {
        for (String tipo:listaEsperada) {
            assertTrue(tipoElementos.tipoElementoExists(tipo));
        }
        assertFalse(tipoElementos.tipoElementoExists("Uno que no Existe"));

    }


    @Test
    @Order(3)
    void modificarTipoElemento() {
        tipoElementos.modificarTipoElemento("TIPO1","TUNO");
        assertTrue(tipoElementos.tipoElementoExists("TUNO"));
        assertFalse(tipoElementos.tipoElementoExists("TIPO1"));
    }







}