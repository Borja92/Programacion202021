import javax.swing.*;

public class AppSwing7Jlist {
    public static void main(String[] args) {

        JList jList= new JList();
        JFrame jFrame = new JFrame("Jlist");

        jFrame.setContentPane(jList.getPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
    }
}
