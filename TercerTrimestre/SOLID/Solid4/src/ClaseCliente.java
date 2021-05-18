public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(int tipoRenderer){

        if ((tipoRenderer > 0) && (tipoRenderer < 4)) {
            Renderer renderer =null;
            switch (tipoRenderer) {
                case 1:
                    renderer = new RendererHtml(catalogo.getAll());
                    break;
                case 2:
                    renderer = new RendererHtmlNavegable(catalogo.getAll());
                case 3:
                    renderer = new RendererXML(catalogo.getAll());
            }
            System.out.println(renderer.renderCabecera());
            System.out.println(renderer.renderCuerpo());
            System.out.println(renderer.renderPie());
        } else {
            RendererSinPie rendererSinPie = new RendererCSV(catalogo.getAll());
            System.out.println(rendererSinPie.renderCabecera());
            System.out.println(rendererSinPie.renderCuerpo());
        }

    }
}