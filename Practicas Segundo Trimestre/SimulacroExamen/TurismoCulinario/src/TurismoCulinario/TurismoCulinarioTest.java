package TurismoCulinario;

import TurismoCulinario.Modelo.Coordenadas;
import TurismoCulinario.Modelo.Establecimiento;
import TurismoCulinario.Modelo.Plato;

import javax.xml.xpath.XPathExpressionException;


public class TurismoCulinarioTest {
    public static void main(String[] args) throws XPathExpressionException {
        Director director = new Director();
        director.inicializar();

        // Test 1
        // Establecimientos de Bibalo
        System.out.println("-----------------------------------------------");
        System.out.println("Establecimientos de Bibalo");
        System.out.println(director.getEstablecimientosPorCiudad("Bilbao"));

        // Test 2
        // Platos típicos de San Sebastián
        System.out.println("-----------------------------------------------");
        System.out.println("Platos típicos de San Sebastián");
        System.out.println(director.getPlatosTipicosPorCiudad("San Sebastián"));

        // Test 3
        // Establecimientos de Tolosa que sirven Alubias con sacramentos
        System.out.println("-----------------------------------------------");
        System.out.println("Establecimientos de Tolosa que sirven Alubias con sacramentos");
        System.out.println(director.getEstablecimientosPorCiudadYPlato("Tolosa", "Alubias con sacramentos"));

        // Test 4
        // Establecimiento más cercano donde se sirve Intxaursaltsa
        System.out.println("-----------------------------------------------");
        System.out.println("Establecimiento más cercano donde se sirve Intxaursaltsa");
        System.out.println(director.getEstablecimientoCercanoPorPlato("Intxaursaltsa"));

        // Test 5
        // Platos que se seriven en el restaurante Kixkurgune
        System.out.println("-----------------------------------------------");
        System.out.println("Platos que se seriven en el restaurante Kixkurgune");
        System.out.println(director.getPlatosPorEstablecimiento("Kixkurgune"));

        // Test 6
        // Introducir "Huevos con chorizo" y "macarrones con tomate" entre los platos de Bilbao
        System.out.println("-----------------------------------------------");
        System.out.println("Introducir Huevos con chorizo y macarrones con tomate entre los platos de Bilbao");
        Plato huevosConChorizo = new Plato("Huevos con chorizo","Huevos fritos con chorizo asado");
        Plato macarronesConTomate = new Plato("Macarrones con tomate","Macarrones con salsa de tomate y orégano");
        director.addPlato(huevosConChorizo,"Bilbao");
        director.addPlato(macarronesConTomate,"Bilbao");
        System.out.println(director.getPlatosTipicosPorCiudad("Bilbao"));

        // Test 7
        // Introducir un nuevo establecimiento con sus platos típicos
        System.out.println("----------------------------------------------");
        System.out.println("Introducir un nuevo establecimiento con sus platos típicos");
        Coordenadas coordenadas = new Coordenadas(10,20);
        Establecimiento establecimiento = new Establecimiento("Bar Pepe",coordenadas);
        establecimiento.addPlato(huevosConChorizo);
        establecimiento.addPlato(macarronesConTomate);
        director.addEstablecimiento(establecimiento,"Bilbao");
        System.out.println(director.getEstablecimientosPorCiudad("Bilbao"));
    }

    }

