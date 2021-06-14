package LSP;

public class Coche implements VehiculoTerrestre{
    /*@Override
    public void volar() {
        throw new UnsupportedOperationException("Un coche no vuela");
    }
*/
    @Override
    public void circular() {
        System.out.println("Coche circulando");
    }

    /*@Override
    public void navegar() {
        throw new UnsupportedOperationException("Un coche no navega");
    }*/
}
