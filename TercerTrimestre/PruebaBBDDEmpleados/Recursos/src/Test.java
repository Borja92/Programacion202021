import persistencia.DBConn;

import java.sql.Connection;

public class Test {
    private static DBConn dbConn;

    public static void main(String[] args) {
        TestHelper.pruebaConexion();

        dbConn = new DBConn();
        Connection conn = dbConn.conectar();

        TestCategoriaDAO testCategoria = new TestCategoriaDAO(conn);
        testCategoria.ejecutar();

        TestSeccionDAO testSeccionDAO = new TestSeccionDAO(conn);
        testSeccionDAO.ejecutar();

        TestElementoDAO testElementoDAO = new TestElementoDAO(conn);
        testElementoDAO.ejecutar();

        TestModeloDAO testModeloDAO = new TestModeloDAO(conn);
        testModeloDAO.ejecutar();

        TestTipoElementoDAO testTipoElemento = new TestTipoElementoDAO(conn);
        testTipoElemento.ejecutar();

        TestElementoModeloDAO testElementoModeloDAO = new TestElementoModeloDAO(conn);
        testElementoModeloDAO.ejecutar();

        dbConn.desconectar();
    }
}
