import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        Producto producto = (Producto) o;
        return producto.getNombre() == nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }
}