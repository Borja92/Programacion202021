public class Jugador {

    private String nickname;
    private String nombre;
    private String apellidos;
    private int edad;
    private int partidasGanadas;


    public Jugador(String nickname,String nombre,String apellidos,int edad,int ganadas)
    {
        this.nickname=nickname;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.edad=edad;
        this.partidasGanadas=ganadas;

    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public String getNombreApellido(){
        return this.nombre+" "+this.apellidos;
    }

    public void anotarVictoria()
    {
        this.partidasGanadas++;
    }



    @Override
    public String toString() {
        return "Jugador{" +
                "nickname='" + nickname + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", partidasGanadas=" + partidasGanadas +
                '}';
    }

    public String toCSVLine() {
        return nickname + ',' + nombre + ',' + apellidos + ',' + edad + "," + partidasGanadas + "\n";
    }
}
