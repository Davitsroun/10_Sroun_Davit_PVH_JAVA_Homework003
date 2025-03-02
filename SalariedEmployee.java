public class SalariedEmployee extends  StaffMember {
    private double Salary;
    private double bunus;
    public SalariedEmployee(int id, String name, String address, double Salary , double bunus){
        super(id, name,address);
        this.Salary= Salary;
        this.bunus = bunus;

    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public double getBunus() {
        return bunus;
    }

    public void setBunus(double bunus) {
        this.bunus = bunus;
    }

    @Override
    public double pay() {
        return getSalary()+ bunus;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "Salary=" + Salary +
                ", bunus=" + bunus +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}