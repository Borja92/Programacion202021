/*

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
public class AppBrisca {


        HashMap<String, Jugadores> partidas;

        final String filename = "datosPartidas.csv";


        public AppBrisca()
        {
            partidas = new HashMap<String, Jugadores>();
        }

        public void cargarDatos(String archivo) throws FileNotFoundException {

            File fichero = new File(archivo);

            Scanner lectorF;
            String linea;

            lectorF = new Scanner(fichero);

            while (lectorF.hasNextLine()){
                linea = lectorF.nextLine();
                String [] jugador = linea.split(",");
                partidas.put(jugador[0],new Jugadores(jugador[0],jugador[1],jugador[2],Integer.parseInt(jugador[3]),Integer.parseInt(jugador[4])));
            }

            lectorF.close();

        }

        public void guardarDatos(String archivo) throws IOException {

            FileWriter fichero = new FileWriter(archivo);

            for (String nick  : partidas.keySet())
            {
                fichero.write(partidas.get(nick).toCSVLine());
            }

            fichero.close();
        }

        public void anotarResultado(String nombre)
        {
            this.partidas.get(nombre).anotarVIctoria();
        }

        public int partidasJugadas()
        {
            int cont=0;
            for (String nick  : partidas.keySet())
            {
                cont += partidas.get(nick).getPartidasGanadas();
            }
            return cont;
        }

        public Jugadores ganador()
        {
            String ganador="";
            int mayor=-1;
            for (String nick  : partidas.keySet())
            {
                if (partidas.get(nick).getPartidasGanadas()>mayor) {
                    ganador=nick;
                    mayor = partidas.get(nick).getPartidasGanadas();
                }
            }
            return partidas.get(ganador);
        }

    public static void main(String[] args) throws IOException {
AppBrisca campeonato = new AppBrisca();

campeonato.partidas.toString();
campeonato.cargarDatos("datosPartidas.csv");
        campeonato.anotarResultado("jesfly");
        campeonato.anotarResultado("harry");
        campeonato.anotarResultado("jesfly");
        campeonato.anotarResultado("jesfly");
        campeonato.anotarResultado("Peter");
        campeonato.anotarResultado("jesfly");
        campeonato.anotarResultado("Mary");
        campeonato.anotarResultado("Mary");
        campeonato.anotarResultado("jesfly");

        System.out.println("Partidas juadas hasta el momento = " + campeonato.partidasJugadas());

        System.out.println("El Jugadores en primera posición del campeonato es "+campeonato.ganador().getNombre()+campeonato.ganador().getApellidos());



        campeonato.guardarDatos(campeonato.filename);

    }
}
*/
