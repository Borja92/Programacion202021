import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
    private List<Mesa> mesas;
    private double caja;
    List<Producto> carta;

    public Cafeteria(int totalMesas) {
        crearNuevasMesas(totalMesas);
        inicializarCarta();
        ponerCajaACero();
    }

    /**
     *
     * @param numeroMesa rango 1 .. n
     * @return
     */
    public Mesa getMesa(int numeroMesa){
        return mesas.get(numeroMesa-1);
    }

    public List<Mesa> getMesas(){
        return mesas;
    }

    public double getCaja(){
        return caja;
    }

    /**
     *
     * @param numeroProducto rangno 1 .. n
     * @param numeroMesa rango 1 .. n
     */
    public void addProducto(int numeroProducto, int numeroMesa){
        Mesa mesa = mesas.get(numeroMesa - 1);
        Producto producto = carta.get(numeroProducto - 1);
        mesa.addProducto(producto);
    }

    /**
     *
     * @param numeroMesa rango 1 .. n
     */
    public void borrarProductos(int numeroMesa){
        Mesa mesa = mesas.get(numeroMesa - 1);
        mesa.borrarProductos();
    }

    /**
     *
     * @param numeroMesa rango 1 .. n
     * @return total de la cuenta de la mesa
     */
    public double cobrarMesa(int numeroMesa){
        Mesa mesa = mesas.get(numeroMesa - 1);
        double totalCuenta = mesa.getTotalCuenta();
        mesa.borrarProductos();
        caja += totalCuenta;
        return totalCuenta;
    }

    public List<Producto> getCarta(){
        return carta;
    }

    /**
     *
     * @return rango de mesas 1 .. n (rango en lista 0 .. n-1)
     */
    public int abrirMesa(){
        mesas.add(new Mesa());
        return mesas.size();
    }

    private void crearNuevasMesas(int totalMesas){
        mesas = new ArrayList<>();
        for (int i=0; i<totalMesas; i++)
            mesas.add(new Mesa());
    }

    private void inicializarCarta() {
        carta = new ArrayList<>();
        carta.add(new Producto("Churro",0.50));
        carta.add(new Producto("Cafe con leche",1.00));
        carta.add(new Producto("Tostada",1.50));
        carta.add(new Producto("Zumo de naranja",2.00));
    }

    private void ponerCajaACero() {
        caja = 0;
    }
}