import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BookCollection {
    private ArrayList<Book> books = new ArrayList<Book>();

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path) {

        try {
            // Call files
            File bookFile = new File(path);
            Scanner bookScanner = new Scanner(bookFile);


            // Skip the header rows
            bookScanner.nextLine();

            // Going through book file
            while (bookScanner.hasNextLine()) {
                // Split book data
                String[] bookData = bookScanner.nextLine().split("\\,");

                //Variables to create object with
                String title = bookData[0];
                String author = bookData[1];
                long isbn = Long.parseLong(bookData[2]);
                int pages = Integer.parseInt(bookData[3]);
                int copiesInCollection = Integer.parseInt(bookData[4]);
                int copiesOnLoan = Integer.parseInt(bookData[5]);

                // Create a new book object using the BookData array
                Book bookObject = new Book(title, author, isbn, pages, copiesInCollection, copiesOnLoan);

                // Add the bookObject to array list
                books.add(bookObject);
            }

        } catch (FileNotFoundException e) {

            // Catch the error
            System.out.println("BookList.csv file not found.");
        }


    }

    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors() {

        HashSet<String> authors = new HashSet<String>();

        for (int i = 0; i < books.size(); i++) {

            authors.add(books.get(i).getAuthor());


        }


        return authors;

    }

    //
//    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks() {
        //Create arraylist
        ArrayList<Book> longBooks = new ArrayList<Book>();
        //Loop through books size
        for (int i = 0; i < books.size(); i++) {
            //check books over 750 pages
            if (books.get(i).getPages() > 750) {


                longBooks.add(books.get(i));
            }


        }

        return longBooks;

    }

    //
//    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title) {


        //Going through book arraylist
        for (int i = 0; i < books.size(); i++) {
            //check books with the same title
            if (books.get(i).getTitle().equals(title)) {

                return books.get(i);

            }

        }

        return null;

    }

    //
//    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular() {

        //Sort the books
        Collections.sort(books, new Comparator<Book>() {
            public int compare(Book p1, Book p2) {
                return p2.getCopiesOnLoan() - p1.getCopiesOnLoan();
            }
        });



        // Get the top 10 books
        Book[] popularBooks = new Book[10];
        for (int i = 0; i < 10; i++) {
            popularBooks[i] = books.get(i);
        }

        return popularBooks;

    }




}
