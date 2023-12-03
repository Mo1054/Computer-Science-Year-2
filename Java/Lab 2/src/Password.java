//Importing Java libraries
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.*;

public class Password {

    public static String Generator(int lengths, int digits, int symbols) {


        ///Creating Arraylists
        ArrayList < Character > UPPERCASE_LETTERS = new ArrayList < > (Arrays.asList('A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'G', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        ArrayList < Character > LOWERCASE_LETTERS = new ArrayList < > (Arrays.asList('a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        ArrayList < Character > DIGITS = new ArrayList < > (
                Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        ArrayList < Character > SPECIAL_CHARACTERS = new ArrayList < > (
                Arrays.asList('!', '@', '#', '$', '%', '&', '*', '(', ')', '+'));

        final Random random = new Random();

        // Stores all the characters being created to build a password
        List < Character > characters = new ArrayList < Character > ();
        //How many items in the arraylist
        int count1 =  lengths/2 - digits;
        int count2 = lengths/2 - symbols;
       //checks if length is odd then adds on one
        if(lengths % 2 == 1){
            count1 = count1 + 1;
        }
        int count3 = digits;
        int count4 = symbols;

        ///Size of character arraylist array
        int length = count1 + count2 + digits + symbols;

        //Adds randomised Lowercase Letters to character arraylist
        for (int i = 0; i < count1; i++) {
            characters.add(LOWERCASE_LETTERS.get(random.nextInt(LOWERCASE_LETTERS.size())));
        }


        //Adds randomised Uppercase Letters to character arraylist
        for (int i = 0; i < count2; i++) {
            characters.add(UPPERCASE_LETTERS.get(random.nextInt(UPPERCASE_LETTERS.size())));
        }


        //Adds randomised digits to character arraylist
        for (int i = 0; i < count3; i++) {
            characters.add(DIGITS.get(random.nextInt(DIGITS.size())));


        }


        //Adds randomised specials to character arraylist
        for (int i = 0; i < count4; i++) {
            characters.add(SPECIAL_CHARACTERS.get(random.nextInt(SPECIAL_CHARACTERS.size())));
        }


        //shuffles values in characters arraylist in order to create a more random password.
        Collections.shuffle(characters);


        //Pushes values into password array from the characters array then returns it
        char[] password = new char[length];

        List < Character > newChar = new ArrayList < Character > ();

        for (int i = 0; i < characters.size(); i++) {
            password[i] = characters.get(i);
        }

        characters.clear();

        //Converts password array into string
        String newPassword = String.valueOf(password);

        return newPassword;

    }
    //Validator function
    public static boolean validator(String name) {

        //Counter variables
        int symbolCounter = 0;
        int digitCounter = 0;
        for (int i = 0; i < name.length(); i++) {

            // Checking the character for not being a
            // letter,digit or space
            if (!Character.isDigit(name.charAt(i)) &&
                    !Character.isLetter(name.charAt(i)) &&
                    !Character.isWhitespace(name.charAt(i))) {
                // Incrementing the counter for spl
                symbolCounter++;
            }

            //Incrementing for digits
            if (Character.isDigit(name.charAt(i))) {

                digitCounter++;
            }
        }


        if (name.length() >= 16 && symbolCounter > 4 && digitCounter > 4) {

            System.out.println("Excellent Password: ");
            return true;
        }

        //Checks for good Password
        if (name.length() > 12 && symbolCounter > 3 && digitCounter > 3) {

            System.out.println("Good Password: ");
            return true;
        }



        //Checks for Ok password
        if (name.length() > 8 && symbolCounter > 1 && digitCounter > 2) {

            System.out.println(" Ok Password: ");
            return false;
        }



        System.out.println(" Poor Password: ");
        return false;

    }

}