package product;

import util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Regular extends Vehicle{
    public Regular (Integer carId, String carName, String carBrand,String carType,String status,double rentPrice,boolean available){
        super(carId,carName,carBrand,carType,status,rentPrice,available);

    }
    public Regular() {
        super();
    }

    public void viewRegular(){
        try (Connection connection = Database.getConnection()){
            String sql = "SELECT carId, carName,carBrand,rentPrice FROM VEHICLE WHERE available = true AND carType = 'regular'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                double rentPrice = rs.getDouble("rentPrice");

                System.out.println("Car ID: "+ carId + ", Name: " + carName + ", Brand: " + carBrand + ", rentPrice: " + rentPrice);
            }

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
}
