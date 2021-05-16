import javax.swing.*;

public class AppSwing5JComboBox {
    public static void main(String[] args) {
JComboBox jComboBox= new JComboBox();
JFrame jFrame = new JFrame("JComboBox");
        jFrame.setContentPane(jComboBox.getPanel());
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
