import java.util.ArrayList;

public class AdmonUrgencias {
ListaEsperaPacientes listaEsperaPacientes= new ListaEsperaPacientes();

    void  administrarOrdenPacientes(Paciente paciente){

        if (paciente.isIncidenciaGravedad()){
            listaEsperaPacientes.pacientesGraves.add(paciente);
        } else {
            listaEsperaPacientes.pacientesNoGraves.add(paciente);
        }
    }

    void registrarPaciente(Paciente p){
      Paciente nuevoPaciente = new Paciente();
     p=nuevoPaciente;
   //  administrarOrdenPacientes(p);

    if (p.isIncidenciaGravedad()){

        listaEsperaPacientes.pacientesGraves.add(p);
    }
    if (!p.isIncidenciaGravedad()){
        listaEsperaPacientes.pacientesNoGraves.add(p);
    }
    }

    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        AdmonUrgencias admonUrgencias= new AdmonUrgencias();
     ListaEsperaPacientes listaEsperaPacientes = new ListaEsperaPacientes();
        ArrayList<Paciente> pacientesGraves = new ArrayList<>();
        ArrayList<Paciente> pacientesNoGraves= new ArrayList<>();

Paciente paciente1= new Paciente("P1", 28, 5, false);
Paciente paciente2= new Paciente("P2", 56, 1, false);
Paciente paciente3= new Paciente("P3", 48, 6, false);
Paciente paciente4= new Paciente("P4", 78, 8, true);
Paciente paciente5= new Paciente("P1", 17, 2, false);

        admonUrgencias.administrarOrdenPacientes(paciente1);
admonUrgencias.registrarPaciente(paciente2);
        //System.out.println(listaEsperaPacientes.recorrerListas(listaEsperaPacientes.pacientesGraves));
        System.out.println(listaEsperaPacientpacientesNoGraves);
        System.out.println(listaEsperaPacientes.pacientesGraves);

    }



}
