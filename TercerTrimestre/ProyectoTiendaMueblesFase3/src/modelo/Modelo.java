package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Modelo {
    private List<Elemento> elementos;
    private String codigo;
    private String seccion;
    private String categoria;

    public Modelo(String codigo, String seccion, String categoria){
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

    public void addElemento(Elemento elemento){
        if (elementos == null)
            elementos = new ArrayList<>();
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
                "codigo='" + codigo + '\'' +
                ", seccion='" + seccion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", elementos=" + elementos +
                "}\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo)) return false;
        Modelo modelo = (Modelo) o;
        return  Objects.equals(codigo, modelo.codigo) &&
                Objects.equals(seccion, modelo.seccion) &&
                Objects.equals(categoria, modelo.categoria)
                && ((Modelo) o).getElementos().containsAll(modelo.getElementos());
    }


}
