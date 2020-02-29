package JDBCpackage;

import java.sql.*;

public class Prepeare {
    String url = "jdbc:mysql://localhost:3306/TallinnBusDB?serverTimezone=UTC";
    String user = "vlad";
    String pass = "cherkashin1998";

    public void prepearedStatement(String name, String address, String phone, int age) throws SQLException{
        Connection connector = DriverManager.getConnection(url, user, pass);
        Statement statement = connector.prepareStatement("SELECT id, name, address, phone, FROM driver WHERE name = ????");

        String INSERT = "INSERT INTO driver(name, address, phone, age) VALUES (?, ?, ?, ?);";

        PreparedStatement prstm = connector.prepareStatement(INSERT);

        prstm.setString(1,name);
        prstm.setString(2, address);
        prstm.setString(3,phone);
        prstm.setInt(4,age);

        int ret = prstm.executeUpdate();


    }



}
