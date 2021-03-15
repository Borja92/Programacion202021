public class Judador {
    private String nickname, nombre, apellidos;
    private int edad;

    public Judador(String nickname, String nombre, String apellidos, int edad) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Judador() {
    }


    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Judador judador = (Judador) o;

        return nickname.equals(judador.nickname);

    }

    @Override
    public int hashCode() {
        return nickname.hashCode();
    }

    @Override
    public String toString() {
        return "Judador{" +
                "nickname='" + nickname + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }




}
