package Vista.Render;

import Modelo.Coche;

import java.util.List;

public class RendererXML extends Renderer {

    public RendererXML(List<Coche> coches){
        super(coches);
    }

    @Override
    public String renderCabecera() {
        return "<catalogo>\n";
    }

    @Override
    public String renderCuerpo() {
        String cuerpo = "";
        for (Coche coche : coches)
            cuerpo+="\t<coche>\n" +
                    "\t\t<descripcion>" + coche.getNombre() + "</descripcion>\n" +
                    "\t\t<matricula>" + coche.getMatricula() + "</matricula>\n" +
                    "\t\t<precio>" + coche.getPrecio() + "</precio>\n" +
                    "\t</coche>\n";
        return cuerpo;
    }

    @Override
    public String renderPie() {
        return "</catalogo>";
    }
}
