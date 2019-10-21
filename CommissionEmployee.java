
import java.text.NumberFormat;

public class CommissionEmployee extends Employee {
    int weekSales;

    public CommissionEmployee(String employeeName,String employeeType, int weekSales){
        super(employeeName,employeeType);
        this.weekSales = weekSales;
    }

    public String getTableData(){
        return String.format("%-14s COMMISSION                %-5s             %s",employeeName,
                NumberFormat.getCurrencyInstance().format(weekSales),
                NumberFormat.getCurrencyInstance().format(getCalculation()));
    }

    public double getCalculation(){
      double weekPaied = weekSales*0.2;
      return weekPaied;
    }
}

