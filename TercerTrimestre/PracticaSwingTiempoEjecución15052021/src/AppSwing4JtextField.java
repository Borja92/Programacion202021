import javax.swing.*;
import java.awt.*;

public class AppSwing4JtextField {
    public static void main(String[] args) {
        EventosJtextField eventosJtextField= new EventosJtextField();
        JFrame jFrame = new JFrame("KeyListener sobre JTextField");
        jFrame.setContentPane(eventosJtextField.getPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
       /* Toolkit toolkit= Toolkit.getDefaultToolkit();
        int height= toolkit.getScreenSize().height-200;
        int width= toolkit.getScreenSize().width-400;
        jFrame.setPreferredSize(new Dimension(width,height));
       */ jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }
}
