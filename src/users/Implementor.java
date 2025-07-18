package users;

import util.Database;
import service.SystemService;
import java.sql.Connection;
import java.sql.SQLException;

public class Implementor extends Employee{
    SystemService systemService;
    public Implementor (Integer empId, String empName, Double empSalary,String empRole){
        super(empId,empName,empSalary,empRole);
    }


    public Implementor() {
        super();
    }

    public void viewRentedVehicles(){
        try (Connection connection = Database.getConnection()){

        }catch (SQLException e ){
            System.out.println("ERROR");
        }
    }

    public void addVehicle(int carId, String carName, String carBrand,String carType){
        systemService.addVehicle(carId,carName,carBrand, carType);
    }
}
