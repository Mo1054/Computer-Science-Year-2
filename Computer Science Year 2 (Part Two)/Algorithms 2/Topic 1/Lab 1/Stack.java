import java.util.Scanner;

public class Stack {

    //create node to be used
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //This is the variable for the top of the stack
    Node top;
    //pushes value into the stack
     void push(int data){
        //create new node
        Node newNode = new Node(data);
        //assign newNode to top
        newNode.next = top;
        //Assign top to newNode
        top = newNode;
    }
    //removes the last element inserted in the stack
    int pop(){
         if(top == null){
             System.out.println("empty list");
             return -1;
         }
         //Assigns the top element to the next value in the stack
        int data = top.data;
        top = top.next;

        return data;
    }

    int peek(){
         //if the stack is empty
         if(top == null){
             System.out.println("Empty List");
             return -1;
         }
         //Print top element of the stack
         return top.data;
    }
    //check if stack is empty
    boolean isEmpty(){
         //return if the top of the stack is empty
         if(top == null){

             return true;
         }

         return false;
    }

    public static void main(String[] args){
        //create a new list
        Stack stack = new Stack();

        //Create variable to read from keyboard
        Scanner in = new Scanner(System.in);
        int option;
        int x;

        do{
            //options
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Remove the last element in the stack");
            System.out.println("2: Insert an element into the stack");
            System.out.println("3: Return the last element inserted into the stack");
            System.out.println("4: Check if the stack is empty");


            //Using the number entered by user and storing it in the option variable
            option = in .nextInt();

            switch(option){
                case 0:
                    break;
                case 1:
                    System.out.println("Popped element: " + stack.pop());
                    break;
                case 2:
                    System.out.println("Enter the number to be pushed in");
                    x = in.nextInt();
                    stack.push(x);
                    break;

                case 3:
                    System.out.println("Top element: " + stack.peek());
                    break;

                case 4:
                    System.out.println("Is the stack empty? " + stack.isEmpty());
                    break;
            }



        }while(option != 0);
        in.close();

    }


}
