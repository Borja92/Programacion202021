package TiendaMuebles;

public class Elemento {
    private String tipo;
    private String codigo;
public Elemento(){
    this.tipo=tipo;
    this.codigo=codigo;

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
public Elemento getElemento(){
  Elemento elemento = new Elemento();
    return  elemento;
}

    @Override
    public String toString() {
        return "Elemento{" +
                "tipo='" + tipo + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
