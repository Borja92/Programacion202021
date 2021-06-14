package vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoCambiarNombre extends JDialog {
    private JPanel contentPane;
    private JTextField textNombreJugador;
    private JButton buttonOk;
    private JButton buttonCancel;
    private boolean okPressed = false;
    private String nuevoNombre;

    public DialogoCambiarNombre() {
        setContentPane(contentPane);
        setModal(true);
        pack();
        //setVisible(true);
        getRootPane().setDefaultButton(buttonOk);


        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


    }

    private void onOK() {
 nuevoNombre= textNombreJugador.getText();
        okPressed = true;
        setVisible(false);
    }

    private void onCancel() {
        // add your code here if necessary
        setVisible(false);
    }

    public boolean okPressed(){
        return okPressed;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }
}