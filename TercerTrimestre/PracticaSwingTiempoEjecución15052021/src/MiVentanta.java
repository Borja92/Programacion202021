import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiVentanta {
    private JButton holaMundoBtn;
    private JPanel holaMundoPnl;
    private JLabel numClicsLBL;

    public JPanel getHolaMundoPnl() {
        return holaMundoPnl;
    }

    public MiVentanta(){
        final int[] numClics = {0};
       numClicsLBL.setText(String.valueOf(numClicsLBL));

        holaMundoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola mundo!");
                numClics[0]++;
                numClicsLBL.setText(String.valueOf(numClics[0]));
            }
        });
    }

}
