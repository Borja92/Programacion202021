package persistencia;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBConnTest {

    public static Connection conn = null;
    public static DBConn dbConn;

    @Test
    public void conectar() {
        dbConn = new DBConn();
        conn = dbConn.conectar();
        assertNotNull("No hay conexión",conn);
    }

    @Test
    public void desconectar(){
        dbConn.desconectar();
        try {
            assertTrue(conn.isClosed());
        } catch (SQLException throwables) {
            assertTrue("No se puedo comprobar la desconexión",false);
        }
    }
}