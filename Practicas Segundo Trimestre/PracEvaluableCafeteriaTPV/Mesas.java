import java.util.ArrayList;

public class Mesas {

    public ArrayList<Mesa> mesaArrayList = new ArrayList<>();

    public void annadirMesa (String codigoMesa, boolean mesaAbierta){
        mesaArrayList.add(new Mesa(codigoMesa,mesaAbierta));
        System.out.println("Mesa añadida");
    }



    public void listarMesas(Mesas mesas){
        for (Mesa m:mesaArrayList) {
            System.out.println(m+"\n");
        }
    }

    public void mostrarMesasAbiertas(Mesas mesas) {

        System.out.print("Mesas abiertas: ");
        for (Mesa m: mesaArrayList) {
            if(m.isMesaAbierta()){
                System.out.print("["+m.getCodigoMesa()+"] ");
            }
        }
        System.out.println();
        System.out.println();

    }
    public void mostrarMesasCerradas(Mesas mesas){
        System.out.print("Mesas cerradas: ");
        for (Mesa m: mesaArrayList){
            if(!m.isMesaAbierta()){
                System.out.print("["+m.getCodigoMesa()+"] ");
            }
        }
        System.out.println();
        System.out.println();

    }

    public Mesa elegirMesaAFacturar (String codMesa){
        Mesa mesaElegida = new Mesa();
        for (Mesa m: mesaArrayList) {
            if(m.getCodigoMesa().equalsIgnoreCase(codMesa)){

                mesaElegida=m;
            }
        }
        return mesaElegida;
    }


    /*public void abrirMesa(String codMesa){
        Mesa mesaElegida= new Mesa();
        for (Mesa m:mesaArrayList) {
            if(m.getCodigoMesa().equalsIgnoreCase(codMesa))
                mesaElegida=m;
            m.setMesaAbierta(true);
        }
        System.out.println("La mesa"+mesaElegida+"ahora está abierta.");
    }*/
}
