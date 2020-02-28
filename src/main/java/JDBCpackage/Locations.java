package JDBCpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Locations {

    DatabaseHandler dbHandler = new DatabaseHandler();
    Statement statement;

    public void listOfLocations(){
        statement = dbHandler.createStatement();
        try{
            ResultSet results = statement.executeQuery("SELECT * FROM locations_end");

            while(results.next()){

                int id = results.getInt("stop_id");
                String stopName = results.getString("stop_name");

                System.out.println("Stop id: " + id +
                        ", Stop name: " + stopName);
            }
            statement.close();
            dbHandler.closeConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }

    public void searchLocation(String locationName){
        statement = dbHandler.createStatement();
        String stopName = locationName.toUpperCase();
        try{
            ResultSet searchResult = statement.executeQuery("SELECT stop_name, stop_id " +
                    "FROM locations_end " +
                    "WHERE stop_name=" + "'" + stopName + "';");

            while (searchResult.next()){
                int id = searchResult.getInt("stop_id");
                System.out.println("Stop name: " + stopName +
                        ", Stop id: " + id);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
