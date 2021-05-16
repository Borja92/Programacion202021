import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JList {
    private JPanel panel;
    private javax.swing.JList lst;

    public JList(){

        String[] cadenas= new String[]{"Cadena1","Cadena2","Cadena3"};

        DefaultListModel<String> modelo= new DefaultListModel<>();
        for (String cadena:cadenas ) {
            modelo.addElement(cadena);
        }
        lst.setModel(modelo);
lst.addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println(lst.getSelectedValuesList().toString());
    }
});
    }


    public JPanel getPanel() {
        return panel;
    }
}
