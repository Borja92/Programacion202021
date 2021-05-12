package negocio;

import modelo.Elemento;
import persistencia.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Muebles {


    private List<modelo.Modelo> modelosDeInteres;
    //Contiene una lista de modelos existentes en la base de datos.
    // Cada objeto Modelo de la lista incluye todos los objetos Elemento que le corresponden.
    // Inicialmente este atributo es null. Es instanciado por diferentes métodos definidos más adelante.

    private negocio.Categoria categoria;
    private negocio.Seccion seccion;
    private negocio.TipoElementos tipoElementos;
    private negocio.Modelo codigoModelos;
    Connection conn;

    public Muebles() {
        DBConn dbConn = new DBConn();
        conn = dbConn.conectar();
        categoria = new Categoria();
        seccion = new Seccion();
        tipoElementos = new TipoElementos();
        codigoModelos = new Modelo();

        modelosDeInteres = new ArrayList<modelo.Modelo>();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public TipoElementos getTipoElementos() {
        return tipoElementos;
    }

    public Modelo getCodigoModelos() {
        return codigoModelos;
    }

    public List<modelo.Modelo> getModelosDeInteres() {
        return modelosDeInteres;
    }

    private void truncateModelosDeInteres()
    {
        getModelosDeInteres().clear();
    }


    private boolean inModelosdeInteres(String codigoModelo){
        for (modelo.Modelo m :getModelosDeInteres()){
            if (m.getCodigo().equals(codigoModelo)) return true;
        }
        return false;
    }


    //  Actualiza la lista modelosDeInteres, cargando de nuevo la información de los modelos
    //existentes actualmente en dicha lista..
    public void refresh()
    {
        ArrayList<String> listaInteres = new ArrayList<>();
        Iterator<modelo.Modelo> iter = modelosDeInteres.iterator();
        while (iter.hasNext())
        {
            listaInteres.add(iter.next().getCodigo());
        }
        modelosDeInteres=null;
        for (String codigo:listaInteres) {
            cargarModelo(codigo);
        }


    }







    /* Inserta todos los modelos existentes en la lista modelosDeInteres.
    Los elementos que pertenecen a este modelo son cargados en su lista interna.
    Si la consulta es exitosa, aunque sea vacía, devuelve true. En otro caso false y la lista modelosDeInteres no es modificada.
     */
    public boolean cargarModelos() {
        truncateModelosDeInteres();
        ModeloDAO modeloDAO = new ModeloDAO(conn);
        for (String modelo : getCodigoModelos().getCodigosModelos()) {
            modelo.Modelo m = modeloDAO.leer(modelo);
            m.setElementos(getElementosModelo(modelo));
            getModelosDeInteres().add(m);
        }
        return true;
    }

    private List<Elemento> getElementosModelo(String codigoModelo)
    {
        ElementoModeloDAO e = new ElementoModeloDAO(conn);
        return e.getElementosByCodigoModelo(codigoModelo);
    }

    /*
    Inserta el modelo que tiene el código codigoModelo en la lista modelosDeInteres. Los elementos que pertenecen a este modelo son cargados en su lista interna.
    Si la consulta es exitosa, aunque sea vacía, devuelve true, en otro caso false y la lista modelosDeInteres no es modificada
    */
    public boolean cargarModelo(String codigoModelo)
    {
        ModeloDAO modeloDAO = new ModeloDAO(conn);
        modelo.Modelo m = modeloDAO.leer(codigoModelo);
        if (m!=null) {
            m.setElementos(getElementosModelo(codigoModelo));
            getModelosDeInteres().add(m);
            return true;
        }
        return false;
    }

    /*
        Carga en el atributo modelosDeInteres los modelos que contienen un elemento con código codigoElemento.
    Los elementos que pertenecen a este modelo son cargados en su lista interna.
    Si la consulta es exitosa, aunque sea vacía, devuelve true. En otro caso false y la lista
    modelosDeInteres no es modificada.
     */
    public boolean cargarModelosByElemento(String codigoElemento)
    {
        truncateModelosDeInteres();
        ElementoModeloDAO e = new ElementoModeloDAO(conn);
        ModeloDAO md = new ModeloDAO(conn);
        modelo.Modelo m;
        boolean incluir = false;
        for (String modelo: getCodigoModelos().getCodigosModelos()) {
            m = md.leer(modelo);
            for (modelo.Elemento elem : e.getElementosByCodigoModelo(m.getCodigo()))
            {
                if (elem.getCodigo().equals(codigoElemento)) {
                             m.setElementos(getElementosModelo(modelo));
                             getModelosDeInteres().add(m);
                             incluir=true;
                        }
                }
            }

        return incluir;
    }

    /*
    Carga la lista modelosDeInteres con los modelos que pertenecen a la sección sección. Los elemenos que pertenecen a cada modelo son cargados en su lista interna.
    Si la consulta es exitosa, aunque sea vacía, devuelve true. En otro caso false y la lista modelosDeInteres no es modificada.
    */
    public boolean cargarModelosBySeccion(String seccion)
    {
        truncateModelosDeInteres();
        ModeloDAO modeloDAO = new ModeloDAO(conn);
        boolean incluir = false;
        for (String modelo : getCodigoModelos().getCodigosModelos()) {
            modelo.Modelo m = modeloDAO.leer(modelo);
            if (m.getSeccion().equals(seccion))
            {
                m.setElementos(getElementosModelo(modelo));
                getModelosDeInteres().add(m);
                incluir=true;
            }
        }
        return incluir;
    }

    /*
        Para modificar un modelo, éste debe estar instanciado en el atributo modelosDeInteres.
    El método modifica el código del modelo tanto en memoria como en la base de datos, y devuelve true
    en caso de éxito. En cualquier otro caso devuelve false.
     */
    public boolean modificarModelo(String codigoModelo, String nuevoCodigoModelo)
    {
        boolean rdo = false;
        ModeloDAO modeloDAO = new ModeloDAO(conn);
        if (inModelosdeInteres(codigoModelo)) {
            modeloDAO.actualizar(codigoModelo, nuevoCodigoModelo);
            codigoModelos.refresh();
            for (modelo.Modelo m :getModelosDeInteres()){
                if (m.getCodigo().equals(codigoModelo)) {
                    rdo=true;
                    m.setCodigo(nuevoCodigoModelo);
                    }
                }
            }


        return rdo;
    }


    /*
    Para modificar un elemento, éste debe estar cargado en el atributo modeloActual.
    El método modifica el código del elemento tanto en memoria como en la base de datos y devuelve true en caso de éxito. En cualquier otro caso devuelve false.
    */
    public boolean modificarElemento(String codigo, String nuevoCodigo)
    {
        boolean rdo = false;
        for (modelo.Modelo m: getModelosDeInteres() ) {
            for (Elemento e:m.getElementos()) {
                if (e.getCodigo().equals(codigo)) {
                    rdo = true;
                    e.setCodigo(nuevoCodigo);
                }
            }
            
        }
        if (rdo) {
            ElementoDAO elementoDAO=new ElementoDAO(conn);
            elementoDAO.actualizar(codigo,nuevoCodigo);
        }
        return rdo;

    }


}
