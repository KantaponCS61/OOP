import java.util.ArrayList;

public class RentList {
	static ArrayList<Rent> rentList= new ArrayList<Rent>();
	
	public static void Add(Rent r) {
		rentList.add(r);
	}
}
