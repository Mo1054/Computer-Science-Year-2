
import java.util.Scanner;

public class Q4 {


    public static void main(String[] args) throws java.io.IOException{
     //int variable created
     int userSelected;

     do{
         //called menu data function
         userSelected = MenuData();
         switch(userSelected){
            //case 1 for current accounts
             case 1:
                 System.out.println("You have selected Current accounts");
                 break;
                 //case 2 for credit cards
             case 2:
                 System.out.println("You have selected Credit Cards");
                 break;
                 //case 3 for loans
             case 3:
                 System.out.println("You have selected Loans");
                 break;
                 //case 4 for savings account
             case 4:
                 System.out.println("You have selected Savings account");
                 break;
             default:
                 //default case if any other number is selected
                 System.out.println("Try Again");
                 MenuData();
                 break;
         }

     }
     while(userSelected > 5);

    }

///menu function
    public static int MenuData(){
       //selection variable
        int selection;
        //call new scanner object
        Scanner sc = new Scanner (System.in);
        System.out.println("Select your option:");
        System.out.println("1 - Current accounts");
        System.out.println("2 - Credit Cards");
        System.out.println("3 - Loans");
        System.out.println("4 - Savings account");

        System.out.println("Your selection option is: ");
        //Scanner
        selection = sc.nextInt();
        //return int
        return selection;
    }


}
