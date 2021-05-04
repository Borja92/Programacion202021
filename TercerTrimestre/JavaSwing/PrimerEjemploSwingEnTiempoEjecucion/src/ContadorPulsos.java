import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorPulsos {
    private JButton buttonPulsar;
    private JTextField textFieldNumVeces;
    private JPanel JPanelHolaMundo;

    public ContadorPulsos(){


    buttonPulsar.addActionListener(new ActionListener() {



        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPulsar.doClick();
                textFieldNumVeces.setText();


        }
    });
    textFieldNumVeces.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}

    public JPanel getJPanelHolaMundo() {
        JPanelHolaMundo.setLayout(new BorderLayout());
        return JPanelHolaMundo;
    }

    public static void main(String[] args) {
        JFrame marco = new JFrame("Hola mundo!");

ContadorPulsos contadorPulsos = new ContadorPulsos();
       contadorPulsos.getJPanelHolaMundo();
        marco.pack();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
