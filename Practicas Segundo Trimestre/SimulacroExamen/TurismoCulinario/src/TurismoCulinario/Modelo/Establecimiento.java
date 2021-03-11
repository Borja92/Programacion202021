package TurismoCulinario.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {
    private String nombre;
    private Coordenadas ubicacion;
    private List<Plato> platos;

    public Establecimiento(String nombre, Coordenadas ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        platos = new ArrayList<>();
    }




    public String getNombre() {
        return nombre;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public Coordenadas getUbicacion() {
    return ubicacion;
    }

    public void  addPlato(Plato plato){
        platos.add(plato);
    }
    public  boolean tienePlato(String nombrePlato){

        return platos.contains(new Plato(nombre, null));
    }

    @Override
    public boolean equals(Object o) {
        Establecimiento establecimiento = (Establecimiento) o;
        return nombre.equals(establecimiento.getNombre());
    }

    // DEPURACIÓN
    @Override
    public String toString() {
        return "Establecimiento{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                ", platos=" + platos +
                "}\n";
    }




}
