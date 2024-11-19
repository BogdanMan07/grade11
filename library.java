public class library {
    public static void main(String[] args) {
        Book b1= new Book("A Man Called Ove", "Frederik Backman",453);
        Book b2= new Book("Absolvo te", "Georgi Bardarov", 345);

        b1.displayDetails();
        b2.displayDetails();
    }
}

class Book {

    private String title;
    private String author;
    private int numberOfPages;

    public Book(String title, String author, int numberOfPages) {
        this.title=title;
        this.author=author;
        this.numberOfPages= numberOfPages;
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numberOfPages);

    }
}
