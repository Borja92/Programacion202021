import java.util.Comparator;

public class Piloto implements Comparator<Piloto> {

    private String nombre;
    private String escuderia;
    private Integer posicionDeSalida;
    private boolean descalificado = false;

    public Piloto(Integer posicionDeSalida, String nombre, String escuderia, boolean descalificado) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.posicionDeSalida = posicionDeSalida;
        this.descalificado = descalificado;
    }

    public Piloto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public Integer getPosicionDeSalida() {
        return posicionDeSalida;
    }

    public void setPosicionDeSalida(Integer posicionDeSalida) {
        this.posicionDeSalida = posicionDeSalida;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }


    public int compare(Piloto o) {

        return this.nombre.compareTo(o.nombre);
    }


    public int comparaPosicionSalida(Piloto o1) {

        int comparaPosicionSalida = ((Piloto) o1).getPosicionDeSalida();
//Orden ascendente
        return this.posicionDeSalida - comparaPosicionSalida;
//Orden descendente
        //  return comparaPosicionSalida-this.posicionDeSalida;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "Nombre='" + nombre + '\'' +
                ", Escuderia='" + escuderia + '\'' +
                ", PosicionDeSalida=" + posicionDeSalida +
                ", Descalificado=" + descalificado +
                "}\n";
    }

    @Override
    public int compare(Piloto o1, Piloto o2) {
        return 0;
    }
}
