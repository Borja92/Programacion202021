import javax.swing.*;
import java.awt.*;

public class JTextArea {
    private JPanel panel;
    private javax.swing.JTextArea txtArea;

    public JTextArea() {
        txtArea.setText("El pasaje estándar Lorem Ipsum, usado desde el año 1500.\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        txtArea.setFont(Font.getFont(Font.SANS_SERIF));
        txtArea.setLineWrap(true);

    }

    public JPanel getPanel() {
        return panel;
    }
}
