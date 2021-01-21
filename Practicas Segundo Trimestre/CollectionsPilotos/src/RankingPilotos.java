import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RankingPilotos {

    private ArrayList<Piloto> pilotoArrayList;

    public RankingPilotos(ArrayList<Piloto> pilotoArrayList) {
        this.pilotoArrayList = pilotoArrayList;
    }

    public RankingPilotos() {
        pilotoArrayList = new ArrayList<>();;
    }

    void añadirPiloto(Piloto piloto, int posicionDeSalida) {

        pilotoArrayList.add(posicionDeSalida, piloto);
    }

    boolean adelantarPiloto(String nombrePiloto) {
        boolean adelantamientoValido = false;

        Iterator<Piloto> it = pilotoArrayList.iterator();
        while (it.hasNext()) {

            Piloto p = it.next();
            if (p.getNombre() == nombrePiloto & p.isDescalificado() == false) {

                pilotoArrayList.get(Integer.parseInt(p.getNombre() + 1));
                adelantamientoValido = true;
                return adelantamientoValido;
            }
        }
        return adelantamientoValido;
    }
  /*  boolean retrasarPiloto(String nombrePiloto){}
    void descalificarPiloto(String nombrePiloto){}
    void ordenarPilotosPorPosicionDeSalida(){}*/

    void ordenarPilotosPorNombre() {
        pilotoArrayList.sort(Piloto::compare);
    }


    @Override
    public String toString() {
        return super.toString();
    }


////Carga de pilotos

   /* añadirPiloto(new Piloto(1 ,"Bottas V." ,"Mercedes", false), 0);
       rankingPilotos.añadirPiloto(new Piloto(2 ,"Vettel S.","Ferrari", false),0);
        rankingPilotos.añadirPiloto(new Piloto(3 ,"Verstappen M.", "Red Bull", false),0);
        rankingPilotos.añadirPiloto(new Piloto(4 ,"Leclerc C.","Ferrari",false),4);
        rankingPilotos.añadirPiloto(new Piloto(5 ,"Hamilton L.", "Mercedes",false),5);
        rankingPilotos.añadirPiloto(new Piloto(6 ,"Albon A.", "Red Bull",false),6);
        rankingPilotos.añadirPiloto(new Piloto(7 ,"Sainz Jr. C.", "McLaren",false),7);
        rankingPilotos.añadirPiloto(new Piloto(8 ,"Norris L.", "McLaren",false),8);
        rankingPilotos.añadirPiloto(new Piloto(9 ,"Ricciardo D.", "Renault",false),9);
        rankingPilotos.añadirPiloto(new Piloto( 10 ,"Gasly P.","Toro Rosso",false),10);
        rankingPilotos.añadirPiloto(new Piloto(11 ,"Hülkenberg N.", "Renault",false),11);
        rankingPilotos.añadirPiloto(new Piloto(12 ,"Magnussen K.", "Haas",false),12);
        rankingPilotos.añadirPiloto(new Piloto(13 ,"Kvyat D.","Toro Rosso",false),13);
        rankingPilotos.añadirPiloto(new Piloto(14 ,"Stroll L.", "Racing Point",false),14);
        rankingPilotos.añadirPiloto(new Piloto(15 ,"Grosjean R.", "Haas",false),15);
        rankingPilotos.añadirPiloto(new Piloto(16 ,"Giovinazzi A.", "Alfa Romeo",false),16);
        rankingPilotos.añadirPiloto(new Piloto(17 ,"Räikkönen K.", "Alfa Romeo",false),17);
        rankingPilotos.añadirPiloto(new Piloto(18 ,"Russel G.", "Williams",false),18);
        rankingPilotos.añadirPiloto(new Piloto(19 ,"Kubica R.", "Williams",false),19);
        rankingPilotos.añadirPiloto(new Piloto(20 ,"Pérez S.", "Racing Point",false),20);*/

   RankingPilotos

}
