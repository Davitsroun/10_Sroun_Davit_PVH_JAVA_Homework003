import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

public class inputUtil {
    public  final String ANSI_GREEN = "\u001B[32m";
    public  final String ANSI_RED = "\u001B[31m";
    public  final String ANSI_RESET = "\u001B[0m";


    String rege="^[0-9]+$";
    String nameRegex="^[a-zA-Z]+$";

    Scanner sc=new Scanner(System.in);
    String regeDouble="[0-9]+(\\\\.[0-9]{1,2})?$";
    String YesNo= "^[y|n]$";

    public String address(String text){
        System.out.print(text);
        String date;
        date= sc.next();
        return date;
    }


    public  String InputYN() {
        String answer;
        while (true){
            System.out.println(ANSI_GREEN+"=>Do you want to cotineu? (y/n):"+ANSI_RESET);
            answer= sc.next().trim().toLowerCase();
            if (Pattern.matches(YesNo, answer)) {
                break;
            } else {
                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
            }
        }
        return  answer;
    }

    public int hour(String text ){
        String number;
        do {
            System.out.print(text);
            number =sc.next();
            if (Pattern.matches(rege, number)){
                break;
            }else {
                System.out.println(ANSI_RED+"input only number"+ANSI_RESET);
            }
        }while (true);

        return  Integer.parseInt(number);
    }

    public String Inputname(String text){
        String name;
        do {
            System.out.print(text);
            name = sc.next();
            if (Pattern.matches(nameRegex,name)){
                break;
            }else {
                System.out.println(ANSI_RED+"You can input number....."+ANSI_RESET);
            }
        }while (true);

        return name;
    }





    public double Inputbalance(String text){
        String balance;
        do {
            System.out.print(text);
            balance=sc.next();

            if (Pattern.matches(regeDouble, balance)){
                break;
            }else {
                System.out.println(ANSI_RED+"Invalid data....."+ANSI_RESET);
            }
        }while (true);
        return Double.parseDouble(balance);
    }



    public double InputRate(String text){
        String rate;
        do {
            System.out.print(text);
            rate=sc.next();


            if (Pattern.matches(regeDouble, rate)){
                break;
            }else {
                System.out.println(ANSI_RED+"Invalid data....."+ANSI_RESET);
            }
        }while (true);
        return Double.parseDouble(rate);
    }


}