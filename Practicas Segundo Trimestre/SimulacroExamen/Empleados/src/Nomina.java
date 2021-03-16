import Modelo.Empleado;
import Persistencia.EmpleadosGestor;
import Persistencia.SueldoBaseGestor;

import java.util.*;

public class Nomina {
    private final static String ARCHIVO_EMPLEADOS="empleados.xml";
    private final static String ARCHIVO_SUELDO_BASE="sueldo_base.csv";
    private List<Empleado> empleados;
    private Map<Integer,Double> sueldosBase;


    void cargarEmpleados(){
        SueldoBaseGestor sueldoBaseGestor= new SueldoBaseGestor(ARCHIVO_SUELDO_BASE);
        sueldosBase=sueldoBaseGestor.read();

        EmpleadosGestor empleadosGestor = new EmpleadosGestor(ARCHIVO_EMPLEADOS);

        empleados=empleadosGestor.read();

        asignarSueldosBase(sueldosBase, empleados);

    }

    public List<Empleado> getEmpleados(){

        return empleados;
    }


    public double calcularSueldo(int idEmpleado){
        for (Empleado empleado: empleados) {
            if (empleado.getId()==idEmpleado){
                return  empleado.getSueldo();
            }
        }
        throw new NoSuchElementException("No se encuentra el empleado");
    }

    public void cambiarSueldoBase(int tipoEmpleado, double sueldo){
        sueldosBase.replace(tipoEmpleado,sueldo);
        for (Empleado empleado: empleados)
            if (empleado.getTipo() == tipoEmpleado)
                empleado.setSueldoBase(sueldo);
    }

  public   void guardarSueldoBase(){
        SueldoBaseGestor sueldoBaseGestor= new SueldoBaseGestor(ARCHIVO_SUELDO_BASE);
        sueldoBaseGestor.writeSueldoBase(sueldosBase);

    }

 public    Empleado getEmpleadoMejorPagado(){
ordenarEmpleadosPorSueldo();
        return empleados.get(0);
    }
    Empleado getEmpleadoPeorPagado(){
ordenarEmpleadosPorSueldo();
        return empleados.get(empleados.size()-1);
    }


    private void asignarSueldosBase(Map<Integer, Double> sueldoBase, List<Empleado> empleados) {
        for (Empleado empleado:empleados  ) { //Este método asigna a cada empleado su sueldo base por tipo de empleado
            empleado.setSueldoBase(sueldoBase.get(empleado.getTipo()));
        }

    }
    private void ordenarEmpleadosPorSueldo(){
        Collections.sort(empleados,new Comparator<Empleado>(){
            @Override
            public int compare(Empleado empleado1, Empleado empleado2) {
                if (empleado1.getSueldo() < empleado2.getSueldo()) return 1;
                else if (empleado1.getSueldo() > empleado2.getSueldo()) return -1;
                else return 0;
            }
        });
    }
}
