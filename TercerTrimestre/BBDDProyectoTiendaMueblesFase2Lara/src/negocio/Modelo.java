package negocio;

import Persistencia.ElementoDAO;
import Persistencia.ModeloDAO;
import Persistencia.DBConn;
import Persistencia.TipoElementoDAO;
import modelo.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Modelo
 */
public class Modelo {
    /**
     * Atributos
     */
    private List<String> codigosModelos;
    private Connection conn;
    private ModeloDAO modeloDAO;
    private ElementoDAO elementoDAO;
    private TipoElementoDAO tipoElementoDAO;


    /**
     * Constructor
     */
    public Modelo() {
        this.conn = new DBConn().conectar();
        this.modeloDAO = new ModeloDAO(conn);
        this.elementoDAO= new ElementoDAO(conn);
        this.tipoElementoDAO=new TipoElementoDAO(conn);
        this.codigosModelos = new ArrayList<>();

    }


    /**
     * getCodigosModelos
     *
     * @return List
     */
    public List<String> getCodigosModelos() {
        return codigosModelos;
    }

    /**
     * refresh
     */
    public void refresh() {
            this.codigosModelos=modeloDAO.getCodigosModelos();

    }

    /**
     * crearModelo
     *
     * @param modelo
     * @return boolean
     */
    public boolean crearModelo(modelo.Modelo modelo) {

            if (modeloDAO.crear(modelo)) {
                codigosModelos.add(modelo.getCodigo());
                refresh();
                return true;
            }
        return false;
    }

    /**
     * crearElemento
     *
     * @param codigo
     * @param tipoElemento
     * @param codigoModelo
     * @return Elemento / null
     */
    public Elemento crearElemento(String codigo, String tipoElemento, String codigoModelo) {
            refresh();
        if (!tipoElementoDAO.exists(tipoElemento) || !getCodigosModelos().contains(codigoModelo)) {
            return null;
        } else if (elementoDAO.crear(new Elemento(tipoElemento,codigo))) {
                refresh();
            }

        return elementoDAO.getElementoById(elementoDAO.getId(codigo));
    }

}
