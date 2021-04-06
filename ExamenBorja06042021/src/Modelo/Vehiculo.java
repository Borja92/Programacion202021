package Modelo;

public class Vehiculo {

    private int codigo;
    String modelo;
    double precio;

    public Vehiculo(int codigo, String modelo, double precio) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Vehiculo() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "codigo=" + codigo +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}'+"\n";
    }
}
