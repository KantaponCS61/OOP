
public class Book {
	private String ID;
	private String bookName;
	
	public Book(String ID,String name) {
		this.ID=(ID);
		this.bookName=(name);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String name) {
		this.bookName = name;
	}
}
