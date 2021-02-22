import java.util.LinkedList;
import java.util.Scanner;


public class Cafeteria {
    Mesa mesa = new Mesa();
    Producto producto;
    LinkedList<Mesa> listaDeMesas;
    Scanner src = new Scanner(System.in);

    /**
     * Declaración constructor
     */
    public Cafeteria() {
        this.mesa = mesa;
        this.producto = producto;
        this.listaDeMesas = new LinkedList<>();
    }

/** Fin declaración construtor
 */

    /**
     * Inicio declaración de métodos de la  Cafeteria
     */

    /*public String listarCarta() {

        Iterator it = carta.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        return "----------";
    }*/
    public void crearMesas(int numMesasACrear) {
        for (int i = 0; i < numMesasACrear; i++) {
            listaDeMesas.add(i, new Mesa(i + 1));
        }
    }

    public void abrirMesa() {
        String opcion = "";
        System.out.println("¿Desea abrir una nueva mesa? s/n");
        opcion = src.nextLine().toLowerCase();
        if (opcion.contains("s")) {
            int idMesa = listaDeMesas.size() + 1;
            listaDeMesas.add(new Mesa(idMesa));
            System.out.println("Mesa abierta número: " + idMesa);
        }
    }


    public LinkedList listarMesas() {
        LinkedList<Mesa> mesas = new LinkedList<>(listaDeMesas);
        return mesas;
    }

    /*public String listarMesasDisponibles() {

        System.out.println("Mesas abiertas: \n");

        for (Mesa m : listaDeMesas) {
            if (m.isMesaAbierta()) {
                System.out.println(m);
            }
        }
        return "----------";
    }*/


    /*public void cerrarMesa(int codMesa) {
        mesa.setCodigoMesa(codMesa);
        mesa.setMesaAbierta(false);
    }*/

    public Mesa seleccionarMesa(int codMesa) {
//        mesa.setCodigoMesa(codMesa);
        Mesa mesaElegida = new Mesa();
        for (Mesa m : listaDeMesas) {
            if (m.getCodigoMesa() == codMesa) {
                mesaElegida = m;
            }
        }

        return mesaElegida;
    }

    public Producto seleccionarProducto(int idProducto) {
        Producto productoElegido = new Producto();
        if (idProducto == 1) {
            productoElegido.setIdProducto(1);
            productoElegido.setPrecioProducto(0.50);
            productoElegido.setNombreProducto("Churro");
            //mesa.comandaProductos.add(new Producto(1, "Churro", 0.50));
        }
        if (idProducto == 2) {
            productoElegido.setIdProducto(2);
            productoElegido.setPrecioProducto(1);
            productoElegido.setNombreProducto("Café con leche");
            // mesa.comandaProductos.add(new Producto(2, "Café con leche", 1));
        }
        if (idProducto == 3) {
            productoElegido.setIdProducto(3);
            productoElegido.setPrecioProducto(1.5);
            productoElegido.setNombreProducto("Tostada");
            //mesa.comandaProductos.add(new Producto(3, "Tostada", 1.5));
        }
        if (idProducto == 4) {
            productoElegido.setIdProducto(4);
            productoElegido.setPrecioProducto(2);
            productoElegido.setNombreProducto("Zumo de naranja");
            //mesa.comandaProductos.add(new Producto(4, "Zumo de Naranja", 2));
        }
        return productoElegido;
    }

    public int numMesas() {
        return listaDeMesas.size();

    }

    public double cobrarMesa(int codMesa) {
        Mesa mesaACobrar = new Mesa();
        mesaACobrar = seleccionarMesa(codMesa);

        double aux = 0;
        for (Producto p : mesaACobrar.comandaProductos) {
            aux += p.getPrecioProducto();
        }
        mesaACobrar.comandaProductos.clear();
        return aux;
    }
}

