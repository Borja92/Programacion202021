import Negocio.CatalogoSinIncrementoPrecio;
import Vista.FabricaDeVista;
import Vista.Vista;

public class ClaseCliente {

    private CatalogoSinIncrementoPrecio catalogo;

    public ClaseCliente(CatalogoSinIncrementoPrecio catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(int tipoVista){
        Vista renderer = FabricaDeVista.crear(catalogo.getAll(),tipoVista);
        renderer.render();
    }
}