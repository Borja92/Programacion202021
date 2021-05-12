package vista;

import logica.Persona;

import javax.swing.*;
import java.awt.*;

public class ListaRenderer implements ListCellRenderer<Persona> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Persona> list, Persona value, int index, boolean isSelected, boolean cellHasFocus) {
        LayoutListaPersona layout = new LayoutListaPersona(value);

        if (cellHasFocus && isSelected)
            layout.resaltar(LayoutListaPersona.RESALTADO_FUERTE);
        else if (isSelected)
            layout.resaltar(LayoutListaPersona.RESALTADO_SUAVE);
        else
            layout.resaltar(LayoutListaPersona.NO_RESALTADO);

        return layout.getPanel();
    }
}
