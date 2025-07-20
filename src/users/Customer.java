package users;

import util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    public int cstId;
    public String cstName;

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
    public void rentVehicle(int carID){
        try(Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM VEHICLE WHERE carId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                String carBrand = rs.getString("carBrand");
                String carType = rs.getString("carType");
                String status = rs.getString("status");
                boolean available = rs.getBoolean("available");

                String sql1 = "INSERT INTO rented (carId, carName,carBrand, carType,status,available) VALUES (?,?,?,?,?,?)";
                PreparedStatement stmt1 = connection.prepareStatement(sql1);
                stmt1.setInt(1,carId);
                stmt1.setString(2,carName);
                stmt1.setString(3,carBrand);
                stmt1.setString(4,carType);
                stmt1.setString(5,status);
                stmt1.setBoolean(6,false);
                stmt1.executeUpdate();
            }
            String sql2 = "UPDATE VEHICLE SET available = false WHERE carId = ?";
            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1,carID);
            stmt2.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }
    public void returnVehicle(int carId){
        try (Connection connection = Database.getConnection()){
            String sql = "UPDATE rented SET available = true WHERE carId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,carId);
            stmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
