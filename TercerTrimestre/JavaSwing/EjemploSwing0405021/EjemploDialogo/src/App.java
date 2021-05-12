import logica.Persona;
import logica.Personas;
import vista.Ventana;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Personas personas = new Personas();

        personas.add(new Persona("nombre1",20,"1A",Persona.ASALARIADO));
        personas.add(new Persona("nombre2",21,"2B",Persona.COMISIONADO));
        personas.add(new Persona("nombre3",22,"3C",Persona.POR_HORAS));


        Ventana ventana = new Ventana(personas);

        JFrame frame = new JFrame("Ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(ventana.getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
