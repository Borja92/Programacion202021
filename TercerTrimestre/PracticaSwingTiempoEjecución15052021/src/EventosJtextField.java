import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosJtextField {
    private JPanel panel;
    private JTextField textField1;

    public EventosJtextField(){
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("KeyTyped");
                System.out.println("Tecla pulsada: "+e.getKeyChar());
                System.out.println("Contenido del JTextField: "+textField1.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("-------------------------------------------------");
                        System.out.println("keyPressed");
                System.out.println("Tecla pulsada: " + e.getKeyChar());
                System.out.println("Contenido del JTextField: " +
                        textField1.getText());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("-------------------------------------------------");
                        System.out.println("keyReleased");
                System.out.println("Tecla pulsada: " + e.getKeyChar());
                System.out.println("Contenido del JTextField: " +textField1.getText());
            }
        });

    }
    public JPanel getPanel() {
        return panel;
    }
}
