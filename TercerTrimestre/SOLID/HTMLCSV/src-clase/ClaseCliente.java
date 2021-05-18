public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(int tipoRenderer){
        RendererSinPie renderer = ConstructorDeRenderer.crearRenderer(tipoRenderer,catalogo.getAll());
        System.out.println(renderer.mostrar());
    }
}