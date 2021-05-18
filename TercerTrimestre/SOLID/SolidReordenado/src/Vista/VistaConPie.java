package Vista;

import Vista.Render.Renderer;

public class VistaConPie implements Vista {

    private Renderer vista;

    public VistaConPie(Renderer renderer){
        this.vista = renderer;
    }

    @Override
    public void render() {
        System.out.println(vista.renderCabecera());
        System.out.println(vista.renderCuerpo());
        System.out.println(vista.renderPie());
    }
}
