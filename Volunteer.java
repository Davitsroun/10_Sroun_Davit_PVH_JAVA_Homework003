import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class Volunteer extends StaffMember{
    private double salary;


    public  Volunteer(int id, String name, String address ,double salary){
        super(id , name, address);
        this.salary= salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public double pay( ) {

        return salary;
    }


}
