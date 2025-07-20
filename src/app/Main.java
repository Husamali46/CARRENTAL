package app;

import product.Bikes;
import product.OverLander;
import product.Regular;
import users.Checker;
import users.Implementor;
import users.Manager;
import users.Customer;
import service.SystemService;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Implementor implementor = new Implementor();
        Checker checker = new Checker();
        OverLander overLander = new OverLander();
        Bikes bike = new Bikes();
        Regular regular = new Regular();
        Manager manager = new Manager();
        Customer customer = new Customer();
        SystemService systemService = new SystemService();

        try {
            out.println("""
                        What is your role :
                        \s
                        1. Manager.
                        2. Employee.
                        3. Customer.
                        """
            );
            int role = sc.nextInt();

            if (role == 1){
                out.println("Enter your Id");
                int manId = sc.nextInt();

                if (!manager.managerCheck(manId)) {
                    out.println("Your Id is wrong");
                    return;
                }else {
                    out.println("Welcome Mr " + manager.manName + "\n");

                    out.println("""
                        What do you want to do :
                        \s
                        1. Add an employee.
                        2. Remove an employee.
                        3. Add a vehicle.
                        4. Remove a vehicle.
                        5. View all vehicles.
                        6. View rented vehicles.
                        """);
                    int choice = sc.nextInt();
                    switch (choice){
                        case 1: {
                            out.println("""
                            What do you want to add :
                            \s
                            1. Implementor
                            2. Checker
                            """);
                            int ans = sc.nextInt();
                            out.println("Enter the Id of the new employee");
                            int empId = sc.nextInt();
                            if ((ans == 1 && implementor.employeeCheck(empId)) || (ans == 2 && checker.employeeCheck(empId))){
                                out.println("This employee is already exist");
                                return;
                            }
                            sc.nextLine();
                            out.println("Enter his name :");
                            String empName = sc.nextLine();

                            out.println("Enter his salary :");
                            Double empSalary = sc.nextDouble();

                            manager.addEmployee(empId, empName, empSalary,ans == 1? "Implementor" : "Checker");

                            out.println("Employee added.");
                            break;

                        } case 2: {
                            out.println("Enter the Id of the new employee");
                            int empId = sc.nextInt();

                            if (!implementor.employeeCheck(empId) || !checker.employeeCheck(empId)){
                                out.println("This employee does not exist");
                                return;
                            }
                            manager.removeEmployee(empId);
                            out.println("Employee Removed.");
                            break;

                        } case 3: {
                            out.println("""
                            What is the type of the vehicle :
                            \s
                            1. OverLander.
                            2. Bike.
                            3. Regular.
                            """);
                            int type = sc.nextInt();

                            out.println("Enter the Id of the new car");
                            int carId = sc.nextInt();

                            if ((type == 1 && overLander.vehicleCheck(carId)) ||
                                    (type == 2 && bike.vehicleCheck(carId)) ||
                                    (type == 3 && regular.vehicleCheck(carId))) {
                                out.println("The vehicle already exists");
                                return;
                            }
                            sc.nextLine();
                            out.println("Enter its name");
                            String carName = sc.nextLine();

                            out.println("Enter its brand");
                            String carBrand = sc.nextLine();

                            out.println("Enter its rent price");
                            double rentPrice = sc.nextDouble();

                            out.println("Enter its status");
                            String status = sc.nextLine();
                            manager.addVehicle(carId, carName, carBrand,type == 1 ? "OverLand" : type == 2 ? "Bike" : type == 3 ? "Regular" : "unknown", status ,rentPrice);
                            out.println("Vehicle added");
                            break;
                        } case 4 : {
                            out.println("Enter the Id of the new car");
                            int carId = sc.nextInt();
                            if (!overLander.vehicleCheck(carId) && !bike.vehicleCheck(carId) && !regular.vehicleCheck(carId)){
                                out.println("This Vehicle does not exist");
                                return;
                            }
                            manager.removeVehicle(carId);
                            out.println("Vehicle removed");
                            break;
                        }
                        case 5: systemService.viewAllVehicles(); break;
                        case 6: systemService.viewRentedVehicles(); break;
                        default: out.println("Invalid input");
                    }

                }
            }else if (role == 2) {
                out.println("""
                    Are you checker or implementor :
                    \s
                    1. Checker
                    2. Implementor
                    """);
                int me = sc.nextInt();
                out.println("Enter your Id");
                int empId = sc.nextInt();

                if (me == 1){
                    if (!checker.employeeCheck(empId)) {
                        out.println("Your Id is wrong");
                        return;
                    }else {
                        out.println("""
                            What do you want to do :
                            1. View all vehicles
                            2. View Vehicles needs to be checked
                            3. Deliver a vehicle
                            """);
                        int ans = sc.nextInt();

                        switch (ans){
                            case 1: systemService.viewAllVehicles(); break;
                            case 2: checker.viewCheckVehicles(); break;
                            case 3: {
                                out.println("Enter the id of the vehicle you want to deliver");
                                int carId = sc.nextInt();

                                if (!overLander.vehicleCheck(carId) && !bike.vehicleCheck(carId) && !regular.vehicleCheck(carId)){
                                    out.println("This vehicle does not exist");

                                }else {
                                    out.println("Enter its status");
                                    String status = sc.nextLine();

                                    checker.deliverVehicle(carId,status);
                                }
                                break;
                            }
                            default: out.println("Invalid input");
                        }
                    }
                }else if (me == 2) {
                    if (!implementor.employeeCheck(empId)) {
                        out.println("Your Id is wrong");
                        return;
                    }else{
                        out.println("""
                            What do you want to do :
                            1. View all vehicles
                            2. View rented vehicles
                            3. Add a vehicle
                            """);
                        int ans = sc.nextInt();

                        switch (ans){
                            case 1: systemService.viewAllVehicles(); break;
                            case 2: checker.viewCheckVehicles(); break;
                            case 3: {
                                out.println("""
                            What is the type of the vehicle :
                            \s
                            1. OverLander.
                            2. Bike.
                            3. Regular.
                            """);
                                int type = sc.nextInt();

                                out.println("Enter the Id of the new car");
                                int carId = sc.nextInt();

                                if ((type == 1 && overLander.vehicleCheck(carId)) ||
                                        (type == 2 && bike.vehicleCheck(carId)) ||
                                        (type == 3 && regular.vehicleCheck(carId))) {
                                    out.println("The vehicle already exists");
                                    return;
                                }
                                sc.nextLine();
                                out.println("Enter its name");
                                String carName = sc.nextLine();

                                out.println("Enter its brand");
                                String carBrand = sc.nextLine();

                                out.println("Enter its rent price");
                                double rentPrice = sc.nextDouble();

                                out.println("Enter its status");
                                String status = sc.nextLine();
                                manager.addVehicle(carId, carName, carBrand,type == 1 ? "OverLand" : type == 2 ? "Bike" : type == 3 ? "Regular" : "unknown",status,rentPrice);
                                out.println("Vehicle added");
                                break;

                            } default: out.println("Invalid input");
                        }
                    }
                }else {
                    out.println("ERROR");

                }
            } else if (role == 3) {
                out.println("""
                    Do You have an account :
                    \s
                    1. Yes
                    2. No
                    """);
                int acc = sc.nextInt();

                if (acc == 1 ){
                    out.println("Enter your Id");
                    int cstId = sc.nextInt();

                    if(!customer.customerCheck(cstId)){
                        out.println("Your Id is wrong");

                    }else {
                        out.println("Welcome Mr " + customer.cstName + "\n");

                    }
                } else if (acc == 2) {
                    sc.nextLine();
                    out.println("Enter your name");
                    String cstName = sc.nextLine();

                    String pre = "3";
                    int random = (int) (Math.random() *1000000 );
                    String fTed = String.format("%07d",random);
                    String num = pre + fTed;
                    int cstId = Integer.parseInt(num);

                    out.println("Your Id is " + cstId + " do not forget it");
                    customer.addCustomer(cstId,cstName);

                    out.println("Welcome Mr " + cstName + "\n");

                }
                out.println("""
                            What do you want to see :
                            \s
                            1. See all available vehicles.
                            2. See overlander vehicles.
                            3. See bikes.
                            4. See Regular vehicles.
                            5. Rent a car.
                            6. Return a car.
                            """);
                int ans = sc.nextInt();
                switch (ans){
                    case 1: customer.viewAvailableVehicle(); break;
                    case 2: overLander.viewOverLander(); break;
                    case 3: bike.viewBikes(); break;
                    case 4: regular.viewRegular(); break;
                    case 5: {
                        out.println("Enter the id of the vehicle");
                        int carId = sc.nextInt();

                        if(!overLander.vehicleCheck(carId) && !bike.vehicleCheck(carId) && !regular.vehicleCheck(carId)){
                            out.println("The Id is wrong");
                            return;

                        }else {
                            customer.rentVehicle(carId);

                        }
                        break;
                    }
                    case 6: {
                        out.println("Enter the id of the vehicle");
                        int carId = sc.nextInt();

                        if (!overLander.vehicleCheck(carId) && !bike.vehicleCheck(carId) && !regular.vehicleCheck(carId)) {
                            out.println("The Id is wrong");
                            return;

                        }else {
                        customer.returnVehicle(carId);
                        }break;
                    } default: out.println("Invalid input");
                }
            }else {
                out.println("Invalid input");

            }
        }catch (Exception e){
            out.println("ERROR");
        }
    }
}