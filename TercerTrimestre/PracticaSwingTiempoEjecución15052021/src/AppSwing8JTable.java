import javax.swing.*;

public class AppSwing8JTable {
    public static void main(String[] args) {
      JTable jTable= new JTable();

        JFrame jFrame = new JFrame("Tabla Elementos");

        jFrame.setContentPane(jTable.getPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }
}
