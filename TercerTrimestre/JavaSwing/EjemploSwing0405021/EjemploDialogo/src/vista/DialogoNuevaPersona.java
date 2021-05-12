package vista;

import logica.Persona;
import logica.Personas;

import javax.swing.*;
import java.awt.event.*;

public class DialogoNuevaPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JSpinner spnEdad;
    private JTextField txtDni;
    private JComboBox cmbCategoria;
    private Persona persona;
    private boolean okPressed = false;

    public DialogoNuevaPersona() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        for (String categoria : Persona.getCategorias())
            cmbCategoria.addItem(categoria);

        pack();
        setVisible(true);
    }

    private void onOK() {
        persona = new Persona(txtNombre.getText(),(int) spnEdad.getValue(),txtDni.getText(),Persona.getCategoriaByTag((String) cmbCategoria.getSelectedItem()));
        okPressed = true;
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        setVisible(false);
    }

    public Persona getPersona(){
        return persona;
    }

    public boolean okPressed(){
        return okPressed;
    }
}
