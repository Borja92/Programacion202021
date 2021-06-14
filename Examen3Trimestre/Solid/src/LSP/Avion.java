package LSP;

public class Avion implements VehiculoAereo{
    @Override
    public void volar() {
        System.out.println("Avión volando");
    }

   /* @Override
    public void circular() {
        System.out.println("Avión circulando");
    }

    @Override
    public void navegar() {
        throw new UnsupportedOperationException("Un avión no navega");
    }*/
}
