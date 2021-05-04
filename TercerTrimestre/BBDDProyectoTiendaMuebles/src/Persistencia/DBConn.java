package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase DBConn
 * Gestiona la conexión de la bbdd
 */
public class DBConn {
    /**
     * Elementos y variables de la clase
     */
    private static Connection conn;
    private static String DB_NAME = "mobant";
    //private String HOST = "jdbc:mysql://192.168.21.81:3306/";
    private static String HOST = "jdbc:mysql://192.168.1.109:3306/";
    private static String DB_USER = "usuario";
    //private String DB_USER = "secretario";
    //private String DB_PASS = "Perro20";
    private static String DB_PASS = "123456789";

    /**
     * Constructor vacío
     */
    public DBConn() {

    }

    /**
     * Constructor predeterminado de la clase DBConn
     *
     * @param conn
     * @param DB_NAME
     * @param HOST
     * @param DB_USER
     * @param DB_PASS
     */
    public DBConn(Connection conn, String DB_NAME, String HOST, String DB_USER, String DB_PASS) {
        this.conn = conn;
        this.DB_NAME = DB_NAME;
        this.HOST = HOST;
        this.DB_USER = DB_USER;
        this.DB_PASS = DB_PASS;
    }

    /**
     * Método conectar
     *
     * @return conn
     * @throws SQLException
     */
    public static Connection conectar() {
        try {
            conn = DriverManager.getConnection(HOST + DB_NAME, DB_USER, DB_PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * Método desconectar
     *
     * @throws SQLException
     */
    public static void desconectar()  {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
