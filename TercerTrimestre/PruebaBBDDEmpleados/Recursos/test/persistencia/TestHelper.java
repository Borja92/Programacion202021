package persistencia;

import java.sql.Connection;
import java.sql.SQLException;

public class TestHelper {
    public static void borrarBD(Connection conn) {
        try {
            conn.prepareStatement("DELETE FROM elemento_modelo").executeUpdate();
            conn.prepareStatement("DELETE FROM modelo").executeUpdate();
            conn.prepareStatement("DELETE FROM elemento").executeUpdate();
            conn.prepareStatement("DELETE FROM categoria").executeUpdate();
            conn.prepareStatement("DELETE FROM tipo_elemento").executeUpdate();
            conn.prepareStatement("DELETE FROM seccion").executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
