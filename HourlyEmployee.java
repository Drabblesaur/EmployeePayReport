
import java.text.NumberFormat;

public class HourlyEmployee extends Employee {
     int hoursWorked;
     double hoursRate;

    public HourlyEmployee(String employeeName, String employeeType, int hoursWorked, double hoursRate){
        super(employeeName,employeeType);
        this.hoursWorked = hoursWorked;
        this.hoursRate = hoursRate;
    }

    public String getTableData(){
    return String.format("%-14s HOURLY          %-3d                   %-10s %s",employeeName,hoursWorked,
            NumberFormat.getCurrencyInstance().format(hoursRate),
            NumberFormat.getCurrencyInstance().format(getCalculation()));
    }

    public double getCalculation(){
        if (hoursWorked>=40){
            return ((hoursWorked-(hoursWorked-40))*hoursRate) + ((hoursWorked-40)*(hoursRate*2));
        }else{
            double weekPaied = hoursWorked*hoursRate;
            return weekPaied;
        }

    }
}

