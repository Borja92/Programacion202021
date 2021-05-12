import negocio.Muebles;

public class TestMuebles {

    public static void main(String[] args) {

        Muebles m = new Muebles();

        System.out.println(m.getCategoria().crearCategoria("Gama Deluxe"));
        System.out.println(m.getCategoria().categoriaExists("Gama Deluxe"));




    }

}
