package pruebas;

import persistencia.DBConn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestController {


    public static void borrarBD() {
        try {
            DBConn dbConn = new DBConn();
            Connection conn = dbConn.conectar();
            conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;").executeUpdate();
            conn.prepareStatement("truncate elemento_modelo").executeUpdate();
            conn.prepareStatement("truncate modelo").executeUpdate();
            conn.prepareStatement("truncate elemento").executeUpdate();
            conn.prepareStatement("truncate categoria").executeUpdate();
            conn.prepareStatement("truncate tipo_elemento").executeUpdate();
            conn.prepareStatement("truncate seccion").executeUpdate();
            conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1;").executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {

        borrarBD();

        TestControllerCategoria tCategoria = new TestControllerCategoria();
        tCategoria.ejecutar();

        TestControllerTipoElementos tTipoElementos = new TestControllerTipoElementos();
        tTipoElementos.ejecutar();

        TestControllerSeccion tSeccion = new TestControllerSeccion();
        tSeccion.ejecutar();

        TestControllerModelo tModElem = new TestControllerModelo();
        tModElem.ejecutar();


        TestControllerMuebles tMuebles = new TestControllerMuebles();
        tMuebles.ejecutar();

    }
}
