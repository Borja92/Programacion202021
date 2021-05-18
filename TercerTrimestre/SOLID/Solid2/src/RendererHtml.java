import java.util.List;

public class RendererHtml {
    private List<Coche> coches;

    public RendererHtml(List<Coche> coches){
        this.coches = coches;
    }

    public String renderCabecera(){
        return "<html>\n" +
                "   <head>\n" +
                "       <title>Vehículos</title>\n" +
                "   </head>\n" +
                "   <body>";
    }

    public String renderCuerpo(){
        String cuerpo = "";
        for (Coche coche: coches)
            cuerpo += "      <div class='coche'>\n" +
                    "          <p>Descripcion:" + coche.getNombre() + "</p>\n" +
                    "          <p>Matrícula:" + coche.getMatricula() + "</p>\n" +
                    "          <p>Precio:" + coche.getPrecio() + " €</p>\n" +
                    "      </div>\n";
        return cuerpo;

    }

    public String renderPie(){
        return "</body>\n" +
                "</html>";
    }
}
