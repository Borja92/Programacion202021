package TiendaMuebles;

public class Elemento {
    private String tipo;
    private String codigo;
public Elemento(String codigo, String tipo){
    this.tipo=tipo;
    this.codigo=codigo;

}

    public Elemento() {
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
    public String toString() {
        return "Elemento{" +
                "tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
