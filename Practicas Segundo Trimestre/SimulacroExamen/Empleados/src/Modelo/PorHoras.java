package Modelo;

public class PorHoras extends Empleado {

    private double sueldoPorHora;
    private double horasTrabajadas;

    public PorHoras(int id, String nombre, String apellidos, double sueldoPorHora, double horasTrabajadas) {
        super(id, nombre, apellidos);
        this.sueldoPorHora = sueldoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double getSueldo() {
        return sueldoPorHora *horasTrabajadas;
    }

    @Override
    public void setSueldoBase(double parteFijaDelSueldo) {
this.sueldoPorHora =parteFijaDelSueldo;
    }

    @Override
    public int getTipo() {
        return Empleado.POR_HORAS;
    }

    @Override
    public String toString() {
        return "PorHoras{" +
                "horasTrabajadas=" + horasTrabajadas +
                ", sueldoPorHora=" + sueldoPorHora +
                '}';
    }
}
