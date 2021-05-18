import java.util.List;

public class ConstructorDeRenderer {
    public static RendererSinPie crearRenderer(int opcion, List<Coche> coches){
        switch(opcion){
            case RendererSinPie.HTML: return new RendererHtml(coches);
            case RendererSinPie.HTML_NAV: return new RendererHtmlNavegable(coches);
            case RendererSinPie.XML: return new RendererXML(coches);
            default: // RendererSinPie.CSV
                return new RendererCSV(coches);
        }
    }
}
