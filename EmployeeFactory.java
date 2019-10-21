
import java.util.InputMismatchException;
import java.util.Scanner;
public class EmployeeFactory {

    //CreateEmployeeInfo receives the data given from employeeType()
    public static Employee createEmployeeInfo(String employeeName, String type) {
        Scanner input = new Scanner(System.in);

        // String type is checked, then prompts user for type specific information.
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("SALARY")) {
            boolean CheckComplete = false;
                try{
                System.out.println("(" + employeeName + ") MONTHLY SALARY:");
                    int monthPay = input.nextInt();
                System.out.println("Did this employee receive a bonus?");
                System.out.println("YES=1 | NO=0");
                    int salaryBonus = input.nextInt();
                // Returns the created object (Class Specific) back to employeeType()
                if (salaryBonus == 1) {
                    CheckComplete = true;
                    return new SalaryEmployee(employeeName, type, monthPay, true);
                } else if (salaryBonus == 0) {
                    return new SalaryEmployee(employeeName, type, monthPay, false);
                }
                }catch (InputMismatchException e){
                    System.out.println(e+"Please Try Again");
                }
        } else if (type.equalsIgnoreCase("HOURLY")) {
            System.out.println("(" + employeeName + ") HOURLY RATE:");
            double hoursRate = input.nextDouble();
            System.out.println("(" + employeeName + ") HOURS WORKED:");
            int hoursWorked = input.nextInt();
            return new HourlyEmployee(employeeName,type,hoursWorked,hoursRate);

        } else if (type.equalsIgnoreCase("COMMISSION")) {
            System.out.println("WEEKLY SALES");
            int weekSales = input.nextInt();
            return new CommissionEmployee(employeeName, type, weekSales);
        }

        return null;
    }
}
