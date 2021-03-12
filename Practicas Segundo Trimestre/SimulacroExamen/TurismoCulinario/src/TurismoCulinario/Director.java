package TurismoCulinario;

import TurismoCulinario.Modelo.*;
import TurismoCulinario.Persistencia.CSVReader;
import TurismoCulinario.Persistencia.XMLReader;

import javax.xml.xpath.XPathExpressionException;
import java.util.*;


public class Director {
    private Map<String,Ciudad> ciudades;
    private final static String CSV_FILE = "platos.csv";
    private final static String XML_FILE = "establecimientos.xml";
    private final static double LATITUD = 43.060017;
    private final static double LONGITUD = -2.493796;
    private CSVReader csvReader;
    private XMLReader xmlReader;
    private CalculadoraDistancia calculadoraDistancia;
public Director(){
        ciudades = new HashMap<>();
        }

public void inicializar() throws XPathExpressionException {
        csvReader = new CSVReader(CSV_FILE);
        xmlReader = new XMLReader(XML_FILE);
        calculadoraDistancia = new CalculadoraDistancia(new Coordenadas(LATITUD,LONGITUD));

        ciudades = csvReader.read();
        xmlReader.setCiudades(ciudades);
        ciudades = xmlReader.read();
        }

public List<Establecimiento> getEstablecimientosPorCiudad(String nombreCiudad){
        Ciudad ciudad = ciudades.get(nombreCiudad);
        return ciudad.getEstablecimientos();
        }
public List<Plato> getPlatosTipicosPorCiudad(String nombreCiudad){
        Ciudad ciudad = ciudades.get(nombreCiudad);
        return ciudad.getPlatos();
        }

public List<Establecimiento> getEstablecimientosPorCiudadYPlato(String nombreCiudad, String nombrePlato){
        Ciudad ciudad = ciudades.get(nombreCiudad);
        if (ciudad.tienePlato(nombrePlato)) {
            List<Establecimiento> establecimientos = getEstablecimientosPorCiudad(nombreCiudad);
            List<Establecimiento> establecimientosConPlato = new ArrayList<>();
        for (Establecimiento e : establecimientos) {
        if (e.tienePlato(nombrePlato))
establecimientosConPlato.add(e);
            //System.out.println(e);
        }
return establecimientosConPlato;
        }
        return null;
        }

private Plato getPlatoPorNombre(String nombrePlato) {
        for (Ciudad ciudad : ciudades.values()){
        if (ciudad.tienePlato(nombrePlato))
        return ciudad.getPlatoPorNombre(nombrePlato);
        }
        return null;
        }

public Establecimiento getEstablecimientoCercanoPorPlato(String nombrePlato){
        Establecimiento establecimientoMasCercano = null;
        double distanciaMinima = Double.MAX_VALUE;
        List<Establecimiento> establecimientosConPlato = getEstablecimientosPorPlato(nombrePlato);

        for (Establecimiento establecimiento : establecimientosConPlato){
        double distaciaAEstablecimiento = calculadoraDistancia.calcularDistancia(establecimiento);
        if (distaciaAEstablecimiento < distanciaMinima) {
        distanciaMinima = distaciaAEstablecimiento;
        establecimientoMasCercano = establecimiento;
        }
        }
        return establecimientoMasCercano;
        }

private List<Establecimiento> getEstablecimientosPorPlato(String nombrePlato){
        for (Ciudad ciudad : ciudades.values()){
        if (ciudad.tienePlato(nombrePlato))
        return ciudad.getEstablecimientos();
        }
        return null;
        }


public List<Plato> getPlatosPorEstablecimiento(String nombreEstablecimiento){
        for (Ciudad ciudad : ciudades.values()){
        Establecimiento establecimiento = ciudad.getEstablecimientoPorNombre(nombreEstablecimiento);
        if (establecimiento != null)
        return establecimiento.getPlatos();
        }
        return null;
        }

public void addPlato(Plato plato, String nombreCiudad){
        Ciudad ciudad = ciudades.get(nombreCiudad);
        ciudad.addPlato(plato);
        }

public void addEstablecimiento(Establecimiento establecimiento, String nombreCiudad){
        Ciudad ciudad = ciudades.get(nombreCiudad);
        ciudad.addEstablecimiento(establecimiento);
        }
        }
