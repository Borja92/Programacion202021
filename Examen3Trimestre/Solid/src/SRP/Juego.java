package SRP;

public class Juego {
    public void login(){}
    public void logout(){}
    public void disparar(){}
    public void mover(){    }
    public void descansar(){}
    public void getPuntuacion(){}
    public void getNombre(){}
/*
Incumple SRP ya que en una misma clase se implementan funcionalidades que no tienen cohesión entre sí, pudiendonos
    dificultar la ampliación del software, siendo predecible el código spagueti
La solución sería, crear nuevas clases especialistas que se encarguen por ejemplo, de acciones del jugador, la sesión
de juego (conexión o desconexión del servidor de la partida) o manejar la información del objeto jugador (vida, nombre,
puntuación, etc...)

*/

}
