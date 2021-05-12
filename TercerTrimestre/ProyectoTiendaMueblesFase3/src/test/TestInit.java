package test;

import negocio.Categoria;
import negocio.Modelo;
import negocio.Seccion;
import negocio.TipoElementos;
import persistencia.DBConn;
import persistencia.ElementoDAO;
import persistencia.ElementoModeloDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TestInit {

    public static void truncateTable(String tabla) {
        try {
            DBConn dbConn = new DBConn();
            Connection conn = dbConn.conectar();
            conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;").executeUpdate();
            conn.prepareStatement("truncate "+tabla).executeUpdate();
            conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1;").executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void loadTestDATA()
    {
        TestInit.truncateTable("modelo");
        TestInit.truncateTable("seccion");
        TestInit.truncateTable("categoria");
        TestInit.truncateTable("tipo_elemento");
        TestInit.truncateTable("elemento");
        TestInit.truncateTable("elemento_modelo");

        Categoria categoria = new Categoria();
        categoria.crearCategoria("Economy");
        categoria.crearCategoria("Standard");
        categoria.crearCategoria("Luxury");

        Seccion seccion = new Seccion();
        seccion.crearSeccion("Cocina");
        seccion.crearSeccion("Salon");
        seccion.crearSeccion("Baño");
        seccion.crearSeccion("Jardin");

        TipoElementos tipoElementos = new TipoElementos();
        tipoElementos.crearTipoElemento("Silla");
        tipoElementos.crearTipoElemento("Mesa");
        tipoElementos.crearTipoElemento("Sofa");

        Modelo modelo = new Modelo();
        modelo.Modelo m1 = new modelo.Modelo("MUNO","Cocina","Economy");
        modelo.crearModelo(m1);
        modelo.Modelo m2 = new modelo.Modelo("MDOS","Cocina","Luxury");
        modelo.crearModelo(m2);

        DBConn dbConn = new DBConn();
        Connection conn = dbConn.conectar();
        ElementoDAO elemento = new ElementoDAO(conn);
        elemento.crear(  new modelo.Elemento("Silla","SLL12") );
        elemento.crear(  new modelo.Elemento("Silla","SLLZ2") );
        elemento.crear(  new modelo.Elemento("Mesa","MSAH2") );
        elemento.crear(  new modelo.Elemento("Sofa","SOF26") );

        ElementoModeloDAO elementoModeloDAO = new ElementoModeloDAO(conn);
        elementoModeloDAO.crear("SLL12","MUNO");
        elementoModeloDAO.crear("MSAH2","MUNO");
        elementoModeloDAO.crear("SLLZ2","MDOS");
        elementoModeloDAO.crear("MSAH2","MDOS");
        elementoModeloDAO.crear("SOF26","MDOS");


    }

}
