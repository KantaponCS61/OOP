import javafx.beans.property.SimpleStringProperty;

public class Person {
	private String ID;
	private String firstName;
    private String email;
    Person( String id, String fName, String email) {
    	this.ID = new String(id);
        this.firstName = new String(fName);
        this.email = new String(email);
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