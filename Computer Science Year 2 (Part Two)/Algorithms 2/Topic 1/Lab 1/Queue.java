import java.util.Scanner;

public class Queue {

    //create node to be used
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    //Front of queue pointer
    Node front;
    //End of queue pointer
    Node tail;

    void enqueue(int data) {
        //Create new node
        Node newNode = new Node(data);
        if (tail == null) {
            front = tail = newNode;
            return;
        }
        //point tail address to new node
        tail.next = newNode;
        tail = newNode;

    }


    int dequeue() {
        //When the queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        //Save the front element before removing it
        int data = front.data;
        //Remove the front element by pointing it to the next element in the queue
        front = front.next;
        //reset the queue if there is nothing in it
        if (front == null) {
            tail = null;
        }
        //return deleted element
        return data;
    }


    ///Returns element at the front of the queue
    int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    //check if the queue is empty
    boolean isEmpty() {
        return (front == null && tail == null);
    }


    public static void main(String[] args) {
        ///Calling Queue
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);



        int option;
        do {
            //Options
            System.out.println("Please, enter your option:");
            System.out.println("0. Quit the programme");
            System.out.println("1. ENQUEUE(x)");
            System.out.println("2. DEQUEUE");
            System.out.println("3. PEEK");
            System.out.println("4. ISEMPTY");

            //Using the number entered by user and storing it in the option variable
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the element to enqueue:");
                    int x = sc.nextInt();
                    queue.enqueue(x);
                    break;
                case 2:
                    int dequeued = queue.dequeue();

                    System.out.println("Dequeued element: " + dequeued);

                    break;
                case 3:
                    int peeked = queue.peek();

                    System.out.println("Peeked element: " + peeked);

                    break;
                case 4:
                    boolean isEmpty = queue.isEmpty();
                    System.out.println("Is queue empty: " + isEmpty);
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);

        System.out.println("Quitting the programme");
        sc.close();
    }

}