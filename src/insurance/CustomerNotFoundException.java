package insurance;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {
	
	String custid;
	
	public CustomerNotFoundException(String custid) {
		this.custid = custid;
	}
	
	public String toString() {
		return "Error: " + custid + " not found in the system...";
	}
}