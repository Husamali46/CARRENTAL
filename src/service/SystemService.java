package service;

import util.Database;
import product.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SystemService {
    Vehicle vehicle;
    public SystemService (Vehicle vehicle){
        this.vehicle = vehicle;

    }

    public void addVehicle(int carId, String carName, String carBrand, String carType){
        try (Connection connection = Database.getConnection()){
            String sql = "INSERT INTO VEHICLE (carId,carName,carBrand) VALUES (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carId);
            stmt.setString(2,carName);
            stmt.setString(3,carBrand);
            stmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }

    }
    public void removeVehicle(int carId){
        try (Connection connection = Database.getConnection()){
            String sql = "DELETE FROM VEHICLE WHERE carId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carId);
            stmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
    public void viewAllVehicles(){
        try (Connection connection =Database.getConnection()){

        }catch (SQLException e){

        }
    }

}
