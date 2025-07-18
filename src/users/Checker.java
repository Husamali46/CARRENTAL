package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Database;
import product.Vehicle;


public class Checker extends Employee{
    public Checker (Integer empId, String empName, Double empSalary,String empRole){
        super(empId,empName,empSalary,empRole);
    }


    public Checker() {
        super();
    }

    public void viewCheckVehicles(){
        try (Connection connection = Database.getConnection()){

        }catch (SQLException e ){
            System.out.println("ERROR");
        }
    }

    public  void deliverVehicle(){

    }

}
