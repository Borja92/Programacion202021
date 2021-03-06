package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private final static String DB_NAME = "Mobant";
    private final static String USER = "mobant";
    private final static String PASSWORD = "Perro20";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false";
    private static Connection conn = null;

    public  Connection conectar() {
        if (conn == null){
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return null;
            }
        } else return conn;
    }

    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conn = null;
    }
}