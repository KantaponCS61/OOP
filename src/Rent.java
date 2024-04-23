

public class Rent {
	private String ID;
	private String firstName;
    private String email;
    private String book;
    Rent( String id, String fName, String email, String book) {
    	this.ID = new String(id);
        this.firstName = new String(fName);
        this.email = new String(email);
        this.book = new String(email);
    }
    public String getBook() {
		return book;
	}
	public String getName() {
        return firstName;
    }
    public void setName(String fName) {
        this.firstName=(fName);
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=(email);
    }
	public String getID() {
		return ID;
	}
    
}

