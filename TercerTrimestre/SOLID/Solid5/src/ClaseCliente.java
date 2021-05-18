public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(int tipoVista){
        Vista renderer = FabricaDeVista.crear(catalogo.getAll(),tipoVista);
        renderer.render();
    }
}