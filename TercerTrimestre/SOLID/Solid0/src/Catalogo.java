import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Coche> coches;

    public Catalogo(){
        coches = new ArrayList<>();
    }

    public void add(Coche coche){
        coches.add(coche);
    }

    public Coche getCocheByMatricula(String matricula){
        for (Coche coche: coches){
            if (coche.getMatricula().equals(matricula))
                return coche;
        }
        return null;
    }

    public List<Coche> getAll(){
        return coches;
    }

    public void incrementoPrecio(double porcentaje){
        for (Coche coche : coches)
            coche.setPrecio(coche.getPrecio() * (1+porcentaje));
    }

    public String renderCabecera(){
        return "<html>\n" +
                "   <head>\n" +
                "       <title>Vehículos</title>\n" +
                "   </head>\n" +
                "   <body>";
    }

    public String renderCuerpo(){
        String cuerpo = "";
        for (Coche coche: coches)
            cuerpo += "      <div class='coche'>\n" +
                     "          <p>Descripcion:" + coche.getNombre() + "</p>\n" +
                     "          <p>Matrícula:" + coche.getMatricula() + "</p>\n" +
                     "          <p>Precio:" + coche.getPrecio() + " €</p>\n" +
                     "      </div>\n";
        return cuerpo;

    }

    public String renderPie(){
        return "</body>\n" +
               "</html>";
    }
}
