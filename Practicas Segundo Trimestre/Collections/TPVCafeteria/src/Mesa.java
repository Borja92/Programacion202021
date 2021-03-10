import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Producto> productos;

    public Mesa(){
        productos = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public void borrarProductos() {
        productos.clear();
    }

    public double getTotalCuenta() {
        double totalCuenta = 0;
        for (Producto producto : productos)
            totalCuenta += producto.getPrecio();
        return totalCuenta;
    }


    public List<Producto> getProductos() {
        return productos;
    }
}