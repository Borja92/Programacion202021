package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsuarioAficionesDAO {

    private Connection conn;

    public UsuarioAficionesDAO(){
        this.conn = DBConn.conectar();
    }

    /**
     * Devuelve la lista de todas las aficiones pertenecientes a un usuario
     * @return Lista con los identificadores de aficiónes de un usuario
     */
    public List<Integer> getAficionesUsuarioList(int id){
        List<Integer> aficiones = null;
        try{
            ResultSet result = conn.prepareStatement("SELECT * FROM usuario_aficiones where idUser="+id).executeQuery();
            aficiones = new ArrayList<>();
            while (result.next())
                aficiones.add(result.getInt("id"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aficiones;
    }

    /**
     * Añade una afición a la lista de aficiones de un usuario
     * @param aficion -> Identificador de afición a añadir al perfil de usuario
     * @param id -> Identificador de usuario
     * @return Verdadero si la actualización tuvo éxito / Falso en caso contrario
     */
    public boolean addAficion(Integer aficion ,Integer id){
        int auxAficion=-1;
        int auxIdUsuario = -1;
        AficionesDAO aficionesDAO= new AficionesDAO();

            try {

                for (Integer idAfcion:aficionesDAO.getAll().keySet() ) {
                    if (aficion.equals(idAfcion)) {
                        auxAficion = idAfcion;
                    }
                }
                    UsuariosDAO usuariosDAO= new UsuariosDAO();
                    for (Integer idUsuario:usuariosDAO.getIdUsuarios()) {
                        if (id.equals(idUsuario)){
                            auxIdUsuario=idUsuario;
                        }
                    }
if ((auxAficion>0)&&(auxIdUsuario>0)) {
    PreparedStatement statement = conn.prepareStatement("INSERT INTO usuario_aficiones(idUser, id)  VALUES ('" + id + "','" + aficion + "')");
    return statement.executeUpdate() > 0;
}
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        return false;
    }

    /**
     * Añade una afición a la lista de aficiones de un usuario
     * @param aficion -> Identificador de afición a borrar al perfil de usuario
     * @param id -> Identificador de usuario
     * @return Verdadero si la actualización tuvo éxito / Falso en caso contrario
     */
    public boolean deleteAficion(Integer aficion ,Integer id){


        int auxAficion=-1;
        int auxIdUsuario = -1;
        AficionesDAO aficionesDAO= new AficionesDAO();

        try {

            for (Integer idAfcion:aficionesDAO.getAll().keySet() ) {
                if (aficion.equals(idAfcion)) {
                    auxAficion = idAfcion;
                }
            }
            UsuariosDAO usuariosDAO= new UsuariosDAO();
            for (Integer idUsuario:usuariosDAO.getIdUsuarios()) {
                if (id.equals(idUsuario)){
                    auxIdUsuario=idUsuario;
                }
            }
            if ((auxAficion>0)&&(auxIdUsuario>0)) {
                PreparedStatement statement = conn.prepareStatement("DELETE  FROM usuario_aficiones WHERE id="+ "'" + auxAficion + "' AND  idUser=" + " '" + auxIdUsuario + "'");
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

}
