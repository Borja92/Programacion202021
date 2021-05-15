import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numeros {
    private JLabel resultadoLBL;
    private JLabel numeroLBL;
    private JTextField resultadoTXT;
    private JSpinner numeroSPN;
    private JButton sumarBTN;
    private JButton restarBTN;
    private JPanel numerosPNL;

    public Numeros(){
resultadoTXT.setText(String.valueOf(0));
sumarBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        int num1= (int) numeroSPN.getValue();
        int resultado = Integer.parseInt(resultadoTXT.getText());
        resultado+=num1;

        resultadoTXT.setText(String.valueOf(resultado));

    }
});
restarBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int num1= (int) numeroSPN.getValue();
        int resultado= Integer.parseInt(resultadoTXT.getText());
        resultado-=num1;
        resultadoTXT.setText(String.valueOf(resultado));
    }
});


    }

    public JPanel getNumerosPNL() {
        return numerosPNL;
    }
}
