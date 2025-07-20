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
}
