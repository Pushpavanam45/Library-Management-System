package elevatelab_intern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 class Book{
	private int id;
	private String title;
	private Boolean isIssued;
	
	public Book (int id, String title) {
		this.id = id;
		this.title = title;
		this.isIssued = false;
		
	}
	
	public int getId() {
		return id;}
	
	public String getTitle() {
		return title;
	}
	public boolean isIssued() {
		return isIssued;
	}
	
	public void returnBook() {
		isIssued = false;
		
	}
	
	
	public String toString() {
		return "Book ID: "+id+",Title: "+title+",Statue: "+(isIssued ? "Issued": "Available");
	
		
	
	}

	public void issue() {
		isIssued = true;
	}
		// TODO Auto-generated method stub
		
	}



 class User{
	private int id;
	private String name;
	
	public User(int id , String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public int getId() {
		return id;
	}
	public String getname() {
		return name;
	}
	
	
	public String isString() {
		return "User ID: "+id+",Name: "+name;
	}
	}



 class Library{
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added.");
	}
	
	public void addUser(User user) {
		users.add(user);
		System.out.println("User added");
	}
	
	public void viewBooks() {
		System.out.println("--- Book List ---");
		for(Book b : books) {
			System.out.println(b);
		}
	}
	
	public void issueBook(int bookId) {
		Book book = findBook(bookId);
		if(book == null) {
			System.out.println("Book not found");
		}else if(book.isIssued()) {
			System.out.println("Book already issued.");
		}else {
			 book.issue();
			System.out.println("Book issued successfully");
		}
	}
	
	public void returnBook(int bookId) {
		Book book = findBook(bookId);
		if(book== null) {
			System.out.println("Book is not found");
		}else if(!book.isIssued()) {
			System.out.println("Book is not currently issued");	
		}else {
			book.returnBook();
			System.out.println("Book returned successfully");
		}
	}
	
	private Book findBook(int id) {
		for(Book b : books) {
			if(b.getId() == id)
				return b;
		}
		return null;
	}
}
public class LibrarySystem {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		int choice;
		
		do {
			System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. View All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            
            
            switch (choice) {
            case 1 -> {
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                library.addBook(new Book(id, title));
            }
            case 2 -> {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Enter User Name: ");
                String name = sc.nextLine();
                library.addUser(new User(id, name));
            }
            case 3 -> library.viewBooks();
            case 4 -> {
                System.out.print("Enter Book ID to issue: ");
                int id = Integer.parseInt(sc.nextLine());
                library.issueBook(id);
            }
            case 5 -> {
                System.out.print("Enter Book ID to return: ");
                int id = Integer.parseInt(sc.nextLine());
                library.returnBook(id);
            }
            case 6 -> System.out.println("Exiting system...");
            default -> System.out.println("Invalid choice.");
        }
		}  while(choice != 6) ;
            	sc.close();
            	
            
		
		
	
	
	}
}

