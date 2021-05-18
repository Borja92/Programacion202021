package Modelo;

public class Coche {

    private String nombre;
    private String matricula;
    private double precio;

    public Coche(String nombre, String matricula, double precio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
