package TurismoCulinario.Modelo;


import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    private String nombre;
    private List<Establecimiento> establecimientos;
    private List<Plato> platos;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        platos = new ArrayList<>();
        establecimientos = new ArrayList<>();
    }

    public List<Establecimiento> getEstablecimientos() {
        return establecimientos;
    }

    public boolean tienePlato(String nombrePlato) {
        return platos.contains(new Plato(nombrePlato, null));
    }

    public Plato getPlatoPorNombre(String nombrePlato) {
        int posPlato = platos.indexOf(new Plato(nombrePlato, null));
        if (posPlato >= 0)
            return platos.get(posPlato);
        else
            return null;
    }

    public void addEstablecimiento(Establecimiento establecimiento) {
        establecimientos.add(establecimiento);
    }

    public void addPlato(Plato plato) {
        platos.add(plato);
    }

    public Establecimiento getEstablecimientoPorNombre(String nombreEstablecimiento) {
        for (Establecimiento establecimiento : establecimientos) {
            if (establecimiento.getNombre().equals(nombreEstablecimiento))
                return establecimiento;
        }
        return null;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public String getNombre() {
        return nombre;
    }


    // DEPURACIÓN
    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", establecimientos=" + establecimientos +
                ", platos=" + platos +
                '}';
    }
}