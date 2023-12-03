public class Q3Main {
    public static void main(String[] args) {
        //Testing
        String test = Password.Generator(6,1, 2);
        System.out.println(Password.validator(test));

        String test2 = Password.Generator(14,5, 4);
        System.out.println(Password.validator(test2));


        String test3 = Password.Generator(9,3, 2);
        System.out.println(Password.validator(test3));

        String test4 = Password.Generator(9,2, 2);
        System.out.println(Password.validator(test4));

        String test5 = Password.Generator(18,6, 5);
        System.out.println(Password.validator(test5));

    }
}
