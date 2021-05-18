package Vista.Render;

import Modelo.Coche;

import java.util.List;

public abstract class Renderer extends RendererSinPie {
    public Renderer(List<Coche> coches){
        super(coches);
    }

    public abstract String renderCabecera();
    public abstract String renderCuerpo();
    public abstract String renderPie();
}
