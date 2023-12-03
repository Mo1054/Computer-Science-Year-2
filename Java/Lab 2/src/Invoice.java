public class Invoice {

    //Properties of invoice
    int ID;
    String description;
    int quantity;
    double UnitPrice;
    boolean paid;

   //Constructor function with parameters
    Invoice(int IDs, String Describe, int Quantity, double Unit) {

        ID = IDs;
        description = Describe;
        quantity = Quantity;
        UnitPrice = Unit;

        paid = false;

    }

    //String method that prints out properties
    @Override
    public String toString() {
        return "Invoice{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", UnitPrice=" + UnitPrice +
                ", paid=" + paid +
                '}';
    }

    //Getter method for paid
    public boolean isPaid() {
        return paid;
    }

    //Setter method for paid
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
