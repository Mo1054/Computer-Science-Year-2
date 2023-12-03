public enum NotesAndCoins {
    //values
    PENCE1(1, "1p"),
    PENCE2(2, "2p"),
    PENCE5(5, "5p"),
    PENCE10(10, "10p"),
    PENCE20(20,"20p"),
    PENCE50(50, "50p"),
    POUND1(100, "£1"),
    POUND2(200, "£2"),
    POUND5(500, "£5"),
    POUND10(1000, "£10"),
    POUND20(2000, "£20"),
    POUND50(5000, "£50");

    private final int valueInP;
    private final String name;

    //Constructor
    NotesAndCoins(int valueInP, String name) {
        this.valueInP = valueInP;
        this.name = name;
    }
   ///getters and setters
    public int getValueInP() {
        return valueInP;
    }

    public String getName() {
        return name;
    }

}