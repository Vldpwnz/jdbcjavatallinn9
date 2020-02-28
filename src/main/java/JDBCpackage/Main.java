package JDBCpackage;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        DriverController driverController = new DriverController();
        BusController busController = new BusController();
        PassengersController passengersController = new PassengersController();
        TimetableController timetableController = new TimetableController();
        Locations locations = new Locations();


        driverController.listAllDrivers();
        System.out.println("\n***************************************************\n");
        busController.listOfBuses();
        System.out.println("\n***************************************************\n");
        passengersController.listOfPassengers();
        System.out.println("\n***************************************************\n");
        timetableController.listOfTimetable();
        System.out.println("\n***************************************************\n");
        locations.listOfLocations();
        System.out.println("\n***************************************************\n");
        //driverController.createDriver("Vlad", "mahtra-8", "56565656", 34);
        System.out.println("\n***************************************************\n");
        driverController.searchDriver("+3725685");
        System.out.println("\n***************************************************\n");
        locations.searchLocation("kosmos");
        System.out.println("\n***************************************************\n");
        passengersController.searchPassenger("+372565958");
        System.out.println("\n***************************************************\n");
        busController.searchBuses("24");
        System.out.println("\n***************************************************\n");
        timetableController.searchTimetable("monday");
    }
}
