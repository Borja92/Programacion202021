package vista;

import blackjack.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ListCellForm implements ListCellRenderer {
    private JPanel pnlMain;
    private JLabel lblNumeroTirada;
    private JLabel lblNumeroObtenido;
    private ModeloListaTiradas modeloListaTiradas;

    public JPanel getPnlMain() {
        return pnlMain;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int i, boolean isSelected, boolean cellHasFocus) {

        lblNumeroTirada.setText("Tirada "+String.valueOf(i));
        lblNumeroObtenido.setText(String.valueOf(value));
        return pnlMain;
    }
}
