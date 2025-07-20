package users;

import util.Database;
import product.Bikes;
import product.Regular;
import product.OverLander;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    public int cstId;
    public String cstName;
    Bikes bike;
    Regular regular;
    OverLander overLander;

    public Customer(int cstId,String cstName){
        this.cstId = cstId;
        this.cstName = cstName;
    }

    public Customer() {

    }
    public void addCustomer(int cstId,String cstName){
        try (Connection connection = Database.getConnection()){
            String sql = "INSERT INTO CUSTOMER (cstId,cstName) VALUES (?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cstId);
            stmt.setString(2,cstName);
            stmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
    public boolean customerCheck(int cstId){
        try(Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM CUSTOMER WHERE cstId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cstId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                this.cstName = rs.getString("cstName");
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
            return false;
        }
    }
    public void viewAvailableVehicle(){
        try (Connection connection = Database.getConnection()){
            String sql = "SELECT carId, carName,carBrand, carType,status, rentPrice FROM VEHICLE WHERE available = true";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                String carType = rs.getString("carType");
                String status = rs.getString("status");
                double renPrice = rs.getDouble("rentPrice");

                System.out.println("Car ID: "+ carId + ", Name: " + carName + ", Brand: " + carBrand + ", Type: " + carType + ", Status: " + status +", rent Price: " + renPrice);
            }

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
    public void rentVehicle(){

    }
    public void returnVehicle(){

    }
}
