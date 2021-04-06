/**
 * Clase Rentacar
 *
 * @author A. Borja Badía Checa
 * @version 1.0
 */


import Modelo.Alquiler;
import Modelo.Vehiculo;
import Persistencia.LectorAlquileres;
import Persistencia.LectorVehiculos;

import java.util.ArrayList;
import java.util.List;

public class Rentacar {
    private List<Vehiculo> vehiculos;
    private List<Alquiler> alquileres;
    LectorVehiculos lectorVehiculos=new LectorVehiculos("coches.csv");
    LectorAlquileres lectorAlquileres= new LectorAlquileres("rent.xml");
    /**
     * Constructor carga en las listas
     */
    public Rentacar(){
   // LectorVehiculos lectorVehiculos=new LectorVehiculos("coches.csv");
    vehiculos=lectorVehiculos.getVehiculos();
    alquileres=lectorAlquileres.getListaAlquileres();
}

//Métodos
/*carga la información del archivo coches.csv en la lista vehiculos;
    devuelve true si se ha podido abrir el archivo y false en caso contrario. La lista de coches
    sólo contendrá la información de este archivo.*/

    boolean leerModelos(){
if (lectorVehiculos != null){
    return true;
        } else return false;
    }
    /*boolean leerAlquileres(): carga la información del archivo rent.xml en la lista de alquileres;
    devuelve true si se ha podido abrir el archivo y false en caso contrario. La lista de alquileres
    sólo contendrá la información de este archivo.
    Para la lectura de los datos debes implementar la clase*/
    boolean leerAlquileres(){
if (lectorAlquileres!=null){
    return true;
}else
    return false;
    }
//Devuelve la lista vehículos
    List<Vehiculo> getVehiculos(){

        return vehiculos;
    }
//Devuelve la lista alquileres
    List<Alquiler> getAlquileres(){

        return alquileres;
    }

    //void ordenar(): ordena la lista de alquileres por orden de fecha (menor a mayor). (0,5 pts.)
    void ordenar(){

        for (Alquiler alquiler:getAlquileres()) {

        }
    }
    /*List<Alquiler> buscar(int codigo): dado un código de vehiculo, devuelve una lista de
    alquileres de ese vehículo. (1 ptp.)*/
    List<Alquiler> buscar(int codigo){
       List<Alquiler> listaAlquilerDeVehiculo= new ArrayList<>();
        for (Alquiler alquiler: getAlquileres()) {
            if (alquiler.getCodigo()==codigo){
                listaAlquilerDeVehiculo.add(alquiler);
            }
        }
        return listaAlquilerDeVehiculo;
    }


    /*double calcular(int codigo): dado un código de vehiculo, devuelve el importe total
    registrado de todos los alquileres de ese vehículo. (1 pto.)*/

    double calcular(int codigo){
double totalPrecio=0.0;
int diasAlquilado=0;
        for (Alquiler alquiler:getAlquileres()) {
            if (alquiler.getCodigo()==codigo){
                diasAlquilado+=alquiler.getDias();
            }
        }
        for (Vehiculo vehiculo:getVehiculos()) {
            if (vehiculo.getCodigo()==codigo){
                totalPrecio=diasAlquilado*vehiculo.getPrecio();
            }
        }

        return totalPrecio;
    }
    /*List<Vehiculo> mostrar(String fecha): dada una fecha devolver una lista de los vehiculos
    alquilados en esa fecha. (1 pto.)*/

    List<Vehiculo> mostrar(String fecha){
        List<Vehiculo> listaVehiculosAlquiladosEnFecha= new ArrayList<>();
        //Vehiculo vehiculo= new Vehiculo();
       int codigoCoche;
        for (Alquiler alquiler:getAlquileres()) {
            if (alquiler.getFecha().equalsIgnoreCase(fecha)){
                codigoCoche=alquiler.getCodigo();
                for (Vehiculo v:getVehiculos()) {
                    if (codigoCoche==v.getCodigo()){
                        listaVehiculosAlquiladosEnFecha.add(v);
                    }
                }
            }
        }
        return listaVehiculosAlquiladosEnFecha;
    }

    public static void main(String[] args) {

        /*NOTA: El código que se ejecutará para probar el programa es el siguiente:
        Rentacar rentacar = new Rentacar();
        rentacar.leerModelos();
        System.out.println(rentacar.getVehiculos());
        rentacar.leerAlquileres();
        System.out.println(rentacar.getAlquileres());
        rentacar.ordenar();
        System.out.println(rentacar.getAlquileres());
        System.out.println(rentacar.buscar(1));
        System.out.println(rentacar.calcular(1));
        System.out.println(rentacar.mostrar("2021/03/14"));*/
        Rentacar rentacar = new Rentacar();
        rentacar.leerModelos();
        System.out.println(rentacar.getVehiculos());
        rentacar.leerAlquileres();
        System.out.println(rentacar.getAlquileres());
        rentacar.ordenar();
        System.out.println(rentacar.getAlquileres());
        System.out.println(rentacar.buscar(1));
        System.out.println(rentacar.calcular(1));
        System.out.println(rentacar.mostrar("2021/03/14"));

    }

}
