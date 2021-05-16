import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JComboBox {
    private JPanel panel;
    private javax.swing.JComboBox cmbBox;
    private JTextField txtFieldElementoSeleccionado;
    private List<String> miLista;
    private final String[] opciones = new String[]{"Opción A", "Opción B", "Opción C"};

    public JComboBox() {
        this.miLista = new ArrayList<>();
fillComboBox();
cmbBox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
txtFieldElementoSeleccionado.setText(cmbBox.getSelectedItem().toString());
    }
});
    }

private void fillComboBox(){

    for (String s:opciones) {
        cmbBox.addItem(s);
    }
    }


    public JPanel getPanel() {
        return panel;
    }
}
