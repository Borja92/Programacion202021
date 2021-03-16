package Persistencia;

import Modelo.Empleado;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SueldoBaseGestor {
    private final static char SEPARADOR=';';

    private String fichero;

    public SueldoBaseGestor(String fichero){
        this.fichero = fichero;
    }

    public Map<Integer,Double> read(){
        String dir = System.getProperty("user.dir");
        Scanner lectorCSV;
        Map<Integer,Double> sueldoBase = new HashMap<>();

        try {
            lectorCSV = new Scanner(new File(dir + File.separator + fichero)).useDelimiter("\n");
            while (lectorCSV.hasNext()){
                String[] campos = lectorCSV.next().split(";");
                int tipoEmpleado = getTipoEmpleadoFromEtiqueta(campos[0]);
                sueldoBase.put(tipoEmpleado,Double.parseDouble(campos[1]));
            }
            lectorCSV.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sueldoBase;
    }

    private int getTipoEmpleadoFromEtiqueta(String etiquetaTipoEmpleado) {
        switch (etiquetaTipoEmpleado){
            case "comisionado": return Empleado.COMISIONADO;
            case "por_horas": return Empleado.POR_HORAS;
            case "asalariado": return Empleado.ASALARIADO;
            default: return -1;
        }
    }

    private String getEtiquetaEmpleadoFromTipo(int tipoEmpleado){
        switch (tipoEmpleado){
            case Empleado.COMISIONADO: return "comisionado";
            case Empleado.ASALARIADO: return "asalariado";
            case Empleado.POR_HORAS: return "por_horas";
        }
        return null;
    }

    public void writeSueldoBase(Map<Integer,Double> sueldosBase){
        try {
            FileWriter fileWriter = new FileWriter(fichero);
            fileWriter.flush();
            for (int tipoEmpleado : sueldosBase.keySet()){
                String etiquetaTipoEmpleado = getEtiquetaEmpleadoFromTipo(tipoEmpleado);
                fileWriter.write(etiquetaTipoEmpleado + ";" + sueldosBase.get(tipoEmpleado) + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

