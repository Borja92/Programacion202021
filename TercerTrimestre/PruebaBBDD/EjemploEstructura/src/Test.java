import Secretaria.Secretaria;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, SQLException {
        Secretaria secretaria = new Secretaria();
        // secretaria.crearAlumno("Pepa","González","12345678B");
        // secretaria.crearAlumno("Alumno2","Apellido2","12345678C");
        // secretaria.crearAlumno("Alumno2", "Apellido3","12345678D");
       // secretaria.crearAlumno("AlumnoAEliminar", "Apellido4", "12345678F");
        System.out.println(secretaria.getAlumnos());
        System.out.println();
        System.out.println("Alumno por DNI: " + secretaria.getAlumnoPorDNI("12345678B"));
        System.out.println();
        System.out.println("Alumno por nombre: " + secretaria.getAlumnoPorNombre("Alumno2"));
        System.out.println();
        System.out.println("Actualizar un nombre: " + secretaria.actulizarNombreAlumno("12345678B", "Pepe"));
        System.out.println();
        System.out.println("Actualizar un nombre: " + secretaria.actulizarNombreAlumno("12345678D", "Manolo"));
        System.out.println();
        System.out.println("Actualizar un nombre: " + secretaria.actulizarNombreAlumno("12333678T", "Maria"));
        System.out.println();
        System.out.println("Eliminar un alumno.Operación exitosa: " + secretaria.eleminiarAlumno("12345678F"));
    }
}
