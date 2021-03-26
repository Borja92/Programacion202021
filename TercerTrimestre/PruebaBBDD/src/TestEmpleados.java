import java.sql.*;

public class TestEmpleados {
    private static Connection conn;
    public static void main(String[] args) throws SQLException {
      //  conn = DriverManager.getConnection("jdbc:mysql://192.168.1.210:3386/Empleados","usuario","123456789");
        conn = DriverManager.getConnection("jdbc:mysql://192.168.1.210:3306/Empleados","usuario","123456789");
        if (conn != null){
            ResultSet result = conn.prepareStatement("SELECT * FROM Empleado").executeQuery();
            /*PreparedStatement statement = conn.prepareStatement("SELECT * FROM Empleado");
            ResultSet result = statement.executeQuery();*/
            while (result.next()){
                Empleado empleado = resultSetToEmpleado(result);
                System.out.println(empleado);
            }

            PreparedStatement statement = conn.prepareStatement("INSERT INTO Empleado (nombre,apellidos,dni,sueldo) VALUES (?,?,?,?)");
            statement.setString(1,"Pepe");
            statement.setString(2,"Rubianes");
            statement.setString(3,"12345678Q");
            statement.setDouble(4,1200);

            //devuelve numero tuplas acepetadas
            int tuplasAceptadas = statement.executeUpdate();
            System.out.println(tuplasAceptadas);
        }
    }

    private static Empleado resultSetToEmpleado(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nombre = result.getString("nombre");
        String apellidos = result.getString("apellidos");
        String dni = result.getString("dni");
        double sueldo = result.getDouble("sueldo");
        Empleado empleado = new Empleado(nombre,apellidos,dni,sueldo);
        empleado.setId(id);
        return empleado;
    }

}
