package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Database;

public class Checker extends Employee{
    public Checker (Integer empId, String empName, Double empSalary,String empRole){
        super(empId,empName,empSalary,empRole);
    }

    public Checker() {
        super();
    }

    public void viewCheckVehicles(){
        try (Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM RENTED WHERE AVAILABLE = TRUE";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                String carType = rs.getString("carType");

                System.out.println("Car ID: "+ carId + ", Name: " + carName + ", Brand: " + carBrand + ", Type: " + carType);
            }

        }catch (SQLException e ){
            System.out.println("ERROR");
        }
    }

    public  void deliverVehicle(int carId,String status){
        try (Connection connection = Database.getConnection()){
            String sql = "UPDATE VEHICLE SET status = ? AND available = true WHERE carId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,status);
            stmt.setInt(2,carId);
            stmt.executeUpdate();

            String sql1 = "DELETE FROM RENTED WHERE carId = ?";
            PreparedStatement stmt1 = connection.prepareStatement(sql1);
            stmt1.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }

}
