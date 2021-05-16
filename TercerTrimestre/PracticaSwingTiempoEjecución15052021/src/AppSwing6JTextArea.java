import javax.swing.*;

public class AppSwing6JTextArea {
    public static void main(String[] args) {
JTextArea jTextArea= new JTextArea();
JFrame jFrame = new JFrame("JTextArea");

        jFrame.setContentPane(jTextArea.getPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }
}
