import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class MainChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean biggerPaid = false;

        double price = 0.00, paid = 0.00;

        while (!biggerPaid) {
            price = getMoneyInput("Enter the price in pounds and pence", in );
            paid = getMoneyInput("Enter the amount paid in pounds and pence", in );
            if (price > paid) {
                System.out.println("You haven't paid enough!");
            } else {
                biggerPaid = true;
            }
        }

        System.out.println("price " + price);
        TreeMap < NotesAndCoins, Integer > changeComposition = calcChange(price, paid);

        for (NotesAndCoins n: changeComposition.keySet()) {
            if (changeComposition.get(n) != 0) {
                System.out.println(n.getName() + ": " + changeComposition.get(n));
            }
        }

    }

    //takes input from the user and ensures it is a double and returns a double with 2 decimal places
    //Question(String) is the prompt for user input and (in)scanner is collecting user input
    public static double getMoneyInput(String question, Scanner in ) {
        boolean validInput = false;
        double amount = 0.00;
        //do this until the user enters a valid double
        while (!validInput) {
            System.out.println(question);
            try {
                amount = in .nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input try again"); in .next();
            }
        }
        //return the value entered fixed to 2dp
        return (double)((int)(amount * 100)) / 100;
    }

    public static TreeMap < NotesAndCoins, Integer > calcChange(double price, double paid) {

        //COMPLETE THIS METHOD!!!
        //This method will return a TreeMap where the key is NotesAndCoins and the value is the number of each denomination to make up the change

        ///Treemap with reverse order
        TreeMap < NotesAndCoins, Integer > change = new TreeMap < > (Comparator.comparingInt(NotesAndCoins::getValueInP).reversed());
        ///amount due
        double amountDue = paid - price;
        //Amount in pence
        int amountInPence = (int)(amountDue * 100);

        //Notes values
        NotesAndCoins[] values = NotesAndCoins.values();

        //Sorting Notes
        Arrays.sort(values, Comparator.comparingInt(NotesAndCoins::getValueInP).reversed());

        //Going through notes array and putting values with key pairs from the enum using the amount paid
        for (NotesAndCoins e: values) {


            int denominationInPence = e.getValueInP();
            int count = amountInPence / denominationInPence;

            if (count > 0) {
                change.put(e, count);
                amountInPence -= count * denominationInPence;
            }

        }

        return change;
    }


}