package controlador;

import negocio.*;
import persistencia.*;

import java.sql.Connection;
import java.sql.SQLException;

public class AppMobant {
    public static void main(String[] args) {
DBConn dbConn= new DBConn();
      /*  try {
            dbConn.conectar().prepareStatement("DELETE FROM elemento_modelo").executeUpdate();
            dbConn.conectar().prepareStatement("DELETE FROM modelo").executeUpdate();
            dbConn.conectar().prepareStatement("DELETE FROM elemento").executeUpdate();
            dbConn.conectar().prepareStatement("DELETE FROM categoria").executeUpdate();
            dbConn.conectar().prepareStatement("DELETE FROM tipo_elemento").executeUpdate();
            dbConn.conectar().prepareStatement("DELETE FROM seccion").executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        //negocio.Modelo modelo = new negocio.Modelo();
        //GestorXML gestorXML = new GestorXML("import.xml");
//FillToXML fillToXML = new FillToXML("import.xml");
BBDDToXML bbddToXML= new BBDDToXML(dbConn);

    }
}
