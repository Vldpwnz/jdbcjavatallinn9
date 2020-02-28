package JDBCpackage;

import javax.crypto.spec.PSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

    String url = "jdbc:mysql://localhost:3306/TallinnBusDB?serverTimezone=UTC";
    String user = "vlad";
    String pass = "cherkashin1998";

    Connection dbConnection;
    Statement statement;

    public Statement createStatement(){

        try{
            dbConnection = DriverManager.getConnection(url, user, pass);
            statement = dbConnection.createStatement();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return statement;
    }

    public void closeConnection(){
        try{
            dbConnection.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }

}
