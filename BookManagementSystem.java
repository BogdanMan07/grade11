import java.util.Scanner;
public class BookManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = {
                new Book("Bertown", "Backman", 2018, null),
                new Book("From Zero to One", "Peter Thiel", 2019, null),
                new Book("How to code in java","Ms. Yavuz", 2025, "Bogdan Nakov"),
                new Book("How to get girls", "Victor Dichev", 2024, "Kamen Nikolov")
        };
        Scanner reader = new Scanner(System.in);
        System.out.println("Book Management Syste");
        System.out.println("1. Display Library");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: for (Book book : books) {
                System.out.println(book.getDetails());
            }
            break;

            case 2: System.out.print("Enter the book you want to borrow: ");
                String borrowedBook = reader.nextLine();
                for (Book book : books) {
                if (book.getTitle().equals(borrowedBook.trim())) {
                    System.out.println("What is your name:");
                    String name = reader.nextLine();
                    book.borrowBook(name);
                    System.out.println(book.getDetails());

                }
            }
                break;

            case 3: System.out.print("Enter the book you want to return: ");
                String returnedBook = reader.nextLine();
                for(Book book: books){
                if (book.getTitle().equals(returnedBook.trim())) {
                    book.returnBook();
                    System.out.println(book.getDetails());

                }
            }
                break;

            case 5:
                System.out.println("Exiting...");
        }
    }
}


class Book{
    private String title;
    private String author;
    private int yearPublished;
    public String borrowerName;

    public Book(String title, String author, int yearPublished, String borrowerName) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowerName = borrowerName;
    }
    public String getDetails(){
        return '\n' + title + '\n' + author + '\n' + yearPublished + '\n' + borrowerName;
    }

    public String getTitle(){
        return title;
    }

    public void updateBookInfo(String newTitle, String newAuthor, int newYearPublished){
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublished;
    }

    public void borrowBook(String borrowerName){
        this.borrowerName = borrowerName;
    }

    public void returnBook(){
        this.borrowerName = null;
    }

    public String getBorrowerName(){
        return this.borrowerName;
    }
}
