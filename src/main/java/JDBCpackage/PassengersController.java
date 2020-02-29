package JDBCpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class PassengersController {

    DatabaseHandler dbHandler = new DatabaseHandler();
    Statement statement;

    public void listOfPassengers(){

        statement =dbHandler.createStatement();

        try{
            ResultSet result = statement.executeQuery("SELECT  * FROM passengers");

            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String eMail = result.getString("email");
                String phoneNumber = result.getString("phoneNumber");
                int age = result.getInt("age");
                int locationStart = result.getInt("startLocationId");
                int locationStop = result.getInt("stopLocationId");
                int busId = result.getInt("busID");
                Time workingTime = result.getTime("going_to_work");

                System.out.println("ID: " + id +
                        ", Name: " + name +
                        ", E-mail: " + eMail +
                        ", Phone Number: " + phoneNumber +
                        ", Age: " + age +
                        ", Start location: " + locationStart +
                        ", End location: " + locationStop +
                        ", Bus id: " + busId +
                        ", Go to work: " + workingTime);
            }
            statement.close();
            dbHandler.closeConnection();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void searchPassenger(String phoneNumber){
        statement = dbHandler.createStatement();
        try{
            ResultSet searchResult = statement.executeQuery("SELECT name, phoneNumber " +
                    "FROM passengers " +
                    "WHERE phoneNumber=" + "'" + phoneNumber + "';");

            while (searchResult.next()){
                String name = searchResult.getString("name");
                System.out.println("Name: " + name +
                        ", Phone number: " + phoneNumber);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
