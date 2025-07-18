package app;

import product.Bikes;
import product.OverLander;
import product.Regular;
import users.Checker;
import users.Implementor;
import users.Manager;


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

            if (manager.managerCheck(manId)) {
                out.println("Welcome Mr " + manager.manName + "\n");

                out.println("""
                        What do you want to do :
                        \s
                        1. Add an employee.
                        2. Remove an employee.
                        3. Add a vehicle.
                        4. Remove a vehicle.
                        """);
                int choice = sc.nextInt();
                if (choice == 1) {
                    out.println("""
                            What do you want to add :
                            \s
                            1. Implementor
                            2. Checker
                            """);
                    int ans = sc.nextInt();
                    out.println("Enter the Id of the new employee");
                    int empId = sc.nextInt();
                    if (ans == 1) {
                        if (!implementor.employeeCheck(empId)) {
                            sc.nextLine();
                            out.println("Enter his name :");
                            String empName = sc.nextLine();

                            out.println("Enter his salary :");
                            Double empSalary = sc.nextDouble();

                            String empRole = "Implementor";
                            manager.addEmployee(empId, empName, empSalary,empRole);

                            out.println("Employee added.");

                        } else {
                            out.println("The employee is already exist");

                        }

                    } else if (ans == 2) {
                        if (!checker.employeeCheck(empId)) {
                            sc.nextLine();
                            out.println("Enter his name");
                            String empName = sc.nextLine();

                            out.println("Enter his salary :");
                            Double empSalary = sc.nextDouble();

                            String empRole = "Checker";
                            manager.addEmployee(empId, empName, empSalary,empRole);

                            out.println("Employee added.");

                        } else {
                            out.println("The employee is already exist");

                        }


                    } else {
                        out.println("Invalid input");

                    }

                } else if (choice == 2) {
                    out.println("Enter the Id of the new employee");
                    int empId = sc.nextInt();
                    if (checker.employeeCheck(empId)) {
                        manager.removeEmployee(empId);

                        out.println("Employee Removed.");

                    } else if (implementor.employeeCheck(empId)) {
                        manager.removeEmployee(empId);

                        out.println("Employee Removed.");

                    } else {
                        out.println("Employee does not exist");

                    }
                } else if (choice == 3) {
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

                    if (type == 1) {
                        if (!overLander.vehicleCheck(carId)) {
                            sc.nextLine();
                            out.println("Enter its name");
                            String carName = sc.nextLine();

                            out.println("Enter its brand");
                            String carBrand = sc.nextLine();

                            String carType = "OverLander";
                            manager.addVehicle(carId, carName, carBrand,carType);

                            out.println("Vehicle added");
                        } else {
                            out.println("The vehicle is already exist");

                        }
                    } else if (type == 2) {
                        if (!bike.vehicleCheck(carId)) {
                            sc.nextLine();
                            out.println("Enter its name");
                            String carName = sc.nextLine();

                            out.println("Enter its brand");
                            String carBrand = sc.nextLine();

                            String carType = "Bike";
                            manager.addVehicle(carId, carName, carBrand,carType);

                            out.println("Vehicle added");
                        } else {
                            out.println("The vehicle is already exist");

                        }
                    } else if (type == 3) {
                        if (!regular.vehicleCheck(carId)) {
                            sc.nextLine();
                            out.println("Enter its name");
                            String carName = sc.nextLine();

                            out.println("Enter its brand");
                            String carBrand = sc.nextLine();

                            String carType = "Regular";
                            manager.addVehicle(carId, carName, carBrand,carType);

                            out.println("Vehicle added");
                        } else {
                            out.println("The vehicle is already exist");

                        }
                    } else {
                        out.println("This type does not exist");

                    }
                } else if (choice == 4) {
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

                    if (type == 1) {
                        manager.removeVehicle(carId);
                        out.println("Vehicle removed");

                    } else if (type == 2) {
                        manager.removeVehicle(carId);
                        out.println("Vehicle removed");

                    } else if (type == 3) {
                        manager.removeVehicle(carId);
                        out.println("Vehicle removed");

                    } else {
                        out.println("Invalid type");

                    }
                }
            }else {
                out.println("Your Id is wrong");

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
                if (checker.employeeCheck(empId)){
                    out.println("""
                            What do you want to do :
                            1. View all vehicles
                            2. View Vehicles needs to be checked
                            3. Deliver a vehicle
                            """);
                    int ans = sc.nextInt();

                    if (ans == 1){
                        checker.viewAllVehicles();
                        
                    } else if (ans == 2) {
                        checker.viewCheckVehicles();
                        
                    } else if (ans == 3) {
                        checker.deliverVehicle();
                    }else {
                        out.println("Invalid input");

                    }
                }else {
                    out.println("Your Id is wrong");

                }
            } else if (me == 2) {
                if (implementor.employeeCheck(empId)){
                    out.println("""
                            What do you want to do :
                            1. View all vehicles
                            2. View rented vehicles
                            3. Add a vehicle
                            """);
                    int ans = sc.nextInt();

                    if (ans == 1){
                        implementor.viewAllVehicles();
                    } else if (ans == 2) {
                        implementor.viewRentedVehicles();
                    } else if (ans == 3) {
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

                        if (type == 1) {
                            if (!overLander.vehicleCheck(carId)) {
                                sc.nextLine();
                                out.println("Enter its name");
                                String carName = sc.nextLine();

                                out.println("Enter its brand");
                                String carBrand = sc.nextLine();

                                String carType = "OverLander";
                                implementor.addVehicle(carId, carName, carBrand,carType);

                                out.println("Vehicle added");
                            } else {
                                out.println("The vehicle is already exist");

                            }
                        } else if (type == 2) {
                            if (!bike.vehicleCheck(carId)) {
                                sc.nextLine();
                                out.println("Enter its name");
                                String carName = sc.nextLine();

                                out.println("Enter its brand");
                                String carBrand = sc.nextLine();

                                String carType = "Bike";
                                implementor.addVehicle(carId, carName, carBrand,carType);

                                out.println("Vehicle added");
                            } else {
                                out.println("The vehicle is already exist");

                            }
                        } else if (type == 3) {
                            if (!regular.vehicleCheck(carId)) {
                                sc.nextLine();
                                out.println("Enter its name");
                                String carName = sc.nextLine();

                                out.println("Enter its brand");
                                String carBrand = sc.nextLine();

                                String carType = "Regular";
                                implementor.addVehicle(carId, carName, carBrand,carType);

                                out.println("Vehicle added");
                            } else {
                                out.println("The vehicle is already exist");

                            }
                        } else {
                            out.println("This type does not exist");

                        }
                    }
                    }
                }else {
                out.println("Error");

            }

        }
    }
}