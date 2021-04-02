package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private Connection conn;
    private String DB_NAME = "Secretaria";
    //private String HOST = "jdbc:mysql://192.168.21.81:3306/";
    private String HOST = "jdbc:mysql://192.168.1.38:3306/";
    private String DB_USER = "usuario";
    //private String DB_USER = "secretario";
    //private String DB_PASS = "Perro20";
    private String DB_PASS = "123456789";

    public DBConn(){

    }

    public DBConn(Connection conn, String DB_NAME, String HOST, String DB_USER, String DB_PASS) {
        this.conn = conn;
        this.DB_NAME = DB_NAME;
        this.HOST = HOST;
        this.DB_USER = DB_USER;
        this.DB_PASS = DB_PASS;
    }

    public Connection conectar() throws SQLException {
        conn = DriverManager.getConnection(HOST + DB_NAME,DB_USER,DB_PASS);
        return conn;
    }

    public void desconectar() throws SQLException {
        if (null != conn)
            conn.close();
    }
}
