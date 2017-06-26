package insurance;

import java.util.ArrayList;
import java.util.Iterator;

public class Policy {
	public String policyName;
	public int policyTenure;
	public String paymentMode;
	public String nominee;
	public double committedAmount;
	public int policyID;
	public ArrayList<Customer> customersTagged = new ArrayList<Customer>();
	
	/**
	 * Constructor
	 */
	public Policy(String policyName, int policyTenure, String paymentMode, String nominee, double committedAmount) {
		this.policyName = policyName;
		this.policyTenure = policyTenure;
		this.paymentMode = paymentMode;
		this.nominee = nominee;
		this.committedAmount = committedAmount;
	}
	
	public String getPolicyName() {
		return policyName;
	}
	
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	
	public int getPolicyTenure() {
		return policyTenure;
	}
	
	public void setPolicyTenure(int policyTenure) {
		this.policyTenure = policyTenure;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public String getNominee() {
		return nominee;
	}
	
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	
	public double getCommittedAmount() {
		return committedAmount;
	}
	
	public void setCommittedAmount(double committedAmount) {
		this.committedAmount = committedAmount;
	}
	
	public int getPolicyId() {
		return policyID;
	}
	
	public void setPolicyId(int policyId) {
		this.policyID = policyId;
	}
	
	/**
	 * @return a list of all customer names who are tagged to this policy
	 */
	public String getCustomers() {
		String customers = "";
		Iterator<Customer> itr = customersTagged.iterator();
		Customer temp;
		
		if(itr.hasNext()) {
			customers += "Customer(s) tagged to this policy is/are:\n";
		}
		
		while(itr.hasNext()) {
			temp = itr.next();
			customers += temp.name + ", ";
		}
		
		return customers;
	}
	
	/**
	 * @return a string representation of all the details of the Policy class including names of
	 * customers tagged to it
	 */
	public String toString() {
		String customers = "";
		customers = getCustomers();
		
		return "Policy name: " + policyName + "\nPolicy Tenure: " + policyTenure + 
				"\nPayment Mode: " + paymentMode + "\nNominee: " + nominee + 
				"\nCommitted Amount: " + committedAmount + 
				"\nPolicy ID: " + policyID + "\nCustomers: " + customers;
	}
}