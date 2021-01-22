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

    public void setPilotoArrayList(ArrayList<Piloto> pilotoArrayList) {
        this.pilotoArrayList = pilotoArrayList;
    }

    public ArrayList<Piloto> getPilotoArrayList() {
        return pilotoArrayList;
    }


  public void añadirPiloto(Piloto piloto, int posicionDeSalida) {

        pilotoArrayList.add(piloto);
    }



   public boolean adelantarPiloto(String nombrePiloto) {
        boolean adelantamientoValido = false;
        int indicePilotoAdelanta=encuentraPiloto(nombrePiloto);
       if (indicePilotoAdelanta>-1& pilotoArrayList.get(indicePilotoAdelanta).isDescalificado()==false){
           adelantamientoValido=true;
Collections.swap(pilotoArrayList,indicePilotoAdelanta-1,indicePilotoAdelanta);

       } else {
           System.out.println("El movimiento es inválido. El piloto no existe, es descalificado o está en primera posición");
       }
       /* Iterator<Piloto> it = pilotoArrayList.iterator();
        while (it.hasNext()) {

            Piloto p = it.next();
            if (p.getNombre() == nombrePiloto & p.isDescalificado() == false) {

                pilotoArrayList.get(Integer.parseInt(p.getNombre() + 1));
                adelantamientoValido = true;
                return adelantamientoValido;
            }
            }*/

        return adelantamientoValido;
    }

    private int encuentraPiloto(String nombre){

        for (int i = 0; i <pilotoArrayList.size() ; i++) {
            if (pilotoArrayList.get(i).getNombre().equalsIgnoreCase(nombre)) return i;
        }
    return -1;
    }

    void descalificarPiloto(String nombrePiloto){
        Piloto p= pilotoArrayList.get(encuentraPiloto(nombrePiloto));
p.setDescalificado(true);
pilotoArrayList.add(p);
pilotoArrayList.remove(pilotoArrayList.indexOf(p));
    }



    boolean retrasarPiloto(String nombrePiloto){
    boolean movimientoValido=false;
       /* Piloto p=pilotoArrayList.get(encuentraPiloto(nombrePiloto));
        int indicePiloto=pilotoArrayList.indexOf(p);

        if (p.isDescalificado()==false){


        }*/

        int posicion=encuentraPiloto(nombrePiloto);
        if (posicion<pilotoArrayList.size()-1 && !pilotoArrayList.get(posicion).isDescalificado()){
            Collections.swap(pilotoArrayList, posicion+1, posicion);
movimientoValido=true;
        }

        return movimientoValido;
    }

    void ordenarPilotosPorNombre() {
        pilotoArrayList.sort(Piloto::compare);
    }

    void ordenarPilotosPorPosicionDeSalida(){
        pilotoArrayList.sort(Piloto::comparaPosicionSalida);
    }
void listarPilotosPorOrdenDeSalidaObviandoDescalificados(ArrayList<Piloto> pilotoArrayList){

    pilotoArrayList.removeIf(Piloto::isDescalificado);
    ordenarPilotosPorPosicionDeSalida();

    /*Iterator<Piloto> it = pilotoArrayList.iterator();
    while (it.hasNext()){

        Piloto p=it.next();
        if (p.isDescalificado()){ it.remove();}
    }*/
    }

    @Override
    public String toString() {
        return "RankingPilotos{" +
                "PilotoArrayList=" + pilotoArrayList +
                '}';
    }


    ////Carga de pilotos


   public static void main(String[] args) {

RankingPilotos rankingPilotos = new RankingPilotos();

       ////Carga de pilotos

      rankingPilotos.añadirPiloto(new Piloto(1 ,"Bottas V." ,"Mercedes", false), 0);
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
       rankingPilotos.añadirPiloto(new Piloto(20 ,"Pérez S.", "Racing Point",false),20);

       //Mostramos la parrilla en orden de entrada de datos
       System.out.println(rankingPilotos.pilotoArrayList);
       System.out.println();
       //Pilotos ordenados según su nombre

       System.out.println("=====Orden Alfabético=====");
       rankingPilotos.ordenarPilotosPorNombre();
       System.out.println(rankingPilotos.pilotoArrayList);
       System.out.println();
//Pilotos ordenados por orden de salida
       System.out.println("=====Orden Posición de Salida=====");

       rankingPilotos.ordenarPilotosPorPosicionDeSalida();
       System.out.println(rankingPilotos.pilotoArrayList);
       System.out.println();
/*El piloto Hamilton L. adelanta dos posiciones hasta la tercera posición y Magnussen K. tres
posiciones hasta la novena.*/
       System.out.println("=====Adelantamientos=====");

       System.out.print("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Hamilton L."));
       System.out.print("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Hamilton L."));

       System.out.print("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Magnussen K."));
       System.out.print("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Magnussen K."));
       System.out.print("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Magnussen K."));
       System.out.println();
       System.out.println(rankingPilotos.pilotoArrayList);
       System.out.println();

//Los pilotos Albon A. y Grosjean R. son descalificados.
       System.out.println("=====Descalificaciones=====");

       rankingPilotos.descalificarPiloto("Albon A.");
       rankingPilotos.descalificarPiloto("Grosjean R.");
       System.out.println(rankingPilotos.pilotoArrayList);

       //Prueba de adelantamieto no válido
       System.out.println("=====Adelantamiento NO Válido=====");

       System.out.println("\n¿Adelantamiento válido?"+rankingPilotos.adelantarPiloto("Grosjean R."));
       System.out.println();

       //Prueba método atrasar piloto
       System.out.println("=====Atrasar Piloto=====");

       rankingPilotos.retrasarPiloto("Kubica R.");
       System.out.println(rankingPilotos);
       System.out.println();
//Listar pilotos en orden de salida, obviando los descalificados
       System.out.println("=====Listar pilotos en orden de salida, obviando los descalificados=====\n");
rankingPilotos.listarPilotosPorOrdenDeSalidaObviandoDescalificados(rankingPilotos.pilotoArrayList);
       System.out.println(rankingPilotos.pilotoArrayList);
       System.out.println();



    }
}