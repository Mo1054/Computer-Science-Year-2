//import scanner
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        //Salary
        double sal;
        //Tax variable
        double tax;
        //Round off
        double roundOff;
        //Console message
        System.out.print("Enter Salary:");
        //Scanner object
        Scanner r = new Scanner(System.in);
        //Scans doubles written in console
        sal = r.nextDouble();
        if (sal > 50000) {

            ///Tax for values above 50000
            double bracket = 0.05 * 15000;
            double bracket1 = 0.2 * 20_000;
            double topBracket = sal - 50000;
            double bracket2 = topBracket * 0.4;
            tax = bracket + bracket1 + bracket2;
            roundOff = Math.round(tax * 100) / 100.00;
            System.out.print(sal + " " + roundOff);

        } //tax for values above 30000 and below 50000
        else if (sal > 30000 && sal <= 50000) {

            double bracket1 = 0.05 * 15000;
            double topBracket = sal - 30000;
            double bracket2 = 0.2 * topBracket;
            tax = bracket1 + bracket2;

            roundOff = Math.round(tax * 100) / 100.00;
            System.out.print(sal + " " + roundOff);

        }
        //tax for values between 15000 and 30000
        else if (sal > 15000 && sal <= 30000) {
            double topBracket = sal - 15000;
            tax = 0.05 * topBracket;
            roundOff = Math.round(tax * 100) / 100.00;
            System.out.print(sal + " " + roundOff);

        }

        //no tax for values under 15000
        else {

            System.out.print(sal + " :No Tax:  0.00");
            //tax for values above 15000 and below 30000
        }

    }

}