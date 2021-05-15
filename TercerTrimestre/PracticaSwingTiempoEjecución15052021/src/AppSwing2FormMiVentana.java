import javax.swing.*;
import java.awt.*;

public class AppSwing2FormMiVentana {
    public static void main(String[] args) {
        MiVentanta miVentanta= new MiVentanta();
        JFrame jFrame = new JFrame("Hola Mundo!");
        jFrame.setContentPane(miVentanta.getHolaMundoPnl());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        int height= toolkit.getScreenSize().height-200;
        int width= toolkit.getScreenSize().width-400;
        jFrame.setPreferredSize(new Dimension(width,height));
        jFrame.pack();
jFrame.setLocationRelativeTo(null);
    }
}
