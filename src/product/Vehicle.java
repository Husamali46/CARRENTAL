package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Database;


public abstract class Vehicle {
    int carId;
    String carName;
    String carBrand;
    String carType;
    String status;
    double rentPrice;
    boolean available;

    public Vehicle(int carId,String carName,String carBrand,String carType,String status,double rentPrice,boolean available){
        this.carId = carId;
        this.carName = carName;
        this.carBrand = carBrand;
        this.carType = carType;
        this.status = status;
        this.rentPrice = rentPrice;
        this.available = available;
    }
    public Vehicle() {

    }

    public boolean vehicleCheck(int carId){
        try (Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM VEHICLE WHERE carId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carId);

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
            return false;
        }
    }

}
