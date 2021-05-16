import javax.swing.*;
import java.awt.*;

public class AppSwing9JDialog {
    public static void main(String[] args) {
Dialog dialog=new Dialog();
        JFrame jFrame = new JFrame("Tabla Elementos");

        jFrame.setContentPane(dialog.getRootPane());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }
    }

