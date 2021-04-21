import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;

import static javax.swing.JFrame.*;

public class Main {



    public static void main(String[] args) {
   /* // 1. Creación de un marco y asignación de texto a la barra de título.
            JFrame frame = new JFrame("Mi primera ventana");
// 2. Establecer el comportamiento del botón de cierre del marco.
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
// 3. Definir el tamaño de la ventana.
frame.setSize(300, 300);
    // 4. Crear un nuevo componente.
    JButton boton = new JButton("Presionar");
// 5. Añadir el botón al marco.
frame.getContentPane().add(boton);
// 6. Mostrar el marco
frame.setVisible(true);*/



    /*    JFrame frame = new JFrame("Mi primera ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.red);
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        frame.setContentPane(panel);
        frame.setVisible(true);
*/

/*
    JFrame frame = new JFrame("Mi primera ventana");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(300, 300);

    JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
panelSuperior.setBackground(Color.cyan);
panelSuperior.add(new JButton("Sup.1"));
panelSuperior.add(new JButton("Sup.2"));
panelSuperior.add(new JButton("Sup.3"));
panelSuperior.add(new JButton("Sup.4"));
frame.setContentPane(panelSuperior);
frame.setVisible(true);
*/

/*

        JFrame frame = new JFrame("Mi primera ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints restricciones = new GridBagConstraints ();
        panelPrincipal.setBackground(Color.red);

        restricciones.gridx = 0; // El área de texto empieza en la columna cero.
                restricciones.gridy = 0; // El área de texto empieza en la fila cero
        restricciones.gridwidth = 2; // El área de texto ocupa dos columnas.
                restricciones.gridheight = 2; // El área de texto ocupa 2 filas.
        restricciones.weightx = 1; // Expandir el espacio ocupado horizontalmente
        restricciones.weighty = 1; // Expandir el espacio ocupado verticalmente
        restricciones.fill = GridBagConstraints.BOTH; // Expandir elcomponente
        panelPrincipal.add(new JButton("1.1"),restricciones);
        restricciones.gridx = 2;
        restricciones.gridy = 1;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panelPrincipal.add(new JButton("1.2"), restricciones);
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panelPrincipal.add(new JButton("2.1"), restricciones);
        restricciones.gridx = 1;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panelPrincipal.add(new JButton("2.2"),restricciones);
        restricciones.gridx = 2;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panelPrincipal.add(new JButton("2.3"), restricciones);

        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);

*/


/*
        JFrame frame = new JFrame("Mi primera ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));
        panelIzquierdo.add(new JButton("izquierda_1"));
        panelIzquierdo.add(new JButton("izquierda_2"));
        panelIzquierdo.add(new JButton("izquierda_3"));

        panelPrincipal.setBackground(Color.red);
        panelPrincipal.add(new JButton("centro"),BorderLayout.CENTER);
        panelPrincipal.add(panelIzquierdo,BorderLayout.WEST);
        panelPrincipal.add(new JButton("derecha"),BorderLayout.EAST);
        panelPrincipal.add(new JButton("arriba"),BorderLayout.NORTH);
        panelPrincipal.add(new JButton("abajo"),BorderLayout.SOUTH);
        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);
        JPanel nuevoPanel = new JPanel();
nuevoPanel.setLayout(new BasicScrollBarUI());
nuevoPanel.setLayout(nuevoPanel,BasicScrollBarUI.BOTTOM);

panelPrincipal.add(nuevoPanel);*/







    }


}
