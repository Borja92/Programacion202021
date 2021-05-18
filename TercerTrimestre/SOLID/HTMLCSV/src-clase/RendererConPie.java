import java.util.List;

public abstract class RendererConPie extends RendererSinPie{


    public RendererConPie(List<Coche> coches) {
        super(coches);
    }

    public abstract String renderPie();

    @Override
    public String mostrar() {
        return super.mostrar() + renderPie();
    }
}

