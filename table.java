import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Scanner;

public class table {

    public static void displayEmployee(List<StaffMember> employees) {
        final int PAGE_SIZE = 3; // Number of employees per page
        Scanner scanner = new Scanner(System.in);
        int currentPage = 1;
        int totalPages = (int) Math.ceil((double) employees.size() / PAGE_SIZE);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            Table t = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);

            t.addCell("      DISPLAY EMPLOYEE (Page: " + currentPage + "/" + totalPages + ")      ", cellStyle, 9);
            t.addCell("      TYPE      ", cellStyle);
            t.addCell("      ID        ", cellStyle);
            t.addCell("      NAME      ", cellStyle);
            t.addCell("      ADDRESS      ", cellStyle);
            t.addCell("      SALARY      ", cellStyle);
            t.addCell("      BONUS      ", cellStyle);
            t.addCell("      HOUR      ", cellStyle);
            t.addCell("      RATE      ", cellStyle);
            t.addCell("      PAYMENT      ", cellStyle);

            int startIndex = (currentPage - 1) * PAGE_SIZE;
            int endIndex = Math.min(startIndex + PAGE_SIZE, employees.size());

            for (int i = startIndex; i < endIndex; i++) {
                StaffMember emp = employees.get(i);
                String type = "Unknown";
                if (emp instanceof Volunteer) {
                    Volunteer v = (Volunteer) emp;
                    type = "Volunteer";
                    t.addCell(type, cellStyle);
                    t.addCell(String.valueOf(emp.id), cellStyle);
                    t.addCell(emp.name, cellStyle);
                    t.addCell(emp.address, cellStyle);
                    t.addCell("$"+v.getSalary(), cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("$"+v.pay(), cellStyle);
                } else if (emp instanceof SalariedEmployee) {
                    SalariedEmployee s = (SalariedEmployee) emp;
                    type = "Salaried Employee";
                    t.addCell(type, cellStyle);
                    t.addCell(String.valueOf(emp.id), cellStyle);
                    t.addCell(emp.name, cellStyle);
                    t.addCell(emp.address, cellStyle);
                    t.addCell("$"+s.getSalary(), cellStyle);
                    t.addCell("%"+s.getBunus(), cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("$"+s.pay(), cellStyle);
                } else if (emp instanceof HourlySalaryEmployee) {
                    HourlySalaryEmployee h = (HourlySalaryEmployee) emp;
                    type = "Hourly Employee";
                    t.addCell(type, cellStyle);
                    t.addCell(String.valueOf(emp.id), cellStyle);
                    t.addCell(emp.name, cellStyle);
                    t.addCell(emp.address, cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell("---", cellStyle);
                    t.addCell(h.getHourWork()+"h", cellStyle);
                    t.addCell("%"+h.getRate(), cellStyle);
                    t.addCell("$"+h.pay(), cellStyle);
                }
            }
            System.out.println( t.render());
            System.out.println("Pages: " + currentPage + "/" + 3);
            System.out.println("1. First Page \t2. Next Page \t3. Previous Page \t4. Last Page  \t5. Quit");
            System.out.print("Enter your choice: ");
            String choice;
            while (true) {
                System.out.print("Enter your choice (1-5): ");


                if ((choice = scanner.nextLine().trim()).matches("[1-5]")) break;
                System.out.println(  " Invalid input! Please enter a number between 1 and 5."  );
            }
            switch (choice) {
                case "1":
                    currentPage = 1;
                    break;
                case "2":
                    if (currentPage < totalPages) currentPage++;
                    break;
                case "3":
                    if (currentPage > 1) currentPage--;
                    break;
                case "4":
                    currentPage = totalPages;
                    break;
                case "5":
                    System.out.println("Exist case3");
                    return;
                default:
                    System.out.println( "Invalid input. Please try again." );
            }
        }
    }
}
