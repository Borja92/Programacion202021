package vista;

import logica.Persona;
import logica.Personas;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Vector;


// El Modelo de la Tabla es el que controla todos los
// datos que se colocan en ella
class ModeloDatos extends AbstractTableModel {
private Persona persona;
private Personas personas= new Personas();

    Vector<String> columnas = new Vector<>();
        columnas.a(Arrays.asList(new String[]{"Nombre", "Edad", "DNI", "Categoria"}));
    Vector<Vector<String>>contenido= new Vector<>();
        for (Persona p: ) {
        contenido.add(new Vector(Arrays.asList(new String[]{p.getNombre(), String.valueOf(p.getEdad()), p.getDni(), String.valueOf(p.getCategoria())})));
    }
    DefaultTableModel modelo = new DefaultTableModel(contenido,columnas);

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }


    // Esta clase imprime los datos en la consola cada vez
    // que se produce un cambio en cualquiera de las
    // casillas de la tabla
    class TablaListener implements TableModelListener {
        public void tableChanged(TableModelEvent evt) {
            for (int i = 0; i < datosPersona.size(); i++) {
                for (int j = 0; j < datosPersona.get(0).getNombre().length(); j++)
                    System.out.print(datosPersona.get(i)[j] + " ");
                System.out.println();
            }
        }
    }

    // Constructor
    ModeloDatos() {
        addTableModelListener(new TablaListener());
    }

    // Devuelve el número de columnas de la tabla
    public int getColumnCount() {
        return (datosPersona.size());
    }

    // Devuelve el número de filas de la tabla
    public int getRowCount() {
        return (datosPersona.size());
    }

    // Devuelve el valor de una determinada casilla de la tabla
    // identificada mediante fila y columna
    public Object getValueAt(int fila, int col) {
        return (datosPersona.get(fila)[col]);
    }

    // Cambia el valor que contiene una determinada casilla de
    // la tabla
    public void setValueAt(Object valor, int fila, int col) {
        //datosPersona.get(fila)[col] = valor;
        datosPersona.get(fila) = (Persona) valor;
        // Indica que se ha cambiado
        fireTableDataChanged();
    }

    // Indica si la casilla identificada por fila y columna es
    // editable
    public boolean isCellEditable(int fila, int col) {
        return (true);
    }


    public static class java1416 extends JPanel {
        public java1416() {
            setLayout(new BorderLayout());
            JTable tabla = new JTable(new ModeloDatos());
            // La tabla se añade a un ScrollPane para que sea éste el
            // que controle automáticamente en tamaño de la tabla,
            // presentando una barra de desplazamiento cuando sea
            // necesario
            JScrollPane panel = new JScrollPane(tabla);
            add(panel, BorderLayout.CENTER);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent evt ) {
                System.exit( 0 );
            }
        } );
        frame.getContentPane().add( new java1416(),BorderLayout.CENTER );
        frame.setSize( 200,200 );
        frame.setVisible( true );
    }



}

