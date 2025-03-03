import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CompanyService {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
     static  int id =8;

    static  inputUtil inputUtil=new inputUtil();
     static Scanner sc= new Scanner(System.in);
     static   StaffMember volunteer;
     static StaffMember Salary;
     static   StaffMember Houry;
     static   ArrayList<StaffMember> list= new ArrayList<>(Arrays.asList(
            new Volunteer(1, "da", "opp", 23.5),
            new SalariedEmployee(2,"koko","pp",200,10),
            new HourlySalaryEmployee(3,"davit","pp",20,10),
            new HourlySalaryEmployee(4,"minh","btv",29,9),
            new SalariedEmployee(5,"sasa","kpc",300,10),
            new SalariedEmployee(6,"nara","kep",400,9),
            new Volunteer(7, "sakna", "tk", 43.5)
    ));


    static void Menu(){
        Table table=new Table(1, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle =new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0,40,40);
        table.addCell("STAFF MANAGEMENT SYSTEM",cellStyle );
        table.addCell("1. Insert Employee" );
        table.addCell("2. Update Employee"  );
        table.addCell("3. Dispaly Employee"  );
        table.addCell("4. Remove Employee" );
        table.addCell("5. Exist"  );
        System.out.println( table.render());


    }

    //case1
    public static void Insert(){

        System.out.println(ANSI_GREEN+"=========* Insert Employee *======="+ANSI_RESET);
        System.out.println("Chose Tye:");
        Table table=new Table(4, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle =new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0,30,30);
        table.setColumnWidth(1,30,30);
        table.setColumnWidth(2,30,30);
        table.setColumnWidth(3,30,30);
        table.addCell("1. Volunteer");
        table.addCell("2. Salaries  Emloyee");
        table.addCell("3. Hourly Employee");
        table.addCell("4. Back");
        System.out.println(table.render());
        String input1;

        do {
            System.out.print( ANSI_GREEN+"Chose option(1->4...)"+ANSI_RESET);
            input1= sc.nextLine();
            if (Pattern.matches("^[0-9]+$",input1)){
                break;
            }
            else {
                System.out.println(ANSI_RED + "Cannot input anythig beside number." + ANSI_RESET);}
        }while (true);
        int choise= Integer.parseInt(input1);
        System.out.println();

        switch (choise){
            case 1:{
                System.out.println("ID"+id);
                String name= inputUtil.Inputname("=> Enter your name");
                String address=  inputUtil.address("=> Enter your address:");
                Double salary = inputUtil.Inputbalance("=> Enter your salary:");
                volunteer = new Volunteer(id,name,address,salary);
                list.add(volunteer);
                id= id+1;
                System.out.println(ANSI_GREEN+"===Volunteer insert success===="+ANSI_RESET);
                break;
            }
            case 2:{
                System.out.println("ID:"+id);
                String name= inputUtil.Inputname("=> Enter your name:");
                String address=  inputUtil.address("=> Enter your address:");
                Double salary = inputUtil.Inputbalance("=> Enter your salary:");
                Double bunus = inputUtil.Inputbalance("=> Enter your bunus:");
               Salary = new SalariedEmployee(id, name, address ,salary,bunus);
               list.add(Salary);
                id= id+1;
                System.out.println(ANSI_GREEN+"===SalariedEmployee insert success===="+ANSI_RESET);

                break;
            }
            case 3:{
                System.out.println("ID:"+id);
                String name= inputUtil.Inputname("=> Enter your name:");
                String address=  inputUtil.address("=> Enter your address:");
                int hour= inputUtil.hour("=> Enter your hour:");
                double rate= inputUtil.InputRate("=> Enter your rate:");
                Houry= new HourlySalaryEmployee(id,name,address,hour,rate);
                list.add(Houry);
                id= id+1;
                System.out.println(ANSI_GREEN+"===HourlySalaryEmployee insert success===="+ANSI_RESET);
                break;
            }
            case 4:{

                    System.out.println(ANSI_RED+"Exit Case1"+ANSI_RESET);
                return;
            }
            default:
                System.out.println(ANSI_RED+"Invalid number"+ANSI_RESET);
        }



    }


    //case2
    public static void update() throws IndexOutOfBoundsException{
        System.out.println(ANSI_GREEN+"=========* Update Employee *======="+ANSI_RESET);

        String input1;

        do {
            System.out.print( ANSI_GREEN+"=> Enter Employee id:"+ANSI_RESET);
            input1= sc.nextLine();
            if (Pattern.matches("^[0-9]$",input1)){
                break;
            }
            else {
                System.out.println(ANSI_RED + "Cannot input anythig beside number." + ANSI_RESET);}
        }while (true);
        int choice= Integer.parseInt(input1);

        System.out.println();

        Table table=new Table(6, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        CellStyle cellStyle =new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0,30,30);
        table.setColumnWidth(1,30,30);
        table.setColumnWidth(2,30,30);
        table.setColumnWidth(3,30,30);
        table.setColumnWidth(4,30,30);
        table.setColumnWidth(5,30,30);
        table.addCell("Tye",cellStyle );
        table.addCell("ID",cellStyle );
        table.addCell("Name",cellStyle );
        table.addCell("Address",cellStyle );
        table.addCell("Salary",cellStyle );
        table.addCell("Pay",cellStyle );


        Table table2=new Table(7, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        table2.setColumnWidth(0,30,30);
        table2.setColumnWidth(1,30,30);
        table2.setColumnWidth(2,30,30);
        table2.setColumnWidth(3,30,30);
        table2.setColumnWidth(4,30,30);
        table2.setColumnWidth(5,30,30);
        table2.setColumnWidth(6,30,30);
        table2.addCell("Type",cellStyle );
        table2.addCell("ID",cellStyle );
        table2.addCell("Name",cellStyle );
        table2.addCell("Address",cellStyle );
        table2.addCell("Salary",cellStyle );
        table2.addCell("Bunus",cellStyle );
        table2.addCell("Pay",cellStyle );


        Table table3=new Table(7, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        table3.setColumnWidth(0,30,30);
        table3.setColumnWidth(1,30,30);
        table3.setColumnWidth(2,30,30);
        table3.setColumnWidth(3,30,30);
        table3.setColumnWidth(4,30,30);
        table3.setColumnWidth(5,30,30);
        table3.setColumnWidth(6,30,30);
        table3.addCell("Type");
        table3.addCell("ID",cellStyle );
        table3.addCell("Name",cellStyle );
        table3.addCell("Address",cellStyle );
        table3.addCell("Hourwork",cellStyle );
        table3.addCell("Rate",cellStyle );
        table3.addCell("Pay",cellStyle );

        boolean check = true;

        try {
            if (list.get(choice-1) != null  ){

                for (StaffMember s: list){

                    if (choice == s.id) {
                        check = true;
                        if (s instanceof Volunteer volunteer) {

                            table.addCell("Vounteer");
                            table.addCell(String.valueOf(volunteer.id));
                            table.addCell(volunteer.name);
                            table.addCell(volunteer.address);
                            table.addCell(String.valueOf(volunteer.getSalary()));
                            table.addCell(String.valueOf(volunteer.pay()));
                            System.out.println(table.render());


                                System.out.println();
                                System.out.println(ANSI_GREEN + "Choose one column to update: " + ANSI_RESET);
                                System.out.println("1. Name \t\t 2. Address \t\t 3. Salary \t\t 0.Cancel");
                                int select = inputUtil.hour("=> Select Column Number:");

                                switch (select) {
                                    case 1: {
                                        String setname = inputUtil.Inputname("=> Enter your new name: ");
                                        list.get(choice - 1).name = setname;
                                        System.out.println(ANSI_BLUE + "Name update success..." + ANSI_RESET);
                                        check=true;
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("=> Enter your new address: ");
                                        String setaddress = sc.next();
                                        list.get(choice - 1).address = setaddress;
                                        System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                        break;
                                    }
                                    case 3: {

                                        double setsalry = inputUtil.InputRate("=> Enter your new salary:");
                                        volunteer.setSalary(setsalry);
                                        System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                        break;
                                    }
                                    case 0: {
                                        System.out.println(ANSI_RED + "Exite..." + ANSI_RESET);

                                        return;
                                    }
                                    default: {
                                        System.out.println(ANSI_RED + "Invalid  option please try again...." + ANSI_RESET);
                                        break;
                                    }
                            }
                        } else if (s instanceof SalariedEmployee salariedEmployee) {
                            table2.addCell("SalariedEmployee", cellStyle);
                            table2.addCell(String.valueOf(salariedEmployee.id));
                            table2.addCell(salariedEmployee.name);
                            table2.addCell(salariedEmployee.address);
                            table2.addCell(String.valueOf(salariedEmployee.getSalary()));
                            table2.addCell(String.valueOf(salariedEmployee.getBunus()));
                            table2.addCell(String.valueOf(salariedEmployee.pay()));

                            System.out.println(table2.render());

                            System.out.println();
                            System.out.println(ANSI_GREEN + "Choose one column to update: " + ANSI_RESET);
                            System.out.println("1. Name \t\t 2. Address \t\t 3. Salary \t\t 4. Bunus  \t\t 0.Cancel");
                            int select = inputUtil.hour("=> Select Column Number:");
                            switch (select) {
                                case 1: {
                                    String setname = inputUtil.Inputname("=> Enter your new name: ");
                                    list.get(choice - 1).name = setname;
                                    System.out.println(ANSI_BLUE + "Name update success..." + ANSI_RESET);

                                    break;
                                }
                                case 2: {
                                    System.out.print("=> Enter your new address: ");
                                    String setaddress = sc.next();
                                    list.get(choice - 1).address = setaddress;
                                    System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                    break;
                                }
                                case 3: {

                                    double setsalry = inputUtil.InputRate("=> Enter your new salary:");
                                    salariedEmployee.setSalary(setsalry);
                                    System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                    break;
                                }
                                case 4: {
                                    double setbunus = inputUtil.Inputbalance("=> Enter your new Bunus");
                                    salariedEmployee.setBunus(setbunus);
                                    System.out.println(ANSI_BLUE + "Bunus update success..." + ANSI_RESET);
                                    break;
                                }
                                case 0: {
                                    System.out.println(ANSI_RED + "Exite..." + ANSI_RESET);
                                    return;
                                }
                                default: {
                                    System.out.println(ANSI_RED + "Invalid  option please try again...." + ANSI_RESET);
                                    break;
                                }
                            }

                        } else if (s instanceof HourlySalaryEmployee hourlySalaryEmployee) {
                            table3.addCell("HourlySalaryEmployee", cellStyle);
                            table3.addCell(String.valueOf(hourlySalaryEmployee.id));
                            table3.addCell(hourlySalaryEmployee.name);
                            table3.addCell(hourlySalaryEmployee.address);
                            table3.addCell(String.valueOf(hourlySalaryEmployee.getHourWork()));
                            table3.addCell(String.valueOf(hourlySalaryEmployee.getRate()));
                            table3.addCell(String.valueOf(hourlySalaryEmployee.pay()));

                            System.out.println(table3.render());


                            System.out.println();
                            System.out.println(ANSI_GREEN + "Choose one column to update: " + ANSI_RESET);
                            System.out.println("1. Name \t\t 2. Address \t\t 3. Hour \t\t 4. Rate  \t\t 0.Cancel");
                            int select = inputUtil.hour("=> Select Column Number:");
                            switch (select) {
                                case 1: {
                                    String setname = inputUtil.Inputname("=> Enter your new name: ");
                                    list.get(choice - 1).name = setname;
                                    System.out.println(ANSI_BLUE + "Name update success..." + ANSI_RESET);

                                    break;
                                }
                                case 2: {
                                    System.out.print("=> Enter your new address: ");
                                    String setaddress = sc.next();
                                    list.get(choice - 1).address = setaddress;
                                    System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                    break;
                                }
                                case 3: {

                                    int seethour = inputUtil.hour("=> Enter your new hour:");
                                    hourlySalaryEmployee.setHourWork(seethour);
                                    System.out.println(ANSI_BLUE + "Address update success..." + ANSI_RESET);

                                    break;
                                }
                                case 4: {
                                    double setRate = inputUtil.Inputbalance("=> Enter your new rate:");
                                    hourlySalaryEmployee.setRate(setRate);
                                    System.out.println(ANSI_BLUE + "Bunus update success..." + ANSI_RESET);
                                    break;
                                }
                                case 0: {
                                    System.out.println(ANSI_RED + "Exite..." + ANSI_RESET);
                                    return;
                                }
                                default: {
                                    System.out.println(ANSI_RED + "Invalid  option please try again...." + ANSI_RESET);
                                    break;
                                }
                            }
                        }
                        break;
                    }else {
                        check = false;

                    }
                }

            }
            if(!check){
                System.out.println(ANSI_RED+"Invalid id"+ANSI_RESET);
            }
            System.out.println();

        }catch (IndexOutOfBoundsException e){
            System.out.println(ANSI_RED+"Doesnot have that id"+ANSI_RESET);
        }


    }






    //caase4
    public static void delete() throws ConcurrentModificationException, IndexOutOfBoundsException {
        System.out.println(ANSI_BLUE+"=========Delete Employee=========="+ANSI_RESET);
        int delId= inputUtil.hour("=> Enter your id to delete:");

        try {
            while (true){
                for ( StaffMember s: list){
                    if(s.id == delId  ){
                        list.remove(s);
                        System.out.println("success");
                        return;
                    }
                }
                System.out.println(ANSI_RED+"Invalid"+ANSI_RESET);
                return;
            }



        }
        catch (ConcurrentModificationException e){

        }
        catch ( IndexOutOfBoundsException e){
            System.out.println(ANSI_RED+ delId+" doesnot exist"+ANSI_RESET);

        }
    }

    public static void main(String[] args) {

                String input1;
            do {
                Menu();
                do {
                    System.out.print( ANSI_GREEN+"Chose option(1->5...)"+ANSI_RESET);
                    input1= sc.nextLine();
                    if (Pattern.matches("^[0-9]$",input1)){
                        break;
                    }
                    else {
                        System.out.println(ANSI_RED + "Cannot input anythig beside number." + ANSI_RESET);}
                }while (true);
                int choise= Integer.parseInt(input1);
                System.out.println();
                switch (choise){
                    case 1:{
                        Insert();
                        break;
                    }
                    case 2:{
                        update();
                        break;
                    }
                    case 3:{
                        table.displayEmployee(list);


                        break;

                    }
                    case 4:{
                        delete();

                        break;
                    }
                    case 5:{
                        System.out.println(ANSI_RED+"Exist system"+ANSI_RESET);
                        return ;
                    }
                    default:
                        System.out.println(ANSI_RED+"Invalid number"+ANSI_RESET);
                }



            }while (true);






    }
}
