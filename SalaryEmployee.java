
import java.text.NumberFormat;
import java.util.Locale;

public class SalaryEmployee extends Employee {
      int monthPay;
      boolean bonus;

    public SalaryEmployee(String employeeName,String employeeType, int monthPay, boolean bonus) {
        super(employeeName,employeeType);
        this.monthPay = monthPay;
        this.bonus = bonus;
    }

    public String getTableData(){
        return String.format("%-14s SALARY                                           %s%s",employeeName,
                NumberFormat.getCurrencyInstance(Locale.US).format(getCalculation()),bonus ? "*" : "");
    }

    public double getCalculation(){
       if (!bonus){
           return monthPay/4;
       }else{
           double weekpay = monthPay/4;
           return weekpay+(weekpay*.1);
       }
        }
    }

