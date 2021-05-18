package Negocio;

import Modelo.Coche;

import java.util.List;

public interface CatalogoSinIncrementoPrecio {
    public void add(Coche coche);
    public Coche getCocheByMatricula(String matricula);
    public List<Coche> getAll();
}
