//import Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TipCalculator {

    //Variables for fields to be entered and labels
    private JTextField billField;
    private JTextField tipField;
    private JTextField peopleField;
    private JLabel resultLabel;

    public TipCalculator() {
        // Create and configure the GUI components
        JFrame frame = new JFrame("Meat splitter");
        frame.setSize(800, 1000);
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(250, 200));
        JLabel billLabel = new JLabel("Bill Amount:");
        JLabel tipLabel = new JLabel("Tip Percentage:");
        JLabel peopleLabel = new JLabel("Number of People:");
        billField = new JTextField(10);
        tipField = new JTextField(10);
        peopleField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        // Add the components to the panel
        panel.add(billLabel);
        panel.add(billField);
        panel.add(tipLabel);
        panel.add(tipField);
        panel.add(peopleLabel);
        panel.add(peopleField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // Add the panel to the frame and show the GUI
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        // Attach an event listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            // Parse the input values
            double bill = Double.parseDouble(billField.getText());
            double tip = Double.parseDouble(tipField.getText());
            int people = Integer.parseInt(peopleField.getText());

            // Calculate the tip amount and total bill
            double tipAmount = bill * (tip / 100);
            double totalBill = bill + tipAmount;

            // Calculate each diner's share of the total bill
            double share = totalBill / people;

            DecimalFormat df = new DecimalFormat("#.##");

            double roundedShare = Double.parseDouble(df.format(share));

            // Display the result
            resultLabel.setText("Each person should pay $" + roundedShare);
        } catch (NumberFormatException ex) {
            // Handle invalid input
            resultLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the TipCalculator class
        new TipCalculator();
    }
}