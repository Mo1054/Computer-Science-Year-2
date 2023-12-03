import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Insert node at the beginning of the list
    public static LinkedList insert_start(LinkedList list, int data) {
        // We create the new node
        Node newNode = new Node(data);

        //Now we link the node to the list
        newNode.next = list.head;
        list.head = newNode;

        // Return the modified list
        return list;
    }

    //Display the content of the linked list
    public static void printList(LinkedList list) {
        Node tmp = list.head;
        if (tmp != null) {
            System.out.println("The content of the list is:");
            // Traverse the list
            while (tmp != null) {
                // Print the data at current node
                System.out.print(tmp.data);

                // Move to next node
                tmp = tmp.next;
                if (tmp != null)
                    System.out.print("->");
            }
            System.out.println("");
        } else
            System.out.println("The list is empty");
    }

    //Delete the first element with data part equal to x
    public static LinkedList delete(LinkedList list, int x) {
        Node tmp = list.head;
        Node prev;

        if (tmp == null) {
            System.out.println("There is nothing to delete");
            return list;
        } else {

            //Case 1: x is found in the first node
            if (tmp.data == x) {
                list.head = tmp.next; //head points to the second element
                return list;
            } else //Case 2: X is not in the first position, we must keep searching
            {
                prev = tmp;
                tmp = tmp.next;
                while (tmp != null) {
                    if (tmp.data == x) {
                        prev.next = tmp.next;
                        return list;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                }
            }
            System.out.println("Element not found");
            return list;
        }

    }
    //return length of list
    public static int listLength(LinkedList list) {

        //Gets head value of linked list
        Node tmp = list.head;
        //Used to count the length of the linklist
        int count = 0;
        if (tmp != null) {
            // Traverse the list
            while (tmp != null) {
                // Move to next node
                tmp = tmp.next;

                count++;
            }
        }

        //return length of the linkedlist
        return count;

    }

    //Print k elements
    public static void printListK(LinkedList list, int K) {

        //Gets head value of linked list
        Node tmp = list.head;

        //Get length of list
        int length = listLength(list);
        //count is bassically a checker to see if we've past k elements to be printed by the function
        int count = 0;
        //checks if the linked list is empty
        if (tmp == null) {

            System.out.println("The list is empty");
        } else {
            //checks if the amount to print is greater than the length of the linkedlist
            if (K > length) {

                System.out.println("The list only has: " + length + " elements");
            } else {

                if (tmp != null) {
                    System.out.println("The content of the list is");
                    // Traverse the list
                    while (tmp != null && count < K) {
                        //print numbers
                        System.out.print(tmp.data);

                        // Move to next node
                        tmp = tmp.next;

                        if (tmp != null) {
                            System.out.print("->");

                        }
                        count++;
                    }

                    System.out.println("");
                }


            }

        }

    }
    //count how many times an integer appears
    public static int countList(LinkedList list, int x) {

        //Gets head value of linked list
        Node tmp = list.head;
        //Used to count the amount of times x appears in the linkedlist
        int count = 0;
        if (tmp != null) {
            // Traverse the list
            while (tmp != null) {

                if (tmp.data == x) {

                    count++;
                }

                // Move to next node
                tmp = tmp.next;

            }
        }

        //return how many times x appears;
        return count;


    }
    //search list for element
    public static boolean searchList(LinkedList list, int x) {
        //Gets head value of linked list
        Node tmp = list.head;
        //Used to count the amount of times x appears in the linkedlist
        int count = 0;
        if (tmp != null) {
            // Traverse the list
            while (tmp != null) {
                //return true if the element is in the linked list
                if (tmp.data == x) {

                    return true;
                }

                // Move to next node
                tmp = tmp.next;

            }
        }
        System.out.println("");
        //return how many times x appears;
        return false;

    }
    //Insert x at the end of linked list
    public static LinkedList insertEnd(LinkedList list, int data) {
        //create new node;
        Node newNode = new Node(data);
        //Gets head value of linked list
        Node tmp = list.head;
        //If there is no elements in the Linked list then it just adds one to the start
        if (tmp == null) {
            //if the linked list is empty then insert at start
            insert_start(list, data);
        } else {
            //checks the last items in the linked
            Node last = tmp;
            //Goes through the linked list until it finds the final element
            while (last.next != null) {
                last = last.next;
            }
            //Links the last element to the new node
            last.next = newNode;
        }

        return list;
    }
    //Delete all elements in the linked list
    public static void clear(LinkedList list) {
        //Gets head value of linked list
        Node tmp = list.head;
        //Removes the link to other elements of the linked list
        tmp.next = null;
        //Deletes the element at front of linked list
        delete(list, tmp.data);


    };
    //Gets the max value
    public static int max(LinkedList list) {

        //Gets head value of linked list
        Node tmp = list.head;
        //create arraylist of integers
        ArrayList < Integer > maxArray = new ArrayList < Integer > ();
        if (tmp != null) {
            // Traverse the list
            while (tmp != null) {

                maxArray.add(tmp.data);

                // Move to next node
                tmp = tmp.next;

            }
        }

        //find the max value from the arraylist using collections
        int max = Collections.max(maxArray);

        return max;
    }
    public static void deleteFirst(LinkedList list) {
        //Gets head value of linked list
        Node tmp = list.head;
        if (tmp == null) {

        } else {
            System.out.println("The first Element is: " + tmp.data);
            //Deletes the element at front of linked list
            delete(list, tmp.data);
        }

    }

    public static void main(String[] args) {
        //create a new list
        LinkedList list = new LinkedList();


        //Create variable to read from keyboard
        Scanner in = new Scanner(System.in);
        int option;
        int x;


        do {
            System.out.println("Select your option:");
            System.out.println("0: Quit the programme");
            System.out.println("1: Insert an element to the beginning of the list");
            System.out.println("2: Delete an element to the list");
            System.out.println("3: Print the content of the list");
            System.out.println("4: Print the length of the list");
            System.out.println("5: Choose how numbers you want to print");
            System.out.println("6: Count how times an item appears in the linked list");
            System.out.println("7: Check if a number appears in the linked list");
            System.out.println("8: Insert an element to the end of the list");
            System.out.println("9: Delete all elements in the list");
            System.out.println("10: Print out the maximum value in the linked list");
            System.out.println("11: Delete the first element in the linked list");

            option = in .nextInt();
            if (option == 1) {
                System.out.println("What number do you want to insert?");
                x = in .nextInt();
                list = insert_start(list, x);
                printList(list);
            }

            if (option == 2) {
                System.out.println("What number do you want to delete?");
                x = in .nextInt();
                list = delete(list, x);
                printList(list);
            }

            if (option == 3)
                printList(list);

            if (option == 4) {
                int count = listLength(list);
                System.out.println("The length of the Linkedlist is:");
                System.out.println(count);
            }

            if (option == 5) {
                System.out.println("How many numbers do you want to print:");
                x = in .nextInt();
                if (x < 0) {
                    throw new IllegalArgumentException("Error: The number must be greater than or equal to 0.");
                }

                printListK(list, x);

            }

            if (option == 6) {
                System.out.println("What number do you want to check:");
                x = in .nextInt();
                //returns the number of times x appears in the list
                int numberOfTimes = countList(list, x);
                System.out.println("The number appears: ");
                System.out.println(numberOfTimes + " times");

            }
            if (option == 7) {
                System.out.println("What number do you want to check:");
                x = in .nextInt();
                System.out.println(searchList(list, x));

            }

            if (option == 8) {
                System.out.println("What number do you want to insert?");
                x = in .nextInt();
                list = insertEnd(list, x);
                printList(list);
            }

            if (option == 9) {
                clear(list);
                printList(list);
            }

            if (option == 10) {
                if (listLength(list) > 0) {
                    int maxNumber = max(list);
                    System.out.println("The maximum number is: " + maxNumber);
                    System.out.println("");
                } else {
                    System.out.println("Please enter values into array list first");
                }

            }

            if (option == 11) {
                deleteFirst(list);
                printList(list);

            }

            if (option == 0) {
                System.out.println("Good bye!");
            }


        } while (option != 0);

    }
}