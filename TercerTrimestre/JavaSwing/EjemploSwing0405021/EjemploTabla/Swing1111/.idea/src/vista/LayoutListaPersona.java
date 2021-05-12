package vista;

import logica.Persona;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LayoutListaPersona {
    public final static int NO_RESALTADO = 0;
    public final static int RESALTADO_SUAVE = 1;
    public final static int RESALTADO_FUERTE = 2;

    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblCategoria;
    private JLabel lblDni;
    private JPanel pnlMain;
    private JLabel lblEtqNombre;
    private JLabel lblEtqEdad;
    private JLabel lblEtqCategoria;
    private JLabel lblEtqDni;
    private JPanel pnlInterno;
    private JLabel[] campos = new JLabel[]{lblNombre,lblEdad,lblDni,lblCategoria};
    private JLabel[] etiquetas = new JLabel[]{lblEtqNombre, lblEtqEdad, lblEtqDni, lblEtqCategoria};
    private JPanel[] paneles = new JPanel[]{pnlInterno,pnlMain};


    public LayoutListaPersona(Persona persona){
        lblNombre.setText(persona.getNombre());
        setIconoCategoria(persona.getCategoria());
        //lblCategoria.setText(Persona.getTagCategoria(persona.getCategoria()));
        lblEdad.setText(String.valueOf(persona.getEdad()));
        lblDni.setText(persona.getDni());

        pnlMain.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK));
    }

    private void setIconoCategoria(int categoria) {
        ImageIcon iconoCategoria;
        switch(categoria){
            case Persona.ASALARIADO:
                 iconoCategoria = new ImageIcon("asalariado.png");
                 lblCategoria.setText("Asalariado");
                 break;
            case Persona.COMISIONADO:
                iconoCategoria = new ImageIcon("comisionado.png");
                lblCategoria.setText("Comisionado");
                break;
            case Persona.POR_HORAS:
                iconoCategoria = new ImageIcon("horas.png");
                lblCategoria.setText("Por horas");
                break;
            default:
                iconoCategoria = new ImageIcon("asalariado.png");
                lblCategoria.setText("Desconocida");
        }
        lblCategoria.setIcon(iconoCategoria);
    }

    public JPanel getPanel(){
        return pnlMain;
    }

    public void resaltar(int tipoResaltado){
        Font font;
        Color fontColor, backgroundColor;
        switch (tipoResaltado){
            case RESALTADO_SUAVE:
                font = new Font("Sans Serif",Font.ITALIC,12);
                fontColor = Color.BLACK;
                backgroundColor = Color.GRAY;
                break;
            case RESALTADO_FUERTE:
                font = new Font("Sans Serif",Font.BOLD,12);
                fontColor = Color.LIGHT_GRAY;
                backgroundColor = Color.DARK_GRAY;
                break;
            default: // NO_RESALTADO
                font = new Font("Sans Serif",Font.PLAIN,12);
                fontColor = Color.BLACK;
                backgroundColor = Color.LIGHT_GRAY;
        }
        setFont(font,fontColor);
        setBackground(backgroundColor);
    }


    private void setFont(Font font, Color color) {
        for (JLabel label : campos) {
            label.setFont(font);
            label.setForeground(color);
        }

        for (JLabel label : etiquetas)
            label.setForeground(color);
    }

    private void setBackground(Color color){
        for (JPanel panel : paneles)
            panel.setBackground(color);
    }

    public int getHight(){
        pnlMain.invalidate();
        return pnlMain.getHeight();
    }
}
