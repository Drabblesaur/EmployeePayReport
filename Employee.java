

public abstract class Employee{
    public  String employeeName;
    public  String employeeType;

    public Employee(String employeeName,String employeeType){
        this.employeeName = employeeName;
        this.employeeType = employeeType;
    }

    public abstract String getTableData();
    public abstract double getCalculation();
}
