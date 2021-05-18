public class VistaSinPie implements Vista {
    RendererSinPie vista;


    public VistaSinPie(RendererSinPie vista){
        this.vista = vista;
    }


    @Override
    public void render() {
        System.out.println(vista.renderCabecera());
        System.out.println(vista.renderCuerpo());
    }
}
