public class Musicas {

    private String nombre;
    private  int edad;
    private  Musicas [][] musicos;
    public Musicas(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Musicas() {
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



    public void  setMusicos(Musicas[][] musicos){

    }


    @Override
    public String toString() {
        return "Musicos{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                '}';
    }

    public void setMusicos(String nombre, int edad) {

    }
}
