package Modelo;

public class Comisionado extends Empleado {
    private double sueldoBase;
    private int numeroVentas;
    private double comision = 10;


    public Comisionado(int id, String nombre, String apellidos, double sueldoBase, double comision, int numeroVentas) {
        super(id, nombre, apellidos);
        this.sueldoBase = sueldoBase;
        this.comision = comision;
        this.numeroVentas = numeroVentas;
    }

    @Override
    public double getSueldo() {
        return sueldoBase+numeroVentas*comision;
    }

    @Override
    public void setSueldoBase(double parteFijaDelSueldo) {
        this.sueldoBase=parteFijaDelSueldo;
    }

    @Override
    public int getTipo() {
        return Empleado.COMISIONADO;
    }

    @Override
    public String toString() {
        return "Comisionado{" +
                "sueldoBase=" + sueldoBase +
                ", numeroVentas=" + numeroVentas +
                ", comision=" + comision +
                '}';
    }
}
