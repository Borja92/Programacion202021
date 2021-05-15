import javax.swing.*;
import java.awt.*;

public class AppSwing1 {
    public static void main(String[] args) {

        // 1. Creación de un marco y asignación de texto a la barra de título.
        JFrame frame = new JFrame("Mi primera ventana");
        // 2. Establecer el comportamiento del botón de cierre del marco.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 3. Definir el tamaño de la ventana.
        frame.setSize(300, 300);
        //4. Crear un nuevo componente.
        JButton boton = new JButton("Presionar");
        //5.Añadir el botón al marco.
        frame.getContentPane().add(boton);
        //Mostrar el marco
        frame.setVisible(true);

        /**
         * FlowLayout
         */

        /*JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setBackground(Color.magenta);
        panelSuperior.add(new JButton("Sup.1"));
        panelSuperior.add(new JButton("Sup.2"));
        panelSuperior.add(new JButton("Sup.3"));
        panelSuperior.add(new JButton("Sup.4"));
        frame.setContentPane(panelSuperior);*/
        /**
         * BoxLayout
         */
       /* JPanel panel= new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
      //  panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(Color.RED);
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        frame.setContentPane(panel);*/


        /**
         * BorderLayout
         */

            /*JPanel panel= new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(Color.RED);
            panel.add(new JButton("centro"),BorderLayout.CENTER);
            panel.add(new JButton("izquierda"),BorderLayout.WEST);
            panel.add(new JButton("derecha"),BorderLayout.EAST);
            panel.add(new JButton("abajo"),BorderLayout.SOUTH);
            panel.add(new JButton("arriba"),BorderLayout.NORTH);
            frame.setContentPane(panel);*/
        /**
         * GridLayout
         */
/*
        JPanel panelPrincipal= new JPanel();
        panelPrincipal.setLayout(new GridLayout(3,2,10,10));
// 3 - filas, 2 - columnas, 10 - espaciado horizontal, 10 - espaciado vertical
        panelPrincipal.setBackground(Color.red);
        panelPrincipal.add(new JButton("1.1"));
        panelPrincipal.add(new JButton("1.2"));
        panelPrincipal.add(new JButton("2.1"));
        panelPrincipal.add(new JButton("2.2"));
        panelPrincipal.add(new JButton("3.1"));
        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);*/

/**
 * GridBagLayout
 */

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints restricciones = new GridBagConstraints();
        panelPrincipal.setBackground(Color.red);

        restricciones.gridx = 0; // El área de texto empieza en la columna cero.
        restricciones.gridy = 0; // El área de texto empieza en la fila cero
        restricciones.gridwidth = 2; // El área de texto ocupa dos columnas.
        restricciones.gridheight = 2; // El área de texto ocupa 2 filas.
        restricciones.weightx = 1; // Expandir el espacio ocupado horizontalmente
        restricciones.weighty = 1; // Expandir el espacio ocupado verticalmente
        restricciones.fill = GridBagConstraints.BOTH; // Expandir el  componente
        panelPrincipal.add(new JButton("1.1"), restricciones);
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
        panelPrincipal.add(new JButton("2.2"), restricciones);
        restricciones.gridx = 2;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        panelPrincipal.add(new JButton("2.3"), restricciones);
        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);


    }
}
