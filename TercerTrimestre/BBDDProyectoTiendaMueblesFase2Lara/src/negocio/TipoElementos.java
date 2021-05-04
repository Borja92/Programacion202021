package negocio;

import Persistencia.DBConn;
import Persistencia.TipoElementoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase TipoElementos
 */
public class TipoElementos {
    List<String>tiposElementos;
    private Connection conn;
    private TipoElementoDAO tipoElementoDAO;

    /**
     * Constructor
     */
    public TipoElementos(){
        this.conn=new DBConn().conectar();
        this.tipoElementoDAO= new TipoElementoDAO(conn);
        this.tiposElementos=new ArrayList<>();
    }

    /**
     * getTiposElementos
     * @return List<String>
     */
    public List<String> getTiposElementos() {
        return tiposElementos;
    }

    /**
     * refresh
     */
    public void refresh(){
            this.tiposElementos=tipoElementoDAO.getAll();
    }

    /**
     * tipoElementoExist
     * @param tipoElemento
     * @return boolean
     */
  public boolean tipoElementoExists(String tipoElemento){
      refresh();
          if (getTiposElementos().contains(tipoElemento)){
              return true;
          }

      return false;
  }

    /**
     * crearTipoElemento
     * @param tipoElemento
     * @return boolean
     */
   public boolean crearTipoElemento(String tipoElemento){

           if (tipoElementoDAO.crear(tipoElemento)){
              tiposElementos.add(tipoElemento);
               refresh();
               return true;
           }

       return false;
   }


    /**
     * modificarTipoElementos
     * @param tipoElemento
     * @param nuevoTipoElemento
     * @return
     */
   public boolean modificarTipoElemento(String tipoElemento, String nuevoTipoElemento){

           if (tipoElementoDAO.actualizar(tipoElemento,nuevoTipoElemento)){
           refresh();
               return true;}

       return false;
   }

    /**
     * deleteTiposElementos
     * @param tipoElemento
     * @return boolean
     */
  public   boolean deleteTiposElemento(String tipoElemento){
          if (tipoElementoDAO.borrar(tipoElemento)){
         refresh();
              return true;
          }
      return false;
  }

}
