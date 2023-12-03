public class Q1Main {


    public static void main(String[] args) {


        //Calling constructor function
        Invoice NewInvoice = new Invoice(12, "This is the ID", 15, 12.56);
        //Calling constructor function
        Invoice NewInvoice2 = new Invoice(15, "This is the ID 2", 25, 55.22);
        //Setting paid to true
        NewInvoice2.setPaid(true);
        //Setting paid to true
        NewInvoice.setPaid(true);

        //Prints out a string of invoice properties
        System.out.println(NewInvoice.toString());
        System.out.println(NewInvoice2.toString());




}

}
