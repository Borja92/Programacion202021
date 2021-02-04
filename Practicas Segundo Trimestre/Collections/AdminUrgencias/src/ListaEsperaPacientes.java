import java.util.ArrayList;
import java.util.Iterator;

public class ListaEsperaPacientes {

     ArrayList<Paciente> pacientesGraves = new ArrayList<>();
     ArrayList<Paciente> pacientesNoGraves= new ArrayList<>();

    public ListaEsperaPacientes() {
        this.pacientesGraves = pacientesGraves;
        this.pacientesNoGraves = pacientesNoGraves;
    }

    ArrayList recorrerListas(ArrayList<Paciente> pacienteArrayList){

        Iterator<Paciente> iterator=pacienteArrayList.iterator();

        while (iterator.hasNext()){

            System.out.println(iterator.next());

        }
        return pacienteArrayList;
    }

    @Override
    public String toString() {
        return "ListaEsperaPacientes{" +
                "Pacientes Graves=" + pacientesGraves +
                ", Pacientes No Graves=" + pacientesNoGraves +
                '}';
    }
}
