package Modelo;

public class Asalariado extends Empleado {

    private double sueldoFijo;


    public Asalariado(int id, String nombre, String apellidos, double sueldoFijo) {
        super(id, nombre, apellidos);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double getSueldo() {
        return sueldoFijo;
    }

    @Override
    public void setSueldoBase(double parteFijaDelSueldo) {
    this.sueldoFijo=parteFijaDelSueldo;
    }

    @Override
    public int getTipo() {
        return Empleado.ASALARIADO;
    }

    @Override
    public String toString() {
        return "Asalariado{" +
                "sueldoFijo=" + sueldoFijo +
                '}';
    }
}
