public class Book {
    private String title;
    private String author;
    private long isbn;
    private int pages;
    private int copiesInCollection;
    private int CopiesOnLoan;

    //1, complete this class with a constructor that has arguments for all the properties
    //and, getters and setters for each of them

    public Book(String title, String author, long isbn, int pages, int copiesInCollection, int copiesOnLoan) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.copiesInCollection = copiesInCollection;
        CopiesOnLoan = copiesOnLoan;
    }


    //Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCopiesInCollection() {
        return copiesInCollection;
    }

    public void setCopiesInCollection(int copiesInCollection) {
        this.copiesInCollection = copiesInCollection;
    }

    public int getCopiesOnLoan() {
        return CopiesOnLoan;
    }

    public void setCopiesOnLoan(int copiesOnLoan) {
        CopiesOnLoan = copiesOnLoan;
    }
}
