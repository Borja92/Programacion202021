package test;

import negocio.Categoria;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {



    private negocio.Categoria categoria;
    List<String> listaEsperada = Arrays.asList("Economy","Standard","Luxury");

    public void init()
    {
        categoria = new Categoria();
    }

    @BeforeAll
    public static void start()
    {
        TestInit.loadTestDATA();
    }

    @Test
    void getCategorias() {
        init();
        assertTrue(categoria.getCategorias().size()==listaEsperada.size() && categoria.getCategorias().containsAll(listaEsperada));
    }

    @Test
    void categoriaExists() {
        init();
        assertTrue(categoria.categoriaExists("Standard"));
        assertTrue(categoria.categoriaExists("Luxury"));
        assertTrue(categoria.categoriaExists("Economy"));
        assertFalse(categoria.categoriaExists("UNA que no eXsite"));

    }

    @Test
    void modificarCategoria() {
        init();
        categoria.modificarCategoria("Economy","Access");
        assertTrue(categoria.categoriaExists("Access"));
        assertFalse(categoria.categoriaExists("Economy"));
    }


}