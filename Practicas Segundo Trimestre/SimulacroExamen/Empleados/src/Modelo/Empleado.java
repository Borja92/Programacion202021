package Modelo;

public abstract class Empleado {

    public final static int COMISIONADO = 1;
    public final static int ASALARIADO = 2;
    public final static int POR_HORAS = 3;

    private String nombre, apellidos;
    private int id;


    public Empleado(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double getSueldo();

    public abstract void setSueldoBase(double parteFijaDelSueldo);

    public abstract int getTipo();

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", id=" + id +
                '}';
    }
}
