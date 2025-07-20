package service;

import util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SystemService {
    public SystemService (){
    }

    public void addVehicle(int carId, String carName, String carBrand, String carType,String status,double rentPrice){
        try (Connection connection = Database.getConnection()){
            String sql = "INSERT INTO VEHICLE (carId,carName,carBrand,status,rentPrice) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carId);
            stmt.setString(2,carName);
            stmt.setString(3,carBrand);
            stmt.setString(4,status);
            stmt.setDouble(5,rentPrice);
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
            String sql = "SELECT * FROM VEHICLE LEFT JOIN RENTED ON vehicle.carId = rented.carId";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                String carType = rs.getString("carType");
                String status = rs.getString("status");
                boolean available = rs.getBoolean("available");
                double rentPrice = rs.getDouble("rentPrice");

                System.out.println("Car ID: "+ carId + ", Name: " + carName + ", Brand: " + carBrand + "Type: " + carType + ", Status: "+ status + ", rent price: " + rentPrice +", Available: " + available +"\n");
            }

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
    public void viewRentedVehicles(){
        try (Connection connection = Database.getConnection()){
            String sql = "SELECT carId, carName,carBrand, carType,status FROM VEHICLE WHERE available = false";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()){
                System.out.println("There aren't vehicles in rent");
            }
            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                String carType = rs.getString("carType");
                String status = rs.getString("status");

                System.out.println("Car ID: "+ carId + ", Name: " + carName + ", Brand: " + carBrand + ", Type: " + carType + ", Status: "+ status);
            }
        }catch (SQLException e ){
            System.out.println("ERROR");
        }
    }

}
