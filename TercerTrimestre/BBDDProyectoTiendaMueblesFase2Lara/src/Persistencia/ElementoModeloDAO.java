package Persistencia;

import modelo.Elemento;
import modelo.Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ElementoModeloDAO {
    private Connection conn;
    private ElementoDAO elementoDAO;
    private ModeloDAO modeloDAO;

    public ElementoModeloDAO(Connection conn){
        this.conn = conn;
        elementoDAO = new ElementoDAO(conn);
        modeloDAO = new ModeloDAO(conn);
    }

    public boolean crear(String codigoElemento, String codigoModelo){
        try {
            int idElemento = elementoDAO.getId(codigoElemento);
            int idModelo = modeloDAO.getId(codigoModelo);
            if ((idElemento > -1) && (idModelo > -1)) {
                ResultSet result = conn.prepareStatement("SELECT id FROM elemento_modelo WHERE id_modelo = " + idModelo + " AND id_elemento = " + idElemento).executeQuery();
                if (result.next())
                    return false;
                else
                    return (conn.prepareStatement("INSERT INTO elemento_modelo(id_elemento,id_modelo) VALUES ('" + idElemento + "','" + idModelo + "')").executeUpdate() == 1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int getId(String codigoElemento, String codigoModelo){
        try {
            int idElemento = elementoDAO.getId(codigoElemento);
            int idModelo = modeloDAO.getId(codigoModelo);
            ResultSet result = conn.prepareStatement("SELECT id FROM elemento_modelo WHERE id_elemento = '" + idElemento + "' and id_modelo = '" + idModelo + "'").executeQuery();
            if (result.next())
                return result.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public boolean actualizarModelo(String codigoElemento, String codigoModelo, String codigoNuevoModelo){
        try {
            Modelo modelo = modeloDAO.leer(codigoModelo);
            int idNuevoModelo = modeloDAO.getId(codigoNuevoModelo);
            int id = getId(codigoElemento,codigoModelo);
            return (conn.prepareStatement("UPDATE elemento_modelo SET id_modelo = '"+idNuevoModelo+"' WHERE id = '"+id+"'").executeUpdate() == 1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<Elemento> getElementosByCodigoModelo(String codigoModelo){
        List<Elemento> codigosElementos = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT elemento.id FROM elemento_modelo JOIN elemento ON elemento_modelo.id_elemento = elemento.id where id_modelo in (select id from modelo where codigo='"+codigoModelo+"')").executeQuery();
            codigosElementos = new ArrayList<>();
            while (result.next()) {
                ElementoDAO elementoDAO = new ElementoDAO(conn);
                codigosElementos.add(elementoDAO.getElementoById(result.getInt(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return codigosElementos;
    }

    public boolean borrar(String codigoElemento, String codigoModelo){
        try{
            int id = getId(codigoElemento,codigoModelo);
            if (id > -1) {
                return (conn.prepareStatement("DELETE FROM elemento_modelo WHERE id = '"+id+"'").executeUpdate() == 1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}


