package LSP;

public class Barco implements VehiculoAcuatico {
    /*@Override
    public void volar() {
        throw new UnsupportedOperationException("Un barco no vuela");
    }

    @Override
    public void circular() {
        throw new UnsupportedOperationException("Un barco no circula");
    }
*/
    @Override
    public void navegar() {
        System.out.println("Barco navegando");
    }
}
