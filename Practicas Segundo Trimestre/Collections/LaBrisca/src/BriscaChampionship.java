import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BriscaChampionship {

    HashMap<String, Jugador> partidas;

    final String filename = "datos.csv";


    public BriscaChampionship()
    {
        partidas = new HashMap<String, Jugador>();
    }

    public void cargarDatos(String archivo) throws FileNotFoundException {

        File fichero = new File(archivo);

        Scanner lectorF;
        String linea;

        lectorF = new Scanner(fichero);

        while (lectorF.hasNextLine()){
            linea = lectorF.nextLine();
            String [] jugador = linea.split(",");
            partidas.put(jugador[0],new Jugador(jugador[0],jugador[1],jugador[2],Integer.parseInt(jugador[3]),Integer.parseInt(jugador[4])));
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
        this.partidas.get(nombre).anotarVictoria();
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

    public Jugador ganador()
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

        BriscaChampionship campeonato = new BriscaChampionship();

        campeonato.cargarDatos(campeonato.filename);

        System.out.println(campeonato.partidas.toString());

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

        System.out.println("El Jugadores en primera posición del campeonato es "+campeonato.ganador().getNombreApellido());



        campeonato.guardarDatos(campeonato.filename);



    }


}
