public class MiMain {

    public static void main(String[] args) {

        Productos productos = new Productos();
        Producto producto;
        Mesas mesas = new Mesas();
        InterfazTPV interfazTPV = new InterfazTPV();
        Mesa mesa = new Mesa();
        //añadir productos
       // productos.annadirProducto("Ración de jamón", 8.00);
        //añadimos mesas
        mesas.annadirMesa("M12", false);
        mesas.annadirMesa("M1", true);
        mesas.annadirMesa("M2", true);
        mesas.annadirMesa("M3", false);
        mesas.annadirMesa("M4", true);

      /*  //listamos productos
        productos.listarProductos();
        //listamos mesas
        mesas.listarMesas();
        //listamos mesas abiertas
        mesas.mostrarMesasAbiertas();
        //listamos mesas cerradas
        mesas.mostrarMesasCerradas();*/
interfazTPV.crearFactura(mesas);



    }
}
