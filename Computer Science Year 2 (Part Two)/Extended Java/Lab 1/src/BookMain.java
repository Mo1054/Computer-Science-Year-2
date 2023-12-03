import java.util.ArrayList;

public class BookMain {
    public static void main(String[] args) {

        //Load Book
        BookCollection bCollection = new BookCollection("BookList.csv");
        System.out.println("");

        //Get Authors
        System.out.println(bCollection.getAuthors());

        //Get long books
        var longBooks = bCollection.getLongBooks();
        //Print out Books
        for (int i = 0; i < longBooks.size(); i++) {

            System.out.println("Author: " + longBooks.get(i).getAuthor());
            System.out.println("Pages: " + longBooks.get(i).getPages());
            System.out.println("Title: " + longBooks.get(i).getTitle());
            System.out.println("Copies: " + longBooks.get(i).getCopiesInCollection());
            System.out.println("ISBN: " + longBooks.get(i).getIsbn());

        }

        System.out.println("");

        //Get Title
        Book title = bCollection.getBookByTitle("Pride and Prejudice");
        //Title is found
        if (title != null) {

            System.out.println("Title Found: " + title.getTitle());
        } else {

            System.out.println("The Title was not found.");
        }

        System.out.println("");

        //Get Popular Copies
        Book[] popularBooks = bCollection.mostPopular();
        //print out popular books
        for (int i = 0; i < popularBooks.length; i++) {

            System.out.println("Author: " + popularBooks[i].getAuthor());
            System.out.println("Title: " + popularBooks[i].getTitle());
            System.out.println("Copies: " + popularBooks[i].getCopiesOnLoan());

        }

    }

}