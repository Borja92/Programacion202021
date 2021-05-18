public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(){
        RendererHtml rendererHtml = new RendererHtml(catalogo.getAll());
        System.out.println(rendererHtml.renderCabecera());
        System.out.println(rendererHtml.renderCuerpo());
        System.out.println(rendererHtml.renderPie());
    }
}