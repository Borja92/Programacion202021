import java.util.Comparator;
import java.util.Objects;

public class Paciente implements Comparator {

    private String nombre;
    private  int edad;
    private int idEspecialidad;
    private  boolean incidenciaGravedad;

    public Paciente() {
       /* this.nombre = nombre;
        this.edad = edad;
        this.idEspecialidad = idEspecialidad;
        this.incidenciaGravedad = incidenciaGravedad;*/
    }

    public Paciente(String nombre, int edad, int idEspecialidad, boolean incidenciaGravedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.idEspecialidad = idEspecialidad;
        this.incidenciaGravedad = incidenciaGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public boolean isIncidenciaGravedad() {
        return incidenciaGravedad;
    }

    public void setIncidenciaGravedad(boolean incidenciaGravedad) {
        this.incidenciaGravedad = incidenciaGravedad;
    }

    public int comparaGravedad(Paciente p){
        //Orden ascendente
return (p.isIncidenciaGravedad() ? 0:(-1));
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        if (incidenciaGravedad != paciente.incidenciaGravedad) return false;
        return Objects.equals(idEspecialidad, paciente.idEspecialidad);

    }



    @Override
    public String toString() {
        return "Paciente{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", idEspecialidad='" + idEspecialidad + '\'' +
                ", IncidenciaGravedad=" + incidenciaGravedad +
                '}';
    }
}
