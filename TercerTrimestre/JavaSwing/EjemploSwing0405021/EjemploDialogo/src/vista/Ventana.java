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
    private JButton btnBorrar;
    private JTable tblPersonas;
    private JButton btnNuevo;
    private Personas personas;
    private Ventana estaVentana;
    ModeloTablaPersonas modeloTablaPersonas;

    public Ventana(Personas personas) {
        this.personas = personas;
        this.estaVentana = this;

        modeloTablaPersonas = new ModeloTablaPersonas(personas);
        tblPersonas.setModel(modeloTablaPersonas);

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloTablaPersonas.removeRow(tblPersonas.getSelectedRow());
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogoNuevaPersona dialogo = new DialogoNuevaPersona();
                if (dialogo.okPressed())
                    modeloTablaPersonas.addRow(dialogo.getPersona());
                dialogo.dispose();
                System.out.println(personas.getAll());
            }
        });

    }

    public JPanel getPanel(){
        return pnlMain;
    }
}
