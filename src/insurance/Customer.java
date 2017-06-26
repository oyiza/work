package insurance;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	
	public String name;
	public long contactNumber;
	public String address;
	public String iDproof;
	public ArrayList<Policy> policy = new ArrayList<Policy>();
	public String custid;
	
	/**
	 * Constructor
	 */
	public Customer(String name, long contactNumber, String address, String iDproof) {
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.iDproof = iDproof;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getiDproof() {
		return iDproof;
	}
	
	public void setiDproof(String iDproof) {
		this.iDproof = iDproof;
	}
	
	/**
	 * @return a list of policies that customer is currently tagged to. Basically the ArrayList
	 * toString() method
	 */
	public String getPolicy() {
		return policy.toString();
	}
	
	/* Should add said policy to customer's list of policies */
	public void addPolicy(Policy policy) {
		this.policy.add(policy);
	}
	
	public String getCustid() {
		return custid;
	}
	
	public void setCustid(String custid) {
		this.custid = custid;
	}
	
	/**
	 * @return a string representation of all the Customer class details including all policies
	 * he/she has been tagged to
	 */
	public String toString() {
		Iterator<Policy> itr = policy.iterator();
		Policy temp;
		String policies = "";
		
		while(itr.hasNext()) {
			temp = itr.next();
			policies += temp.getPolicyName() + ", ";
		}
		
		String result =  "Customer's name: " + name + "\nContact Number: " + contactNumber + "\nAddress: " + address +
				"\nProof of ID: " + iDproof + "\nCustomer ID: " + custid;
		
		if(!policies.equals("")) {
			result += "\nList of policies tagged: " + policies;
		}
		
		return result;
	}
}