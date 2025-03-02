public class HourlySalaryEmployee extends StaffMember {
    private int hourWork;
    private double rate;


    public HourlySalaryEmployee(int id, String name, String address, int hourWork, double rate){
        super(id ,name, address);
        this.hourWork= hourWork;
        this.rate= rate;
    }

    public int getHourWork() {
        return hourWork;
    }

    public void setHourWork(int hourWork) {
        this.hourWork = hourWork;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "hourWork=" + hourWork +
                ", rate=" + rate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public double pay() {

        return 0;
    }
}
