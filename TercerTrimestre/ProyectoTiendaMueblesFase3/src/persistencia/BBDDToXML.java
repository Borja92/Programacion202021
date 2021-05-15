package persistencia;

import java.io.IOException;
import java.sql.SQLException;


public class BBDDToXML {

    private DBConn dbConn;
    public BBDDToXML(DBConn dbConn){

        this.dbConn= new DBConn();
    }

    public  void dumpToXML(){
        /*try {


            dbConn.conectar().prepareStatement("mysqldumpt --xml -u usuario -p mobant > mobant.xml").execute();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/


        Runtime runtime = Runtime.getRuntime();

        String operacion="mysqldumpt --xml -u usuario -p 123456789 -B mobant@192.168.1.22 > mobant.xml";

        try {
            runtime.exec(operacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
