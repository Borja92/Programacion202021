package modelo;

public class Elemento {
    private String tipo;
    private String codigo;

    public Elemento(String tipo, String codigo){
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        Elemento elemento = (Elemento) o;
        return elemento.getCodigo().equals(codigo) && elemento.getTipo().equals(tipo);
    }

    @Override
    public String toString() {
        return "\nElemento{" +
                "tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                "}";
    }
}
