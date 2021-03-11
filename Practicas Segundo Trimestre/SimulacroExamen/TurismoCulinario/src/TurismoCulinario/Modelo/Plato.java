package TurismoCulinario.Modelo;

import java.util.Objects;

public class Plato {
    private String nombre;
    private String descripcion;

    public Plato(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        Plato plato = (Plato) o;
        return plato.getNombre().equalsIgnoreCase(nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion);
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
