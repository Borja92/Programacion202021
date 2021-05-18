package Negocio;

import Modelo.Coche;

import java.util.ArrayList;
import java.util.List;

public class Catalogo implements CatalogoSinIncrementoPrecio{
    private List<Coche> coches;

    public Catalogo(){
        coches = new ArrayList<>();
    }

    public void add(Coche coche){
        coches.add(coche);
    }

    public Coche getCocheByMatricula(String matricula){
        for (Coche coche: coches){
            if (coche.getMatricula().equals(matricula))
                return coche;
        }
        return null;
    }

    public List<Coche> getAll(){
        return coches;
    }

    public void incrementoPrecio(double porcentaje){
        for (Coche coche : coches)
            coche.setPrecio(coche.getPrecio() * (1+porcentaje));
    }


}
