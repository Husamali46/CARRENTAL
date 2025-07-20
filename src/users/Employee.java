package users;

import util.Database;
import java.sql.*;
import service.SystemService;

public abstract class Employee {
    int empId;
    String empName;
    Double empSalary;
    String empRole;
    public Manager manager;
    SystemService systemService;

    public Employee (int empId, String empName,double empSalary,String empRole){
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empRole = empRole;
    }
    public Employee() {
    }

    public boolean employeeCheck (Integer empId) {
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM EMPLOYEE WHERE empId = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, empId);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("ERROR");
            e.printStackTrace();
            return false;

        }
    }
}
