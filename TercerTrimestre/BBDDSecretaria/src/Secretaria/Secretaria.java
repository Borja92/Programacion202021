package Secretaria;

import Persistencia.AlumnoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Secretaria {
    private List<Alumno> alumnos;
    private AlumnoDAO alumnoDAO;
    public Secretaria() throws SQLException {
        alumnoDAO = new AlumnoDAO();
        alumnos = new ArrayList<Alumno>();
        alumnos = alumnoDAO.leerTodo(); // No está implementado en alumnoDAO

    }

    public boolean crearAlumno(String nombre, String apellidos, String dni) throws SQLException {
        Alumno alumno = new Alumno(nombre,apellidos,dni);
        int alumnoId = alumnoDAO.crear(alumno);
        if (alumnoId >= 0) {
            alumno.setId(alumnoId);
            alumnos.add(alumno);
            return true;
        }
        return false;
    }

    public List<Alumno> getAlumnos(){

        return alumnos;
    }
public Alumno getAlumnoPorDNI(String dni) throws SQLException {

      return alumnoDAO.leer(dni);}

public List<Alumno> getAlumnoPorNombre(String nombre) throws SQLException {
        return alumnoDAO.leerPorNombre(nombre);}


public boolean actulizarNombreAlumno(String dni, String nombre) throws SQLException {
Alumno alumno = new Alumno();
alumno.setNombre(nombre);
if (alumnoDAO.actualizarNombre(getAlumnoPorDNI(dni),nombre)){
    return true;
} else
return false;
    }

    public boolean eleminiarAlumno(String dni) throws SQLException {
        if(alumnoDAO.deleteAlumno(getAlumnoPorDNI(dni))){
            return true;
        } else return false;
    }

}
