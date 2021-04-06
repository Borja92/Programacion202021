package Modelo;

public class Alquiler {
    private int codigo;
    private String fecha;
    int dias;

    public Alquiler(int codigo, String fecha, int dias) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.dias = dias;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }


    @Override
    public String toString() {
        return "Alquiler{" +
                "codigo=" + codigo +
                ", fecha='" + fecha + '\'' +
                ", dias=" + dias +
                '}'+"\n";
    }
}
