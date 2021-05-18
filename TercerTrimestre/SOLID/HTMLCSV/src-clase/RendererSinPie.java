import java.util.List;

public abstract class RendererSinPie {
    public final static int HTML = 1;
    public final static int HTML_NAV = 2;
    public final static int XML = 3;
    public final static int CSV = 4;

    protected List<Coche> coches;

    public RendererSinPie(List<Coche> coches){
        this.coches = coches;
    }

    public abstract String renderCabecera();

    public abstract String renderCuerpo();

    public String mostrar(){
        return renderCabecera() + renderCuerpo();
    }
}
