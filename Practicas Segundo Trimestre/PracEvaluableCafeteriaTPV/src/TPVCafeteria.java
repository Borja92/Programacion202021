/**
 * Practica Evaluable con Listas
 * <p>
 * ---TPV Cafeteria---
 * <p>
 * Autor:                 A. Borja Badía Checa
 * <p>
 * Indicaciones:
 * <p>
 * Se desea crear un programa para administrar una cafetería, en la que tengamos unas mesas
 * establecidas y a estas les podamos agregar productos, que tendrán nombre y precio. Podremos añadir
 * productos a una mesa. También podemos cobrar una mesa, lo que implica obtener la cuenta y vaciar
 * la lista de productos añadidos en la mesa.
 * Se puede hacer un recuento de caja, que indica el total de dinero cobrado a las mesas hasta el
 * momento.
 */

import java.util.Scanner;

public class TPVCafeteria {
    Cafeteria cafeteria = new Cafeteria();
    Mesa mesa = new Mesa();
    Scanner src = new Scanner(System.in).useDelimiter("\n");
    double recuentoCaja = 0;
    int aux = 0;


    /**
     * Inicio declaración de métodos de la Clase Nodo
     */

    public String iniciarTPV() {//El menún principal que llama a métodos y submenus
        int opcion;
        cafeteria.crearMesas(5);//Iniciamos las mesas en 5 para empezar
        System.out.println("------¡Bien venido al menú!------\n");
        do {
            System.out.println("¿Qué opción desea realizar?\n" +
                    "1-Listar todas las mesas\n" +
                    "2-Recuento caja actual\n" +
                    "3-Añadir productos a una mesa\n" +
                    "4-Cobrar mesa\n" +
                    "5-Abrir mesa\n" +
                    "6-Apagar TPV\n"
            );
            opcion = src.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(cafeteria.listarMesas());

                    break;
                case 2:
                    System.out.println("El recuento de la caja hasta ahora es de: " + recuentoCaja + "€\n");
                    break;
                case 3:
                    annadirProductoAMesa();
                    break;
                case 4:
                    System.out.println("Introduce el codigo de una mesa para cobrarla: ");
                    int codMesa = src.nextInt();
                    recuentoCaja += cafeteria.cobrarMesa(codMesa);//vacia de productos la lista
                    break;
                case 5:
                    cafeteria.abrirMesa();
                    break;
                case 6:
                    System.out.println("Hasta la próxima!!");
                    break;
            }

        } while (opcion != 6);
        return "----------" +
                "TPV OFF" +
                "----------";
    }

    public String annadirProductoAMesa() {//Submenún que gestiona el añadir pedidos a una mesa
        int codMesa, countChurro = 0, countZumo = 0, countTostada = 0, countCafe = 0;
        int opcion = 0, cantidadProducto = 0;

        System.out.print("\nNúmero de mesas: [" + cafeteria.numMesas() + "]: ");
        codMesa = src.nextInt();
        System.out.println("---------------------\n" +
                "Mesa " + codMesa + "\n" +
                "---------------------");
        mesa = cafeteria.seleccionarMesa(codMesa);

        do {
            System.out.print("Número de producto [0 -> terminar. -1 ->borrar cuenta]: ");
            opcion = src.nextInt();

            String nombreProducto = "";
            double precioProducto = 0;

            if (opcion != 0) {
                System.out.println("Cantidad: ");
                cantidadProducto = src.nextInt();
                for (int i = 0; i < cantidadProducto; i++) {
                    mesa.comandaProductos.add(cafeteria.seleccionarProducto(opcion));
                }
            }

            for (Producto p : mesa.comandaProductos) {
                if (opcion == p.getIdProducto()) {
                    nombreProducto = p.getNombreProducto();
                    precioProducto = p.getPrecioProducto();
                }
            }

            if (opcion == 1) {
                countChurro += cantidadProducto;
                System.out.println(nombreProducto + "----" + precioProducto + "€ " + " X" + countChurro);
            }
            if (opcion == 2) {
                countCafe += cantidadProducto;
                System.out.println(nombreProducto + "----" + precioProducto + "€ " + " X" + countCafe);
            }
            if (opcion == 3) {
                countTostada += cantidadProducto;
                System.out.println(nombreProducto + "----" + precioProducto + "€ " + " X" + countTostada);
            }
            if (opcion == 4) {
                countZumo += cantidadProducto;
                System.out.println(nombreProducto + "----" + precioProducto + "€ " + " X" + countZumo);
            }

            if (opcion == -1) {
                System.out.println("Comanda eliminada\n" +
                        "Empiece de nuevo: ");
                mesa.comandaProductos.clear();
            }
        } while (opcion != 0);

        return "----------";
    }


    public static void main(String[] args) {
        TPVCafeteria tpvCafeteria = new TPVCafeteria();

        //Pone en marcha el programa
        System.out.println(tpvCafeteria.iniciarTPV());

    }

}




