package vista;

import logica.Persona;
import logica.Personas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaPersonas extends AbstractTableModel {
    private Personas personas;
    private String[] columnas = new String[]{"Nombre","Edad","DNI","Categoría"};
    private Class<?>[] clasesColumnas = new Class<?>[]{String.class,Integer.class,String.class,String.class};

    public ModeloTablaPersonas(Personas personas){
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
        return personas.getAll().size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = personas.getAll().get(rowIndex);
        switch (columnIndex){
            case 0:    // Nombre
                return persona.getNombre();
            case 1:    // Edad
                return persona.getEdad();
            case 2:    // DNI
                return persona.getDni();
            case 3:
                return Persona.getTagCategoria(persona.getCategoria());
        }
        return null;
    }

    public String getColumnName(int column){
        return columnas[column];
    }

    public Class<?> getColumnClass(int columnIndex){
        return clasesColumnas[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

    public void setValueAt(Object aValue,int rowIndex,int columnIndex){
        Persona persona = personas.getAll().get(rowIndex);
        switch(columnIndex){
            case 0: // Nombre
                persona.setNombre((String) aValue);
                break;
            case 1: // Edad
                persona.setEdad((int) aValue);
                break;
            case 2: // DNI
                persona.setDni((String) aValue);
                break;
            case 3: // Categoría
                persona.setCategoria(Persona.getCategoriaByTag((String) aValue));
        }
        fireTableCellUpdated(rowIndex,columnIndex);
        System.out.println(personas.getAll());
    }

    public void removeRow(int row){
        personas.remove(row);
        fireTableRowsDeleted(row,row);
        System.out.println(personas.getAll());
    }

    public void addRow(Persona persona){
        personas.add(persona);
        fireTableRowsInserted(personas.getAll().size()-1,personas.getAll().size()-1);
        System.out.println(personas.getAll());
    }
}
