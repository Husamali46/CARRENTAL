package users;

import service.SystemService;

public class Implementor extends Employee{
    SystemService systemService;
    public Implementor (Integer empId, String empName, Double empSalary,String empRole){
        super(empId,empName,empSalary,empRole);
    }


    public Implementor() {
        super();
    }

    public void viewRentedVehicles(){
        systemService.viewRentedVehicles();
    }

    public void addVehicle(int carId, String carName, String carBrand,String carType,String status,double rentPrice){
        systemService.addVehicle(carId,carName,carBrand, carType,status,rentPrice);
    }
}
