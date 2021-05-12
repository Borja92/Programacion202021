package negocio;

import persistencia.*;

import java.sql.Connection;
import java.util.List;

public class Modelo {

    //Contiene todos los códigos de los modelos. Al iniciar el programa, se cargan todos los códigos
    List<String> codigosModelos;

    private ModeloDAO modeloDAO;
    Connection conn;

    public List<String> getCodigosModelos() {
        return codigosModelos;
    }

    public Modelo()
    {
        DBConn dbConn = new DBConn();
        conn = dbConn.conectar();
        modeloDAO = new ModeloDAO(conn);
        codigosModelos = modeloDAO.getCodigosModelos();
    }

    public void  refresh()
    {
        codigosModelos = modeloDAO.getCodigosModelos();
    }

    //    Inserta un nuevo modelo. Si el modelo es creado en la base de datos,
    //    se añade en la lista codigosModelos y se devuelve true. En cualquier otro caso, se devuelve false.
    public boolean crearModelo(modelo.Modelo modelo)
    {
        boolean sucsessful;
        sucsessful = modeloDAO.crear(modelo);
        if (sucsessful) refresh();
        return sucsessful;
    }

    /* Inserta un nuevo elemento. Si la inserción es exitosa, devuelve el elemento. Si el tipo de elemento tipoElemento no existe,
     o el código de modelo codigoModelo no existe, devuelve null.
   */
    public modelo.Elemento crearElemento(String codigo, String tipoElemento, String codigoModelo)
    {
        TipoElementoDAO tipoElementoDAO = new TipoElementoDAO(conn);
        if (!(tipoElementoDAO.exists(tipoElemento) && modeloDAO.getId(codigoModelo)>0) ) return null;
        modelo.Elemento e = new modelo.Elemento(tipoElemento,codigoModelo);
        ElementoModeloDAO elementoModeloDAO = new ElementoModeloDAO(conn);
        if (elementoModeloDAO.crear(codigo,codigoModelo)) return e;
        else return null;
    }


}
