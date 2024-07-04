public class Library {
    // Add the missing implementation to this class

    String address;
    Book[] books;
    public Library(String address){

        this.address = address;
        this.books = new Book[0];

    }

    public void addBook(Book newBook){
        Book[] newBookArray = new Book[this.books.length + 1];
        System.arraycopy(this.books, 0, newBookArray, 0, this.books.length);
        newBookArray[this.books.length] = newBook;
        this.books = newBookArray;
        return; 
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {

        System.out.println(this.address);
        return;
    }

    public void borrowBook(String bookName){
        boolean existBook = false;
        for (Book book : this.books){
            if (book.title.equals(bookName)){
                existBook = true;
                if (book.isBorrowed() == false){
                    System.out.println("You successfully borrowed " + bookName);
                    book.rented();
                }
                else{
                    System.out.println("Sorry, this book is already borrowed.");
                }
            }
        }
        if (existBook){}
        else{
            System.out.println("Sorry, this book is not in our catalog.");
        }
        return;

    }

    public void returnBook(String bookName){
        boolean existBook = false;
        for (Book book : this.books){
            if (book.title.equals(bookName)){
                existBook = true;
                if (book.borrowed == true){
                    System.out.println("You successfully returned " + bookName);
                    book.returned();
                }
                else{
                    System.out.println("Sorry, this book is not borrowed.");
                }
            }
        }
        if (existBook){}
        else{
            System.out.println("Sorry, this book is not in our catalog.");
        }
        return;

    }

    public void printAvailableBooks(){
        boolean existAvailableBook = false;
        for(Book book: this.books){
            if (book.isBorrowed()==false){
                System.out.println(book.getTitle());
                existAvailableBook = true;
            }
        }
        if (existAvailableBook){}
        else{
            System.out.println("No book in catalog");
        }
    }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 