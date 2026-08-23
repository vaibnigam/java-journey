package OOPSheet;

/*Q10. Create a program of the class called "Library", with a collection of books and methods
to add and remove books.

Q11. Create a program of the class called "Book" with attributes for title, author, and ISBN
number, and methods to add and remove books from a collection.*/

import java.util.ArrayList;

public class Q10_Q11_Library {
	public static void main(String[] args) {
	    Library library = new Library();

	    Book b1 = new Book("Java Basics", "James Gosling", "ISBN001");
	    Book b2 = new Book("Effective Java", "Joshua Bloch", "ISBN002");
	    Book b3 = new Book("Java Basics Reprint", "James Gosling", "ISBN001"); // same ISBN as b1, different object

	    library.addBook(b1);
	    library.addBook(b2);
	    System.out.println(library);

	    library.addBook(b3); // should be rejected - duplicate ISBN
	    System.out.println(library);

	    library.removeBook("ISBN002");
	    System.out.println(library);

	    library.removeBook("ISBN999"); // not present
	}
}

class Book {
	private String title;
	private String author;
	private String isbn;

	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		return this.isbn.equals(other.isbn);
	}
}

class Library {
	private ArrayList<Book> books;

	public Library() {
		this.books = new ArrayList<>();
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		if (books.contains(book)) {
			System.out.println("Book alrdy there!");
			return;
		}
		books.add(book);
	}

	public void removeBook(String isbn) {
		for (Book b : books)
			if (b.getIsbn().equals(isbn)) {
				books.remove(b);
				return;
			}
		System.out.println("Book not found");
	}

	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}
}