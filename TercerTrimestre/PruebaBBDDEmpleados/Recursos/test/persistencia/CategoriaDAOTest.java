package persistencia;

import org.junit.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CategoriaDAOTest {

    private static DBConn dbConn;
    private static Connection conn;
    private static CategoriaDAO categoriaDAO;

    @BeforeClass
    public static void inicializar(){
        dbConn = new DBConn();
        conn = dbConn.conectar();
        TestHelper.borrarBD(conn);
        categoriaDAO = new CategoriaDAO(conn);

    }

    @AfterClass
    public static void terminar(){
        dbConn.desconectar();
    }

    @After
    public void tearDown(){
        TestHelper.borrarBD(conn);
    }

    @Test
    public void crear() {
        assertTrue("Devuelve false al crear una categoría",categoriaDAO.crear("Gama económica"));
        assertFalse("Se pudo crear dos veces una misma categoría",categoriaDAO.crear("Gama económica"));
        assertEquals("El número de categorías creadas no es correcto",1,contarTuplas("Gama económica"));
    }

    @Test
    public void getId() {
        if (crearCategoria("Gama económica")){
            assertTrue("No se obtubo el id de la categoría insertada",categoriaDAO.getId("Gama económica") > -1);
            assertTrue("Una categoría inexistente obtuvo id",categoriaDAO.getId("Inexistente"+(Math.random()*1000)) == -1);
        }
    }


    @Test
    public void getCategoriaById() {
        if (crearCategoria("Gama económica")){
            int id = categoriaDAO.getId("Gama económica");
            assertTrue((id > -1) && (categoriaDAO.getCategoriaById(id).equals("Gama económica")));
            assertNull(categoriaDAO.getCategoriaById(Integer.MAX_VALUE));
        }
    }

    @Test
    public void actualizar() {
        if (crearCategoria("Gama económica")){
            assertTrue(categoriaDAO.actualizar("Gama económica","gama económica"));
            assertFalse(categoriaDAO.actualizar("Inexistente"+(Math.random()*1000),"modificado"));
        }
    }

    @Test
    public void exists() {
        if (crearCategoria("Gama económica")) {
            assertTrue(categoriaDAO.exists("gama económica"));
            assertFalse(categoriaDAO.exists("inexistente"));
        }
    }

    @Test
    public void borrar() {
        if (crearCategoria("Gama económica")) {
            assertTrue("Borrado de una categoría existente",categoriaDAO.borrar("Gama económica"));
            assertEquals("Una categoría borrada ya no existe en la base de datos",0,contarTuplas("Gama económica"));
            assertFalse("No se puede borrar una categoría inexistente",categoriaDAO.borrar("inexistente" + (Math.random() * 10000)));
        }
    }


    @Test
    public void getAll() {
        if (crearCategoria("Gama económica") && crearCategoria("Gama media")) {
            List<String> categorias = categoriaDAO.getAll();
            assertEquals(2, categorias.size());
            assertTrue(categorias.contains("Gama económica") && categorias.contains("Gama media"));
        }
    }

    private boolean crearCategoria(String nombre){
        try {
            conn.prepareStatement("INSERT INTO categoria(nombre) VALUES ('" + nombre + "')").executeUpdate();
            return true;
        } catch (Exception e){
            fail("Problema al insertar una categoría mediante una sentencia SQL");
            return false;
        }
    }

    private int contarTuplas(String nombre){
        try {
            ResultSet result = conn.prepareStatement("SELECT COUNT(nombre) FROM categoria WHERE nombre = '"+nombre+"'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}