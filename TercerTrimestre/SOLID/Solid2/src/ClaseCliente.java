public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(int tipoRenderer){
        RendererHtml vista;
        switch(tipoRenderer){
            case 1:
                vista = new RendererHtml(catalogo.getAll());
                break;
            default:
                vista = new RendererHtmlNavegable(catalogo.getAll());
        }
        System.out.println(vista.renderCabecera());
        System.out.println(vista.renderCuerpo());
        System.out.println(vista.renderPie());
    }
}