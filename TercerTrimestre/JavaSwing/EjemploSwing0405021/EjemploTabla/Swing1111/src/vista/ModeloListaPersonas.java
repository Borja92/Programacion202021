package vista;

import logica.Persona;
import logica.Personas;

import javax.swing.*;

public class ModeloListaPersonas extends AbstractListModel<Persona> {

    private Personas personas;

    public ModeloListaPersonas(Personas personas){
        this.personas = personas;
    }

    @Override
    public int getSize() {
        return personas.getAll().size();
    }

    @Override
    public Persona getElementAt(int index) {
        System.out.println(index);
        return personas.getAll().get(index);
    }

    public boolean addElement(Persona persona){
        boolean added = personas.add(persona);
        if (added)
            fireIntervalAdded(this,personas.getAll().size()-1,personas.getAll().size()-1);
        return added;
    }

    public boolean remove(int pos){
        boolean removed = personas.remove(pos);
        if (removed)
            fireIntervalRemoved(this,pos,pos);
        return removed;
    }
}
