package negocio;

import Persistencia.*;
import modelo.Elemento;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Muebles
 */
public class Muebles {
    /**
     * Atributos
     */
    private negocio.Categoria categoria;
    private negocio.Seccion seccion;
    private negocio.TipoElementos tipoElementos;
    private negocio.Modelo codigoModelos;
    private List<modelo.Modelo> modelosDeInteres;

    private ModeloDAO modeloDAO;
    private ElementoModeloDAO elementoModeloDAO;
    private ElementoDAO elementoDAO;

    private Connection conn;
    private DBConn dbConn;

    /**
     * Constructor
     */
    public Muebles() {
        this.conn = new DBConn().conectar();
        this.categoria = new Categoria();
        this.seccion = new Seccion();
        this.tipoElementos = new TipoElementos();
        this.codigoModelos = new Modelo();
        this.modeloDAO = new ModeloDAO(conn);

        this.elementoModeloDAO = new ElementoModeloDAO(conn);
        this.elementoDAO = new ElementoDAO(conn);
    }

    /**
     * getModelosDeInteres
     *
     * @return list
     */
    public List<modelo.Modelo> getModelosDeInteres() {

        return modelosDeInteres;
    }

    /**
     * refresh
     */
    public void refresh() {
        //this.modelosDeInteres = getlistModelosActuales();
        this.modelosDeInteres = new ArrayList<>();
        this.codigoModelos.refresh();

    }
/*
    *//**
     * getListaModelosActuales
     *
     * @return List<modelo.Modelo>
     */
    private List<modelo.Modelo> getlistModelosActuales() {
        List<modelo.Modelo> listaModelosActuales = new ArrayList<>();
        for (String cdModelo : codigoModelos.getCodigosModelos()) {
            listaModelosActuales.add(getModelo(cdModelo));
        }
        return listaModelosActuales;
    }

    /**
     * cargarModelos
     *
     * @return boolean
     */
    public boolean cargarModelos() {
        refresh();
        boolean rsult=false;
            for (String cdModelo : codigoModelos.getCodigosModelos()) {
                getModelosDeInteres().add(getModelo(cdModelo));
                getModelo(cdModelo).addElemento(getElemento(cdModelo));
                System.out.println(getElemento(cdModelo));
                rsult=true;
            }
        return rsult;
    }


    /**
     * getModelo
     *
     * @param codigoModelo
     * @return modelo.Modelo
     */
    private modelo.Modelo getModelo(String codigoModelo) {
        return modeloDAO.leer(codigoModelo);
    }

    /**
     * cargarModelo
     *
     * @param codigoModelo
     * @return boolean
     */
    public boolean cargarModelo(String codigoModelo) {
        if (this.codigoModelos.getCodigosModelos().contains(codigoModelo)){
            getModelosDeInteres().add(getModelo(codigoModelo));
            getModelo(codigoModelo).setElementos(getModelo(codigoModelo).getElementos());
            System.out.println(getModelo(codigoModelo).getElementos());
            return true;
        }
        return false;
    }

    /**
     * cargarModelosByElemento
     *
     * @param codigoElemento
     * @return boolean
     */
    public boolean cargarModelosByElemento(String codigoElemento) {
        refresh();

        for (String cdModelo : modeloDAO.getCodigosModelos()) {
            if (elementoModeloDAO.getElementosByCodigoModelo(cdModelo).contains(getElemento(cdModelo))) {
                getModelosDeInteres().clear();
                modelosDeInteres.add(getModelo(cdModelo));
                getModelo(cdModelo).addElemento(getElemento(cdModelo));

                return true;
            }
        }
        return false;
    }


    /**
     * cargarModelosBySeccion
     *
     * @param seccion
     * @return boolean
     */
    public boolean cargarModelosBySeccion(String seccion) {

        if (this.seccion.seccionExists(seccion)) {
            for (String cdModelo : modeloDAO.getCodigosModelosBySeccion(seccion)) {
                refresh();
                getModelosDeInteres().clear();
                getModelosDeInteres().add(getModelo(cdModelo));
                getModelo(cdModelo).addElemento(getElemento(cdModelo));
            }
            return true;
        }

        return false;
    }

    /**
     * modificarModelos
     *
     * @param codigoModelo
     * @param nuevoCodigoModelo
     * @return boolean
     */
    public boolean modificarModelo(String codigoModelo, String nuevoCodigoModelo) {

        for (modelo.Modelo modelo:getModelosDeInteres()) {
            if (modelo.getCodigo().equals(codigoModelo)){
                if (modeloDAO.actualizar(codigoModelo,nuevoCodigoModelo)){
                    refresh();
                    cargarModelos();
                    return true;}
            }
        }
        return false;
    }

    /**
     * getElemento
     *
     * @param codModelo
     * @return Elemento
     */
    private Elemento getElemento(String codModelo) {
        Elemento elemento = new Elemento("", "");
        for (Elemento e : elementoModeloDAO.getElementosByCodigoModelo(codModelo)) {
            elemento = e;
            return elementoDAO.leer(elemento.getCodigo());
        }
        return elemento;

    }

    /**
     * modificarElementos
     *
     * @param codigo
     * @param nuevoCodigo
     * @return boolean
     */
    public boolean modificarElemento(String codigo, String nuevoCodigo) {
        if (elementoDAO.actualizar(codigo, nuevoCodigo)) {
            refresh();
            cargarModelos();
            return true;
        }
        return false;
    }


}
