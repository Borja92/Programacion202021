import java.util.Objects;

public class Producto {
    private String nombreProducto;
    private  double precioProducto;


    public Producto(String nombreProducto, double precioProducto) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }



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

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre del producto='" + nombreProducto + '\'' +
                ", Precio=" + precioProducto +"€"+
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        Producto producto=(Producto) o;
        return producto.getNombreProducto().equalsIgnoreCase(getNombreProducto());
    }


}
