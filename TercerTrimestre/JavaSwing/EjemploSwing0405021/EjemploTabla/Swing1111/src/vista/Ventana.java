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
    private JTable tblPersonas;
    private JButton btnNuevo;

    public Ventana(Personas personas) {




        ModeloTablaPersonas modeloTablaPersonas = new ModeloTablaPersonas(personas);
        tblPersonas.setModel(modeloTablaPersonas);

        /*for (String categoria: Persona.getCategorias())
            cmbCategoria.addItem(categoria);

        btnAddPersona.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int edad = (int) spnEdad.getValue();
                String dni = txtDni.getText();
                int categoria = Persona.getCategoriaByTag((String) cmbCategoria.getSelectedItem());
                Persona persona = new Persona(nombre, edad, dni, categoria);
                modeloTablaPersonas.addRow(persona);
            }
        });*/

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloTablaPersonas.removeRow(tblPersonas.getSelectedRow());
            }
        });
btnNuevo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
});
    }

    public JPanel getPanel(){
        return pnlMain;
    }
}
