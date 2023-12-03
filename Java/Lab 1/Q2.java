public class Q2 {

    public static void main(String[] args) {
        //This prints out all the even numbers from 1 to 100;
        //intialise i
        int i = 1;
        //while loop running i to 100
        while (i < 100) {
            //check the modulus to see if it's an even number
            if (i % 2 == 0) {
                //print i
                System.out.println(i);
            }
             //checks for odd numbers then prints out i
            if (i % 2 == 1) {

                System.out.println(i);

            }
             //check for mutiples of 4 then prints out i
            if (i % 4 == 0) {

                System.out.println(i);

            }
            //checks for mutiples of 3 then prints out j
            if (i % 3 == 0) {

                String j = "Java";
                System.out.println(j);
            }
            //checks for mutiples of 3 then prints out a string
            if (i % 3 == 0) {

                String x = "Script";
                System.out.println(x);
            }
            //checks for multiples of 3 or 5 then prints out a string
            if (i % 3 == 0 && i % 5 == 0) {

                String o = "JavaScript";
                System.out.println(o);
            }

            i++;
        }

    }
}