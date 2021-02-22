import java.util.StringJoiner;

public class Producto {
    private String nombreProducto;
    private double precioProducto;
    private int idProducto;

    /**
     * Declaración constructor
     */
    public Producto(int idProducto, String nombreProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.idProducto = idProducto;
    }

    public Producto() {
    }
/** Fin declaración construtor
 */

    /**
     * Declaración de Getters&Setters
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Fin declaración Getters&Setters
     */
    @Override
    public String toString() {
        return
                "Producto='" + nombreProducto + '\'' +
                        ", IdProducto=" + idProducto +
                        "Precio" + precioProducto +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        Producto producto = (Producto) o;
        return producto.getIdProducto() == (getIdProducto());
    }

}