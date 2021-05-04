package persistencia;

import modelo.Elemento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementoDAO {
    private TipoElementoDAO tipoElementoDAO;
    private Connection conn;

    public ElementoDAO(Connection conn){
        tipoElementoDAO = new TipoElementoDAO(conn);
        this.conn = conn;
    }

    public boolean crear(Elemento elemento){
        try {
            int idTipo = tipoElementoDAO.getId(elemento.getTipo());
            if (idTipo > -1)
                return conn.prepareStatement("INSERT INTO elemento(codigo,id_tipo_elemento) VALUES ('"+elemento.getCodigo()+"','"+idTipo+"')").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Elemento leer(String codigo){
        try {
            String query = "SELECT tipo_elemento.nombre FROM elemento " +
                           "INNER JOIN tipo_elemento ON elemento.id_tipo_elemento = tipo_elemento.id " +
                           "WHERE elemento.codigo = '"+codigo+"'";
            ResultSet result = conn.prepareStatement(query).executeQuery();
            if (result.next())
                return new Elemento(result.getString(1),codigo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getId(String codigo){
        try{
            ResultSet result =  conn.prepareStatement("SELECT id FROM elemento WHERE codigo = '"+codigo+"'").executeQuery();
            if (result.next()){
                return result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public Elemento getElementoById(int id){
        try{
            ResultSet result = conn.prepareStatement("SELECT codigo FROM elemento WHERE id = '"+id+"'").executeQuery();
            if (result.next())
                return leer(result.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public boolean actualizar(String codigo, String nuevoCodigo){
        try {
            return conn.prepareStatement("UPDATE elemento SET codigo = '"+nuevoCodigo+"' WHERE codigo = '"+codigo+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean borrar(String codigo){
        try {
            return conn.prepareStatement("DELETE FROM elemento WHERE codigo = '"+codigo+"'").executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
