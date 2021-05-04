package modelo;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private List<Elemento> elementos;
    private String codigo;
    private String seccion;
    private String categoria;

    public Modelo(String codigo, String seccion, String categoria){
        this.codigo = codigo;
        this.seccion = seccion;
        this.categoria = categoria;
        this.elementos=new ArrayList<>();
    }

    public List<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(List<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(Elemento elemento){
        //if (elementos == null)
           // elementos = new ArrayList<>();
        elementos.add(elemento);
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

    @Override
    public String toString() {
        return "Modelo{" +
                "elementos=" + elementos +
                ", codigo='" + codigo + '\'' +
                ", seccion='" + seccion + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
