import java.util.Random;

public class PiEstimator {
    public static void main(String[] args) throws InterruptedException {
        // Set the number of darts to throw
        int numberOfDarts = 1_000_000_000;
        // Set the number of threads to use
        int numThreads = 4;
        // Create a shared TotalWithin object to keep track of the number of darts that hit the board
        TotalWithin totalWithin = new TotalWithin();

        // Create an array of threads
        Thread[] threads = new Thread[numThreads];

        // Start each thread with an equal number of darts to throw and the shared TotalWithin object
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PiThread(numberOfDarts / numThreads, totalWithin);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        // Calculate the estimated value of pi based on the number of darts that hit the board
        double estimate = (double) totalWithin.getWithin() / numberOfDarts * 4;
        // Print the estimated value of pi
        System.out.println("Estimated value of pi: " + estimate);
    }
}

class PiThread extends Thread {
    private int numDarts;
    private TotalWithin totalWithin;
    private Random r;

    public PiThread(int numDarts, TotalWithin totalWithin) {
        // Set the number of darts to throw in this thread
        this.numDarts = numDarts;
        // Set the shared TotalWithin object
        this.totalWithin = totalWithin;
        // Create a Random object to generate random coordinates for the darts
        this.r = new Random();
    }

    public void run() {
        // Throw the specified number of darts in this thread
        for (int i = 0; i < numDarts; i++) {
            double x = r.nextDouble();
            double y = r.nextDouble();
            // Calculate the distance from the origin to the dart using Pythagorean theorem
            double dist = Math.sqrt((x * x) + (y * y));
            // If the dart hits the board (i.e. its distance from the origin is less than 1), increment the TotalWithin object
            if (dist < 1) {
                totalWithin.increment();
            }
        }
    }
}

class TotalWithin {
    private int within;

    // Method to increment the number of darts that hit the board
    public synchronized void increment() {
        within++;
    }

    // Method to get the number of darts that hit the board
    public synchronized int getWithin() {
        return within;
    }
}