public class ClaseCliente {

    private Catalogo catalogo;

    public ClaseCliente(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public void ejecutar(){
        System.out.println(catalogo.renderCabecera());
        System.out.println(catalogo.renderCuerpo());
        System.out.println(catalogo.renderPie());
    }
}