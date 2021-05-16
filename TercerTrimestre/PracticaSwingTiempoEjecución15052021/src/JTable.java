import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class JTable {
    private JPanel panel;
    private javax.swing.JTable tbl;
    private JButton cargarDatosBtn;
    private JButton mostrarContenidoBtn;
    private JSpinner filaSpn;
    private JSpinner columnaSpn;
    private JTextField valorTxt;
    private JTextField txtCelda;
    private JButton btnCrearFila;
    private JButton btnBorrarFila;

    public JTable() {
        Vector<String> columnas = new Vector<>();
        columnas.addAll(Arrays.asList(new String[]{"Modelo", "Sección", "Tipo", "Elemento"}));
        Vector<Vector<String>> contenido = new Vector();
        contenido.add(new Vector(Arrays.asList(new String[]{"C1001", "Cocina", "Silla", "sc2011"})));
        contenido.add(new Vector(Arrays.asList(new String[]{"S2002", "Salón", "Mesa", "ms1001"})));
        contenido.add(new Vector(Arrays.asList(new String[]{"B1011", "Baño", "Armario", "ab4102"})));

        DefaultTableModel modelo = new DefaultTableModel(contenido, columnas) {

            public boolean isCellEditable(int row, int column) {
                if (column == 1) {
                    return false;
                } else return true;
            }
        };


        mostrarContenidoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = (int) filaSpn.getValue();
                int columna = (int) columnaSpn.getValue();
                valorTxt.setText(String.valueOf(tbl.getModel().getValueAt(fila, columna)));
                System.out.println("'Mostrar Contenido' pulsado: \n"+modelo.getDataVector().toString());

            }
        });

        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int columna = e.getColumn();
                int fila = e.getFirstRow();
                valorTxt.setText((String)
                        modelo.getDataVector().get(fila).get(columna));
                txtCelda.setText("fila: " + fila + ", columna: " + columna);
            }
        });

btnCrearFila.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.addRow(new Object[]{"","","",""});

    }
});

btnBorrarFila.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int[] filasSeleccionadas= tbl.getSelectedRows();
        for (int i = filasSeleccionadas.length-1; i >=0 ; i--) {
            System.out.println(filasSeleccionadas[i]);
            modelo.removeRow(filasSeleccionadas[i]);
        }
    }
});


        tbl.setModel(modelo);
    }

    public JPanel getPanel() {
        return panel;
    }
}
