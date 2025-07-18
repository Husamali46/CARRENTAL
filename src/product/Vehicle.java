package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Database;
import service.SystemService;

public abstract class Vehicle {
    int carId;
    String carName;
    String carBrand;
    String carType;

    public Vehicle(int carId,String carName,String carBrand,String carType){
        this.carId = carId;
        this.carName = carName;
        this.carBrand = carBrand;
        this.carType = carType;
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
