package JDBCpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class BusController {

    DatabaseHandler dbHandler = new DatabaseHandler();
    Statement statement;

    public void listOfBuses(){
        statement = dbHandler.createStatement();

        try{
            ResultSet resultForBuses = statement.executeQuery("SELECT * FROM buses");

            while(resultForBuses.next()){

                int id = resultForBuses.getInt("id");
                String busNumber = resultForBuses.getString("busNumber");
                int fuel = resultForBuses.getInt("fuel");
                Timestamp purchasedOn = resultForBuses.getTimestamp("purchasedOn");
                int driverID = resultForBuses.getInt("driverID");
                Timestamp createdOn = resultForBuses.getTimestamp("createdOn");
                String result = id + " " + busNumber + " " + driverID + " " + fuel + " " + purchasedOn + " " + createdOn;
                System.out.println(result);
            }
            statement.close();
            dbHandler.closeConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public void searchBuses(String busNumber){
        statement = dbHandler.createStatement();
        try{
            ResultSet searchResult = statement.executeQuery("SELECT busNumber, id " +
                    "FROM buses " +
                    "WHERE busNumber=" + "'" + busNumber + "';");

            while (searchResult.next()){
                int id = searchResult.getInt("id");
                System.out.println("Bus number: " + busNumber +
                        ", Bus id: " + id);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
