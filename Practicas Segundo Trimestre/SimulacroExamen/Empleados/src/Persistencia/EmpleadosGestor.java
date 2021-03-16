package Persistencia;

import Modelo.Asalariado;
import Modelo.Comisionado;
import Modelo.Empleado;
import Modelo.PorHoras;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosGestor {
    private String fichero;
    private Document doc;

    public EmpleadosGestor(String fichero){
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            File inputFile = new File(dir + File.separator + fichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> read(){
        List<Empleado> empleados = new ArrayList<>();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String xpathExpr = "/empleados/empleado";
        try {
            NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
            for (int i=0; i < nodeList.getLength(); i++){
                Empleado empleado = getEmpleadoFromNodo(nodeList.item(i));
                empleados.add(empleado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return empleados;
    }

    private Empleado getEmpleadoFromNodo(Node nodoEmpleado) {
        Element elementoEmpleado = (Element) nodoEmpleado;

        int id = Integer.parseInt(elementoEmpleado.getAttribute("id"));
        String nombre = elementoEmpleado.getAttribute("nombre");
        String apellidos = elementoEmpleado.getAttribute("apellidos");
        String tipo = elementoEmpleado.getAttribute("tipo");

        switch (tipo){
            case "comisionado":
                double comision = Double.parseDouble(elementoEmpleado.getAttribute("extra"));
                int ventas = Integer.parseInt(elementoEmpleado.getAttribute("ventas"));
                return new Comisionado(id,nombre,apellidos,Double.MIN_VALUE,comision,ventas);


            case "por_horas":
                double horasTrabajadas = Double.parseDouble(elementoEmpleado.getAttribute("horas"));
                return new PorHoras(id,nombre,apellidos,Double.MIN_VALUE,horasTrabajadas);

            case "asalariado":
                return new Asalariado(id,nombre,apellidos,Double.MIN_VALUE);
            default:
                return null;
        }
    }
    }

