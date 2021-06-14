package vista;

import modelo.Usuario;
import persistencia.AficionesDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aficiones {
private AficionesDAO aficionesDAO;
public Aficiones(){
    this.aficionesDAO= new AficionesDAO();
}
private HashMap<Integer,String> getAfciones(){

    return aficionesDAO.getAll();

}
    public void mostrarAficionesDisponibles(HashMap<Integer,String> aficiones)
    {
        aficiones=getAfciones();
        System.out.println("Conjunto de Aficiones");
        System.out.println("--------------------");
        for (Integer clave : aficiones.keySet())
        {
            System.out.println(clave + ":"+ aficiones.get(clave));
        }
        System.out.println("0: Salir");
        System.out.println("Elegir una opción:");
    }

    public void mostrarAficionesSeleccionadas(HashMap<Integer,String> aficiones)
    {
        Usuario usuario= new Usuario();


        System.out.println("Conjunto de Aficiones");
        System.out.println("--------------------");
        for (Integer clave : aficiones.keySet())
        {
            System.out.println(clave + ":"+ aficiones.get(clave));
        }
        System.out.println("0: Salir");
        System.out.println("Elegir una opción:");
    }


}
