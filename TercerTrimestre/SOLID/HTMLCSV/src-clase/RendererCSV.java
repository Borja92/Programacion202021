import java.util.List;

public class RendererCSV extends RendererSinPie {
    public RendererCSV(List<Coche> coches) {
        super(coches);
    }

    @Override
    public String renderCabecera() {
        return "descripcion;matricula;precio\n";
    }

    @Override
    public String renderCuerpo() {
        String cuerpo = "";
        for (Coche coche : coches){
            cuerpo += coche.getNombre() + ";" + coche.getMatricula() + ";" + coche.getPrecio() + "\n";
        }
        return cuerpo;
    }
}
