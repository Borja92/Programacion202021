package TiendaMuebles;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private List<Elemento> elementos;
    private String codigo;
    private String seccion;
    private String categoria;



    public Modelo( String codigo, String seccion, String categoria) {
        this.elementos = new ArrayList<>();
        this.codigo = codigo;
        this.seccion = seccion;
        this.categoria = categoria;
    }


    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public  void refresh(){}

    public boolean crearModelo(Modelo modelo){
        return false;
    }

    public Elemento crearElemento(String codigo, String tipoElemento, String codigoModelo){
      Elemento elemento=  new Elemento(codigo,tipoElemento);
        return elemento;
    }


    @Override
    public String toString() {
        return "Modelo{" +
                "codigo='" + codigo + '\'' +
                ", seccion='" + seccion + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
