package JDBCpackage;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

public class Prepare {
    String url = "jdbc:mysql://localhost:3306/TallinnBusDB?serverTimezone=UTC";
    String user = "vlad";
    String pass = "cherkashin1998";

    Connection connector;
    Statement statement;

    public void preparedStatementInsertion(String name, String address, String phone, int age) throws SQLException{
        connector = DriverManager.getConnection(url, user, pass);
        statement = connector.prepareStatement("SELECT id, name, address, phone, FROM driver WHERE name = ????");

        String INSERT = "INSERT INTO driver(name, address, phone, age) VALUES (?, ?, ?, ?);";

        PreparedStatement prstm = connector.prepareStatement(INSERT);

        prstm.setString(1,name);
        prstm.setString(2,address);
        prstm.setString(3,phone);
        prstm.setInt(4,age);

        int ret = prstm.executeUpdate();

    }

    public void preparedStatementDeleting(int id) throws SQLException{
        connector = DriverManager.getConnection(url, user, pass);
        statement = connector.prepareStatement("SELECT id, name, address, phone, FROM driver WHERE name = ????");

        String DELETE = "DELETE FROM driver WHERE id > ?;";
        PreparedStatement prstm = connector.prepareStatement(DELETE);
        prstm.setInt(1,id);

        int ret = prstm.executeUpdate();
    }



}
