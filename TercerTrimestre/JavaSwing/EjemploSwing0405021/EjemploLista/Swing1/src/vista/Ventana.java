package vista;

import logica.Persona;
import logica.Personas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

public class Ventana {
    private JPanel pnlMain;
    private JButton btnAddPersona;
    private JButton btnMostrarPersonas;
    private JTextField txtNombre;
    private JSpinner spnEdad;
    private JTextField txtDni;
    private JTextField txtField;
    private JComboBox cmbCategoria;
    private JButton btnBorrar;
    private Personas personas;

    public Ventana(Personas personas) {
        this.personas = personas;
        Vector<String> columnas = new Vector<>();
        columnas.addAll(Arrays.asList(new String[]{"Nombre", "Edad", "DNI", "Categoria"}));
        Vector<Vector<String>>contenido= new Vector<>();
        for (Persona persona:personas.getAll() ) {
            contenido.add(new Vector(Arrays.asList(new String[]{persona.getNombre(), String.valueOf(persona.getEdad()), persona.getDni(), String.valueOf(persona.getCategoria())})));
        }
        DefaultTableModel modelo = new DefaultTableModel(contenido,columnas);


        /*DefaultListModel<Persona> modeloLista = new DefaultListModel<>();
        for (Persona persona: personas.getAll())
            modeloLista.addElement(persona);*/
        ModeloListaPersonas modeloLista = new ModeloListaPersonas(personas);
        ListaRenderer listRenderer = new ListaRenderer();


        for (String categoria: Persona.getCategorias())
            cmbCategoria.addItem(categoria);

        btnAddPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int edad = (int) spnEdad.getValue();
                String dni = txtDni.getText();
                int categoria = Persona.getCategoriaByTag((String) cmbCategoria.getSelectedItem());
                Persona persona = new Persona(nombre, edad, dni, categoria);
                modeloLista.addElement(persona);
                System.out.println(personas.getAll());
            }
        });

    }




    public boolean isCellEditable(int row, int colum){
        return false;
    }

    public JPanel getPanel(){
        return pnlMain;
    }
}
