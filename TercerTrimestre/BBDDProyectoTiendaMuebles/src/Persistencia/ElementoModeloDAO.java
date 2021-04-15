package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ElementoModeloDAO {
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;
    private DBConn dbConn;
    public ElementoModeloDAO(){
        dbConn= new DBConn();
        elementoDAO= new ElementoDAO();
        modeloDAO= new ModeloDAO();
    }
/*
    public boolean crear(String codigoElemento, String codigoModelo)
    public int getId(String codigoElemento, String codigoModelo)
    public boolean actualizarModelo(String codigoElemento, String
            codigoModelo, String codigoNuevoModelo)
    public List<Elemento> getElementosByCodigoModelo(String
                                                             codigoModelo)
    public boolean borrar(String codigoElemento, String codigoModelo)
*/


    public boolean crear(String codigoElemento, String codigoModelo) throws SQLException {

        conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT IGNORE  INTO elemento_modelo( id_elemento, id_modelo) VALUES ('" + codigoElemento + "')");
        int numFilas = statement.executeUpdate();
        dbConn.desconectar();
        if (numFilas > 0) {
            return true;
        } else return false;

    }




}
