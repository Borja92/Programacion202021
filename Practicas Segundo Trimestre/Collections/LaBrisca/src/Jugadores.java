/*
public class Jugadores {
    private String nickname, nombre, apellidos;
    private int edad, partidadGanadas;

    public Jugadores(String nickname, String nombre, String apellidos, int edad, int partidadGanadas) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.partidadGanadas=partidadGanadas;
    }

    public Jugadores() {
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

    public int getPartidasGanadas() {
        return partidadGanadas;
    }

    public boolean equals (Jugadores j){

        if(j.getNickname().equals(nickname)){
            return true;
        }else{
            return false;
        }
    }

    public void anotarVIctoria(){

        this.partidadGanadas++;
    }
    @Override
    public String toString() {
        return "Jugadores{" +
                "nickname='" + nickname + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +'\''+
                ", Ganadas= "+partidadGanadas+
                '}';
    }

public String toCSVLine(){

        return  nickname+","+nombre+", "+apellidos+", "+edad+", "+partidadGanadas+"\n";
}


}
*/
