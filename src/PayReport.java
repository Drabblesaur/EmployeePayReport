package src;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import src.Classes.Employee;

public class PayReport {
    public static void main(String args[]) {

        // Receive the finished Array List from employeeType()
        ArrayList<Employee> employeeObjectFinal = employeeType();

        //Table Creation
        double total = 0;
        System.out.println("NAME          |CLASS          | HOURS   | SALES     | RATE     | WEEKLY PAY         ");
        System.out.println("====================================================================================");
        for (int i = 0; i < employeeObjectFinal.size(); i++) {
            Employee employee = employeeObjectFinal.get(i);
            System.out.println(employee.getTableData());
            total += employee.getCalculation();
        }
        System.out.println("====================================================================================");
        System.out.println("TOTAL:" + NumberFormat.getCurrencyInstance(Locale.US).format(total));
        System.out.println("*A 10% bonus is awarded");

    }
    private static ArrayList<Employee> employeeType(){
        System.out.println("Welcome!");

        //Create a new Array List to store the employee objects
        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        //Setup for the Initial Input
        boolean employeeEntry = false;
        Scanner input = new Scanner(System.in);
        EmployeeFactory employeeFactory = new EmployeeFactory();

        //Initial employee creation group
        do {
            System.out.println("What is the type of the employee?");
            System.out.println("0. Finished Entry");
            System.out.println("1. Salary");
            System.out.println("2. Hourly");
            System.out.println("3. Commissioned");
            System.out.print("TYPE:");
            int type = input.nextInt();

            // Initial data gets sent over to Employee.EmployeeFactory for further specification
            switch (type) {
                case 0:
                    employeeEntry = true;
                    break;
                case 1:
                    System.out.println("Employee's first name?");
                    String firstName = input.next();
                    System.out.println("Last name?");
                    String lastName  = input.next();
                    String employeeName1 = (firstName+" "+lastName);

                    //Instance received from createEmployeeInfo() is added into the array list.
                    Employee newEmp = employeeFactory.createEmployeeInfo(employeeName1,"SALARY");
                    if (IsEmployeeReal(newEmp)) {
                        employeeArrayList.add(newEmp);
                    }
                    break;
                case 2:
                    System.out.println("Employee's first name?");
                     firstName = input.next();
                    System.out.println("Last name?");
                     lastName  = input.next();
                    String employeeName2 = (firstName+" "+lastName);
                    Employee newEmp1 = employeeFactory.createEmployeeInfo(employeeName2,"HOURLY");
                    if (IsEmployeeReal(newEmp1)) {
                        employeeArrayList.add(newEmp1);
                    }
                    break;
                case 3:
                    System.out.println("Employee's first name?");
                     firstName = input.next();
                    System.out.println("Last name?");
                     lastName  = input.next();
                    String employeeName3 = (firstName+" "+lastName);
                    Employee newEmp2 = employeeFactory.createEmployeeInfo(employeeName3,"COMMISSION");
                    if (IsEmployeeReal(newEmp2)) {
                        employeeArrayList.add(newEmp2);
                    }
            }
        }while(!employeeEntry);
        return employeeArrayList;
    }
    public static boolean IsEmployeeReal(Employee nEmployee){
        if (nEmployee instanceof Employee){
            return true;
        }else return false;
    }
    }