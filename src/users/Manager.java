package users;

import java.sql.*;
import service.SystemService;
import util.Database;
import java.sql.Connection;
import java.sql.SQLException;

public class Manager {
    private SystemService systemService;
    public int manId;
    public String manName;

    public Manager(int manId, String manName){
    this.manId = manId;
    this.manName = manName;
    }

    public Manager() {
    }

    public boolean managerCheck(int manId){
        try(Connection connection = Database.getConnection()){
            String sql = "SELECT * FROM MANAGER WHERE manId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,manId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                this.manName = rs.getString("manName");
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

    public void addEmployee(int empId ,String empName ,Double empSalary,String empRole){
        try(Connection connection = Database.getConnection()){
            String sql = "INSERT INTO EMPLOYEE (empId,empName,empSalary,empRole) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,empId);
            stmt.setString(2,empName);
            stmt.setDouble(3,empSalary);
            stmt.setString(4,empRole);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }

    public void removeEmployee(int empId){
        try (Connection connection = Database.getConnection()){
            String sql = "DELETE FROM EMPLOYEE WHERE empId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,empId);
            stmt.executeUpdate();


        }catch (SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();

        }
    }

    public void addVehicle(int carId, String carName, String carBrand,String carType,String status,double rentPrice){
        systemService.addVehicle(carId,carName,carBrand, carType,status,rentPrice);
    }

    public void removeVehicle(int carId){
        systemService.removeVehicle(carId);
    }


}
