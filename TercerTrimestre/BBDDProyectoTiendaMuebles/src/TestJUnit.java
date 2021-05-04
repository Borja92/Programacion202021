import Persistencia.DBConn;

public class TestJunit {
    public static void main(String[] args) {
        TestHelper.pruebaConexion();

        TestCategoriaDAO testCategoria = new TestCategoriaDAO();
        testCategoria.ejecutar();

        TestSeccionDAO testSeccionDAO = new TestSeccionDAO();
        testSeccionDAO.ejecutar();

        TestElementoDAO testElementoDAO = new TestElementoDAO();
        testElementoDAO.ejecutar();

        TestModeloDAO testModeloDAO = new TestModeloDAO();
        testModeloDAO.ejecutar();

        TestTipoElementoDAO testTipoElemento = new TestTipoElementoDAO();
        testTipoElemento.ejecutar();

        TestElementoModeloDAO testElementoModeloDAO = new TestElementoModeloDAO();
        testElementoModeloDAO.ejecutar();

        DBConn.desconectar();
    }
}
