import java.util.List;

public class RendererHtmlNavegable extends RendererHtml {

    public RendererHtmlNavegable(List<Coche> coches){
        super(coches);
    }

    public String renderCabecera(){
        return super.renderCabecera();
    }

    public String renderCuerpo(){
        String cuerpo = "\t<nav>\n" +
                "\t\t<li>\n" +
                "\t\t\t<ul><a href=\"http://www.catalogo.com/index.html\">Inicio</a></ul>\n" +
                "\t\t\t<ul><a href=\"http://www.catalogo.com/sobre.html\">Sobre este sitio</a></ul>\n" +
                "\t\t</li>\n" +
                "\t</nav>\n";
        cuerpo += super.renderCuerpo();
        cuerpo += "<p>Esta información corresponde a los vehículos del catálogo</p>";

        return cuerpo;

    }

    public String renderPie(){
        return super.renderPie();
    }
}
