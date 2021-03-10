package TurismoCulinario.Modelo.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

    private String nombre;
    private List<Establecimiento> establecimientos;
    private List<Plato> platos;


    public Ciudad(String nombreCiudad) {
        this.nombre=nombre;
        platos= new ArrayList<>();
        establecimientos= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }
    public List<Plato> getPlatos() {
        return platos;
    }


    public boolean tienePlato(String nombrePlato){

        return  platos.contains(new Plato(nombrePlato,null));
    }
public Plato getPlatoPorNombre(String nombrePlato){

        int posPlato= platos.indexOf(new Plato(nombrePlato,null));
        if (posPlato>=0)
            return  platos.get(posPlato);
        else return null;
}

    public void addEstablecimiento(Establecimiento establecimiento){
        establecimientos.add(establecimiento);
    }

    public List<Establecimiento> establecimientosPorPlatoTipico(String nombrePlato){
List<Establecimiento> establecimientosPorPlatoTipico = new ArrayList<>();
        for (Establecimiento e: establecimientos) {
            if (establecimientos.contains(nombrePlato)){
    establecimientos.add(e);
        }
    }
        return establecimientosPorPlatoTipico;

    }

    public void addPlato(Plato plato) {
        platos.add(plato);
    }
public Establecimiento getEstablecimientoPorNombre(String nombreEstablecimiento){

    for (Establecimiento e:establecimientos  ) {
        if (e.getNombre().equalsIgnoreCase(nombreEstablecimiento)){
            return e;
        }
    }
    return null;

}

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", establecimientos=" + establecimientos +
                ", platos=" + platos +
                '}';
    }





}
