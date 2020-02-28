package JDBCpackage;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DriverController {

    DatabaseHandler dbHandler = new DatabaseHandler();
    Statement statement;



    public void listAllDrivers(){
        statement = dbHandler.createStatement();
        try{
            ResultSet results = statement.executeQuery("SELECT * FROM driver");

            while(results.next()){

                int id = results.getInt("id");
                String name = results.getString("name");
                String address = results.getString("address");
                String number = results.getString("phone");
                int age = results.getInt("age");
                Timestamp createdOn = results.getTimestamp("createdOn");

                System.out.println(id + " " +
                        name + " " +
                        address + " " +
                        number + " " +
                        age + " " +
                        createdOn);
            }
            statement.close();
            dbHandler.closeConnection();
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }
    public void createDriver(String name, String address, String phone, int age) throws SQLException{
        statement = dbHandler.createStatement();
        try {
            String insertInto = "INSERT INTO driver(name, address, phone, age)" +
                    "VALUES(" + "\'" + name + "\'" + "," + "\'" + address + "\'" + "," + "\'" + phone + "\'" + "," + age + ")";
            statement.executeUpdate(insertInto);
        }catch (SQLException ex){
            System.out.println("Duplicated entry!");
        }
        statement.close();
    }

    public void searchDriver(String phoneNumber){
        statement = dbHandler.createStatement();

        try{
            ResultSet searchResult = statement.executeQuery("SELECT name, phone " +
                "FROM driver " +
                "WHERE phone=" + "'" + phoneNumber + "';");

            while (searchResult.next()){
                String name = searchResult.getString("name");
                System.out.println("Driver's name: " + name +
                        ", Driver's phone number: " + phoneNumber);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
