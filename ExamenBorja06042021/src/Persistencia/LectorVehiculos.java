package Persistencia;

import Modelo.Vehiculo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorVehiculos {
    private final static char SEPARADOR = ';';

    private ArrayList<Vehiculo> vehiculoArrayList=new ArrayList<>();

    public LectorVehiculos(String fichero){


    String dir=System.getProperty("user.dir");
    Scanner lectorCSV;

    try {
        lectorCSV= new Scanner(new File(dir+File.separator+fichero)).useDelimiter("\n");

        while (lectorCSV.hasNext()){
            String[] campos= lectorCSV.next().split(";");
            vehiculoArrayList.add(new Vehiculo(Integer.parseInt(campos[0]),campos[1],Double.parseDouble(campos[2])));
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
//Devuelve la lista vehículos
    public List<Vehiculo> getVehiculos(){
        return vehiculoArrayList;
    }




}
