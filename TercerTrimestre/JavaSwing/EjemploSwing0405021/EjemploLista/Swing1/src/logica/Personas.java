package logica;

import java.util.ArrayList;
import java.util.List;

public class Personas {
    private List<Persona> personas;

    public Personas(){
        personas = new ArrayList<>();
    }

    public boolean add(Persona persona){
        return personas.add(persona);
    }

    public List<Persona> getAll(){
        return personas;
    }

    public boolean remove(int pos) {
        return personas.remove(pos) != null;
    }

    public boolean removeByDNI(String dni) {
        return personas.removeIf(p -> (p.getDni().equals(dni)));
    }
}
