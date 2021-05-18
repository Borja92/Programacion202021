package Vista.Render;

import Modelo.Coche;

import java.util.List;

public abstract class RendererSinPie {
    protected List<Coche> coches;

    public RendererSinPie(List<Coche> coches){
        this.coches = coches;
    }

    public abstract String renderCabecera();
    public abstract String renderCuerpo();
}
