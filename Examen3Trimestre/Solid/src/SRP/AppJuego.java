package SRP;

public class AppJuego {
    public static void main(String[] args) {
        /* Incumple SRP
        Juego juego=null;
        juego.descansar();
        juego.disparar();
        juego.mover();
        juego.getNombre();
        juego.getPuntuacion();
        juego.login();
        juego.logout();
        */

        //Cumplieando SRP
        AccionesJugador accionesJugador= new AccionesJugador();
        Jugador jugador1= new Jugador("Player1",0);
        SesionJuego sesionJuego= new SesionJuego();

        sesionJuego.login(jugador1);
        accionesJugador.mover(jugador1);
        accionesJugador.disparar(jugador1);
        jugador1.setPuntuacion(28);
        System.out.println(jugador1.getPuntuacion());
        System.out.println(jugador1.getNombre());
        sesionJuego.logout(jugador1);
    }
}
