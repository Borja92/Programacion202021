import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VistaCafeteria {
    private static Cafeteria cafeteria;
    private static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");

    public void inicio() {
        inicializarCafeteria();
        inicarSesion();
    }

    private  void inicializarCafeteria() {
        System.out.print("Número de mesas abiertas: ");
        int numMesasAbiertas = lectorTeclado.nextInt();
        cafeteria = new Cafeteria(numMesasAbiertas);
    }

    private void inicarSesion() {
        int opcion = 0;
        do {
            opcion = obterOpcionMenuPrincipal();
            ejecutarOpcion(opcion);
        } while (true);
    }

    private int obterOpcionMenuPrincipal() {
        System.out.print("1. Consultar mesas.\n" +
                "2. Consultar el recuento de caja actual.\n" +
                "3. Añadir producto a una mesa.\n" +
                "4. Cobrar mesa.\n" +
                "5. Abrir mesa.\n" +
                "opcion: ");
        return lectorTeclado.nextInt();
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion){
            case 1:
                mostrarProductosMesas();
                break;
            case 2:
                mostrarTotalCaja();
                break;
            case 3:
                int numeroMesa = preguntarNumeroMesa();
                hacerPedidoMesa(numeroMesa);
                mostrarPedidoMesa(numeroMesa,"");
                break;
            case 4:
                numeroMesa = preguntarNumeroMesa();
                mostrarPedidoMesa(numeroMesa,"-");
                cobrarMesa(numeroMesa);
                break;
            case 5:
                abrirNuevaMesa();
                break;
        }
    }

    /**
     *
     */
    private void mostrarProductosMesas() {
        List<Mesa> mesas = cafeteria.getMesas();
        for (int i = 0; i < mesas.size(); i++){
            System.out.println("MESA " + (i+1));
            mostrarPedidoMesa(i+1,"");
        }
    }

    private void mostrarTotalCaja(){
        System.out.println("Total: " + cafeteria.getCaja() + "€");
    }


    private int preguntarNumeroMesa() {
        System.out.print("Número de mesa: ");
        int numeroMesa =  lectorTeclado.nextInt();
        System.out.println("----------------------------------------------\n" +
                "MESA " + numeroMesa + "\n" +
                "-------------------------------------------------\n");
        return numeroMesa;
    }

    private void hacerPedidoMesa(int numeroMesa) {
        int numeroProducto = 0;
        int cantidad = 0;
        do{
            System.out.print("Número de producto [0 -> terminar. -1 -> borrar cuenta]: ");
            numeroProducto = lectorTeclado.nextInt();
            if (numeroProducto == -1) {
                cafeteria.borrarProductos(numeroMesa);
            } else if (numeroProducto > 0){
                System.out.print("Cantidad: ");
                cantidad = lectorTeclado.nextInt();
                for (int i=0; i<cantidad; i++)
                    cafeteria.addProducto(numeroProducto,numeroMesa);
            }
        } while (numeroProducto != 0);
    }

    private void mostrarPedidoMesa(int numeroMesa, String simboloNumeracion) {
        Mesa mesa = cafeteria.getMesa(numeroMesa);
        List<Producto> pedido = mesa.getProductos();

        // List<Producto> pedido = cafeteria.getMesa(numeroMesa).getProductos();

        List<Producto> carta = cafeteria.getCarta();
        for (Producto productoCarta : carta) {
            int cantidadProducto = Collections.frequency(pedido, productoCarta);
            if (cantidadProducto > 0)
                System.out.println(simboloNumeracion + " " + cantidadProducto + " x " + productoCarta.getNombre());
        }
    }

    private void cobrarMesa(int numeroMesa) {
        double totalPedido = cafeteria.cobrarMesa(numeroMesa);
        System.out.println("----------------------------------------");
        System.out.println(totalPedido + "€");
    }

    private void abrirNuevaMesa() {
        System.out.print("¿Abrir nueva mesa [s]/n? ");
        String opcion = lectorTeclado.next();
        if ((opcion.equals("s")) || opcion.isEmpty()){
            int numeroMesa = cafeteria.abrirMesa();
            System.out.println("Mesa " + numeroMesa + " abierta");
        }
    }


    public static void main(String[] args) {
        VistaCafeteria vista = new VistaCafeteria();
        vista.inicio();
    }
}