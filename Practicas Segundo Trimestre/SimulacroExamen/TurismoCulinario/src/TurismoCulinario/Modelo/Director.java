package TurismoCulinario.Modelo;

import TurismoCulinario.Modelo.Modelo.CalculadoraDistancia;
import TurismoCulinario.Modelo.Modelo.Ciudad;
import TurismoCulinario.Modelo.Modelo.Establecimiento;
import TurismoCulinario.Modelo.Modelo.Plato;
import TurismoCulinario.Modelo.Persistencia.CSVReader;
import TurismoCulinario.Modelo.Persistencia.XMLReader;

import javax.xml.xpath.XPathExpressionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Director {
    private Map<String, Ciudad> ciudades;
    private final static String CSV_FILE = "platos.csv";
    private final static String XML_FILE = "establecimientos.xml";
    private final static double LATITUD = 43.060017;
    private final static double LONGITUD = -2.493796;
    private CSVReader csvReader;
    private XMLReader xmlReader;
    private CalculadoraDistancia calculadoraDistancia;


    public Director() {

        ciudades = new HashMap<>();
    }

    public void inicializar() throws XPathExpressionException {
        csvReader = new CSVReader(CSV_FILE);
        xmlReader = new XMLReader(XML_FILE);
        ciudades = xmlReader.read();

        //COMPROBACIONES DEL CONTENIDO DE CIUDADES

        for (Ciudad ciudad : ciudades.values()) {
            System.out.println("Ciudad: " + ciudad.getNombre());
            System.out.println(ciudad.getPlatos());
            System.out.println(ciudad.getEstablecimientos());
        }


    }


    private List<Establecimiento> getEstablecimientoPorPlato(String nombrePlato) {
        for (Ciudad c : ciudades.values()) {
            return c.getEstablecimientos();
        }
        return null;
    }

    public List<Establecimiento> getEstablecimientosPorCiudad(String nombreCiudad) {
        Ciudad ciudad = ciudades.get(nombreCiudad);
        return ciudad.getEstablecimientos();
    }

    public List<Plato> getPlatosTipicosPorCiudad(String nombreCiudad) {

        Ciudad ciudad = ciudades.get(nombreCiudad);
        return ciudad.getPlatos();
    }

    public List<Establecimiento> getEstablecimientosPorCiudadYPlato(String nombreCiudad, String nombrePlato) {
        Ciudad ciudad = ciudades.get(nombreCiudad);

        if (ciudad.tienePlato(nombrePlato)) {
            List<Establecimiento> establecimientos = getEstablecimientosPorCiudad(nombreCiudad);
            List<Establecimiento> establecimientosConPlato = new ArrayList<>();
            for (Establecimiento e : establecimientos) {
                if (e.tienePlato(nombrePlato))
                    establecimientosConPlato.add(e);

            }
            return establecimientosConPlato;
        }
        return null;
    }


    public Establecimiento getEstablecimientoCercanoPorPlato(String nombrePlato) {

        Establecimiento establecimientoMasCercano = null;
        double distanciaMinima = Double.MAX_VALUE;
        List<Establecimiento> establecimientosConPlato = getEstablecimientoPorPlato(nombrePlato);
        for (Establecimiento e : establecimientosConPlato) {
            double distanciaAEstableblecimiento = calculadoraDistancia.caluclarDisntacia(e);
            if (distanciaAEstableblecimiento < distanciaMinima) {

                distanciaMinima = distanciaAEstableblecimiento;
                establecimientoMasCercano = e;
            }
        }
        return establecimientoMasCercano;
    }


    public List<Plato> getPlatosPorEstablecimiento(String nombreEstablecimiento) {

        for (Ciudad c : ciudades.values()) {
            Establecimiento establecimientoConPlatos = c.getEstablecimientoPorNombre(nombreEstablecimiento);
            if (establecimientoConPlatos != null) {
                return establecimientoConPlatos.getPlatos();
            }
        }
        return null;
    }

    public void addPlato(Plato plato, String nombreCiudad) {
        Ciudad c = ciudades.get(nombreCiudad);
        c.addPlato(plato);
    }


    public void addEstablecimiento(Establecimiento establecimiento, String nombreCiudad) {
        Ciudad c = ciudades.get(nombreCiudad);
        c.addEstablecimiento(establecimiento);
    }


}
