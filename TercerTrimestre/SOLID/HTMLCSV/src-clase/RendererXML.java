import java.util.List;

public class RendererXML extends RendererConPie {
    public RendererXML(List<Coche> coches) {
        super(coches);
    }

    @Override
    public String renderCabecera() {
        return "<catalogo>";
    }

    @Override
    public String renderCuerpo() {
        String cuerpo = "";
        for (Coche coche : coches){
            cuerpo += "<coche>\n<descripcion> "+coche.getNombre()+" </descripcion>\n<matricula>"+coche.getMatricula()+"</matricula>\n<precio>"+coche.getPrecio()+" </precio>\n</coche>\n";
        }
        return cuerpo;
    }

    @Override
    public String renderPie() {
        return "</catalogo>";
    }
}
