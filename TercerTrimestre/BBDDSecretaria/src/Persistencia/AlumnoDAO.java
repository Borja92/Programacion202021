package Persistencia;

import Secretaria.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    // CRUD - Create Read  Update Delete

    private DBConn dbConn;

    public AlumnoDAO() throws SQLException {
        dbConn = new DBConn();
    }

    public int crear(Alumno alumno) throws SQLException {
        Connection conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO Alumno(nombre,apellidos,dni) VALUES ('" + alumno.getNombre() + "','" +
                        alumno.getApellidos() + "','" +
                        alumno.getDni() + "')",
                Statement.RETURN_GENERATED_KEYS);
        int numFilas = statement.executeUpdate();
        ResultSet result = statement.getGeneratedKeys();
        if (result.next())
            return result.getInt(1);
        else
            return -1;
    }
    /*public boolean crear(Alumno alumno) throws SQLException {

        Connection conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO Alumno(nombre,apellidos,dni) VALUES ('" + alumno.getNombre() + "','" +
                        alumno.getApellidos() + "','" +
                        alumno.getDni() + "')",
                Statement.RETURN_GENERATED_KEYS);
        if (result.next())
            alumno.setId(result.getInt(1));
        else
            return -1;
    }*/

    public List<Alumno> leerTodo() throws SQLException {
        Connection conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("SELECT id, nombre, apellidos, dni FROM Alumno");
        ResultSet resultSet1 = statement.executeQuery();
        List<Alumno> alumnos = new ArrayList<>();// para devolver null en caso de que el alumno no exista

        while (resultSet1.next()) {
            int id = resultSet1.getInt(1);
            String nombre = resultSet1.getString(2);
            String apellidos = resultSet1.getString(3);
            String dni = resultSet1.getString(4);
            Alumno alumno = new Alumno(id, nombre, apellidos, dni);
            alumnos.add(alumno);
        }
        return alumnos;
    }

    public Alumno leer(String dni) throws SQLException {
        //SELECT * FROM ALUMNO WHERE dni = '12345678A';
        List<Alumno> alumnos;
        alumnos = leerTodo();
        Alumno alumno = new Alumno();
        for (Alumno a : alumnos) {
            if (dni.equalsIgnoreCase(a.getDni())) {
                //System.out.println(a);
                alumno = a;
            }
            if (alumno == null) {
                System.out.println("No hay coincidencias de DNI");
            }
        }
        return alumno;
    }

    public List<Alumno> leerPorNombre(String nombre) throws SQLException {
        List<Alumno> alumnos;
        List<Alumno> alumnosQueSeLlamanIgual = new ArrayList<>();
        alumnos = leerTodo();
        for (Alumno a : alumnos) {
            if (nombre.equalsIgnoreCase(a.getNombre())) {
                alumnosQueSeLlamanIgual.add(a);
            }
        }
        return alumnosQueSeLlamanIgual;
    }

    /*public boolean actualizarNombre(Alumno alumno, String nombre) throws SQLException {
        List<Alumno> alumnos;
        alumnos=leerTodo();
alumno=leer(alumno.getDni());

        for (Alumno a:alumnos) {

        }
        return false;
    }*/
    public boolean actualizarNombre(Alumno alumno, String nombre) throws SQLException {
        Connection conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("update Alumno set nombre =" + "'" + nombre + "'" + " where dni=" + "'" + alumno.getDni() + "'");
        //
        int valor = statement.executeUpdate();//Recogemos valor int, si el valor es >0 es que la operación se ha efectuado en n líneas
        conn.close();
        if (valor > 0) {
            return true;
        } else return false;
    }
/*public int actualizar(Alumno alumno, String campoACambiar, String valor) throws SQLException {

        Connection connection=dbConn.conectar();
        connection.prepareStatement(" UPDATE Alumno SET "+ campoACambiar +" =  + " + valor + "'" + "WHERE dni =" + "'"+ dni + "'").executeUpdate();

}*/

    public boolean deleteAlumno(Alumno alumno) throws SQLException {
        Connection conn = dbConn.conectar();
        PreparedStatement statement = conn.prepareStatement("delete from Alumno where Alumno.dni=" + "'" + alumno.getDni() + "'");
        //conn.close();
        int valor = statement.executeUpdate();
        conn.close();
        if (valor > 0) {
            return true;
        } else return false;
    }


}
