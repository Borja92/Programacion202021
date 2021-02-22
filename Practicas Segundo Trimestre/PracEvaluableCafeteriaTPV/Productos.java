import java.util.ArrayList;
import java.util.Iterator;

public class Productos {

    private ArrayList<Producto> productoArrayList = new ArrayList<>();

    public Productos(ArrayList<Producto> productoArrayList) {
        this.productoArrayList = productoArrayList;
    }

    public Productos() {
    }

    public void  annadirProducto(String nombreProducto, double precioProducto){

        productoArrayList.add(new Producto(nombreProducto, precioProducto));
        System.out.println("Producto añadido\n");
    }

    public void listarProductos(){

        Producto producto;
        Iterator it=productoArrayList.iterator();
        while (it.hasNext()){
            producto=(Producto)it.next();
            System.out.println(producto);
        }
    }

    public int crearFactura(){
        int totalFactura=0;

        Iterator it=productoArrayList.iterator();
        while (it.hasNext()){
            Producto  producto=(Producto)it.next();
            totalFactura+=producto.getPrecioProducto();
        }
        return totalFactura;

    }


}
