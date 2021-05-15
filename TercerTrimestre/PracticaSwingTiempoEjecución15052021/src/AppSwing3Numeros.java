import javax.swing.*;

public class AppSwing3Numeros {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Números");
        frame.setContentPane(new Numeros().getNumerosPNL());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
