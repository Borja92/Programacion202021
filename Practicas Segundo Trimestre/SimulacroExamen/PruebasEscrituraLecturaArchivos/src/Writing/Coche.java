package Writing;

public class Coche {
    private String id, marca, modelo, cilindrada;

    public Coche() {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.id=id;
    }

    public Coche(String id, String marca, String modelo, String cilindrada) {
        this.id=id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }
public String getId(){
        return id;
}

}
