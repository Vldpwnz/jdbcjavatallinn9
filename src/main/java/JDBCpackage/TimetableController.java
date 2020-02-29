package JDBCpackage;

import java.sql.*;

public class TimetableController {

    DatabaseHandler dbHandler = new DatabaseHandler();
    Statement statement;


    public void listOfTimetable(){

        statement = dbHandler.createStatement();

        try{
            ResultSet result = statement.executeQuery("SELECT * FROM timetable");

            while(result.next()){

                int id = result.getInt("id");
                String day = result.getString("day");
                int locationId = result.getInt("location_id");
                int busId = result.getInt("bus_id");
                Time arrivalTime = result.getTime("arrival_time");

                System.out.println("ID: " + id +
                        ", Day: " + day +
                        ", Location id: " + locationId +
                        ", Bus id: " + busId +
                        ", Arrival time: " + arrivalTime);
            }
            statement.close();
            dbHandler.closeConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }

    public void searchTimetable(String day){
        String dayToEnum = day.toUpperCase();
        statement = dbHandler.createStatement();
        try{
            ResultSet searchResult = statement.executeQuery("SELECT day, arrival_time, bus_id " +
                    "FROM timetable " +
                    "WHERE day=" + "'" + dayToEnum + "';");

            while (searchResult.next()){
                int busId = searchResult.getInt("bus_id");
                String arrDay = searchResult.getString("day");
                Time arrTime = searchResult.getTime("arrival_time");
                System.out.println("Bus id: " + busId +
                        ", Day: " + arrDay +
                        ", Arrival Time: " + arrTime);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
