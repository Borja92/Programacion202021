import javax.swing.*;

public class VistaPrincipal {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel PnlPrincipal;

    public JPanel getPnlPrincipal() {
        return PnlPrincipal;
    }

    public static void main(String[] args) {
        JFrame marco = new JFrame("App");

        VistaPrincipal vista = new VistaPrincipal();
    vista.getPnlPrincipal();
        marco.pack();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
