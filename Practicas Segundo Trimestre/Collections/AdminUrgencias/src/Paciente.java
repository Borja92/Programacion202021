public class Paciente {

    private String nombre;
    private  int edad;
    private String idEspecialidad;
    private  boolean incidenciaGravedad;

    public Paciente() {
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

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public boolean isIncidenciaGravedad() {
        return incidenciaGravedad;
    }

    public void setIncidenciaGravedad(boolean incidenciaGravedad) {
        this.incidenciaGravedad = incidenciaGravedad;
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
