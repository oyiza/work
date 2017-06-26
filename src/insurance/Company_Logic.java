package insurance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Company_Logic {
	
	public ArrayList<Policy> policies = new ArrayList<Policy>();
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public int idgenerator = 101;
	public int polgenerattor = 001;
	
	/**
	 * Prints out the details of all the current running policies in the system
	 */
	public void viewPolicies() {
		Iterator<Policy> itr = policies.iterator();
		Policy temp;
		int count = 1;
		
		while(itr.hasNext()) {
			temp = itr.next();
			System.out.println(count + ".\n" + temp.toString());
			System.out.println();
			count++;
		}
	}
	
	/**
	 * Prints out the details of all the customers in the system
	 */
	public void viewCustomers() {
		Iterator<Customer> itr = customers.iterator();
		Customer temp;
		int count = 1;
		
		while(itr.hasNext()) {
			temp = itr.next();
			System.out.println(count + ". " + temp.toString());
			System.out.println();
			count++;
		}
	}
	
	/**
	 * @param policyId: the unique id of the policy whose customers we are looking for
	 * @throws PolicyNotFoundException
	 */
	public void searchCustomers(int policyId) throws PolicyNotFoundException {
		Iterator<Policy> itr = policies.iterator();
		Policy temp;
		boolean found = false;
		
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getPolicyId() == policyId) {
				System.out.println(temp.getCustomers());
				found = true;
			}
		}
		
		if(!found) {
			throw new PolicyNotFoundException(policyId);
		}
	}
	
	/**
	 * @param custid: unique ID of the customer in question whose policies we want to display
	 * @throws CustomerNotFoundException
	 */
	public void searchPolicies(String custid) throws CustomerNotFoundException {
		Iterator<Customer> itr = customers.iterator();
		Customer temp;
		boolean found = false;
		
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getCustid().equalsIgnoreCase(custid)) {
				System.out.println(temp.getPolicy());
				found = true;
			}
		}
		
		if(!found) {
			throw new CustomerNotFoundException(custid);
		}
	}
	
	/**
	 * Creates a policy class and adds it to the ArrayList of policies
	 */
	public void addPolicy() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Please enter policy name:");
		String policyName = sc.nextLine();
		System.out.println("Please enter policy tenure (number of years):");
		int policyTenure = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter payment mode (annual, weekly, monthly, etc):");
		String paymentMode = sc.nextLine();
		System.out.println("Please enter nominee:");
		String nominee = sc.nextLine();
		System.out.println("Please enter committed amount:");
		double committedAmount = sc.nextDouble();
		
		Policy temp = new Policy(policyName, policyTenure, paymentMode, nominee, committedAmount);
		temp.setPolicyId(polgenerattor);
		polgenerattor++;
		policies.add(temp);
	}
	
	/**
	 * Searches through the list of customers and his/her policies and if the customer does not
	 * have the policy, it adds it to the list of customer's policies
	 * @param policy: policy to be added
	 * @param customer: customer to whom the policy is being added
	 * @throws CustomerNotFoundException
	 */
	public void addPolicyToCustomer(Policy policy, Customer customer) throws CustomerNotFoundException {
		Iterator<Customer> itr = customers.iterator();			
		Customer temp;
		boolean found = false;
		
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getCustid().equalsIgnoreCase(customer.getCustid())) {
				//first check if customer has policy already
				Iterator<Policy> pol = temp.policy.iterator();
				Policy temp2;
				boolean found2 = false;
				while(pol.hasNext() && !found2) {
					temp2 = pol.next();
					if(temp2.getPolicyName().equalsIgnoreCase(policy.getPolicyName())) {
						found2 = true;
						System.out.println("Customer already has " + policy.getPolicyName());
					}
				}
				//if customer does not have policy, add it and set found to true
				temp.addPolicy(policy);
				policy.customersTagged.add(temp);
				found = true;
			}
		}
	}
	
	/**
	 * finds the objects using the name and id and sends it to the above method
	 */
	public void addPolicyToCustomer(int policyId, String custid) throws 
		CustomerNotFoundException, PolicyNotFoundException {
		Iterator<Customer> itr = customers.iterator();			
		Customer temp = null;
		boolean found = false;
		
		//Search for the given customer
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getCustid().equalsIgnoreCase(custid)) {
				found = true;
			}
		}
		
		if(!found) {
			throw new CustomerNotFoundException(custid);
		}
		
		Iterator<Policy> itr2 = policies.iterator();
		Policy temp2 = null;
		boolean found2 = false;
		
		//Search for the given policy
		while(itr2.hasNext() && !found2) {
			temp2 = itr2.next();
			if(temp2.getPolicyId() == policyId) {
				found2 = true;
			}
		}
		
		if(!found) {
			throw new PolicyNotFoundException(policyId);
		}
		
		if(found && found2) {
			try{
				addPolicyToCustomer(temp2, temp);
			} catch (CustomerNotFoundException e) {
				System.out.println(e);
			}
		} else if (!found) {
			System.out.println("Customer not found.");
		} else if (!found2) {
			System.out.println("Policy not found.");
		}
	}
	
	/**
	 * Adds a customer to the company's list of customers if customer did not exist before
	 */
	public void addCustomer(Customer customer) {
		Iterator<Customer> itr = customers.iterator();
		Customer temp;
		boolean found = false;
		
		while(itr.hasNext() && !found) {
			temp = itr.next();
			if(temp.getCustid().equalsIgnoreCase(customer.getCustid())) {
				//then customer already exists
				found = true;
				System.out.println("Customer already exists in system with ID: " + temp.getCustid());
			}
		}
		
		if(!found) {
			customers.add(customer);
		}
	}
	
	/**
	 * Dynamically takes input from the user and creates a Customer object then returns it
	 * @return
	 */
	public void createCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter customer name:");
		String name = sc.nextLine();
		System.out.println("Please enter contact number:");
		long contactNumber = sc.nextLong();
		sc.nextLine();
		System.out.println("Please enter customer's address:");
		String address = sc.nextLine();
		System.out.println("Please enter proof of ID type:");
		String iDproof = sc.nextLine();
		
		Customer temp = new Customer(name, contactNumber, address, iDproof);
		genCustId(temp);
		
		customers.add(temp);
	}

	/**
	 * Helper function to generate customer ID
	 * @param temp: Customer whose ID will be generated
	 */
	private void genCustId(Customer temp) {
		String id = temp.name.substring(0, 3);
		id += idgenerator;
		temp.setCustid(id);
		idgenerator++;
	}
	
	/**
	 * Gets the customer ID from the user and deletes it from the ArrayList if the customer exists
	 * @throws CustomerNotFoundException
	 */
	public void deleteCustomer() throws CustomerNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter customer ID:");
		String custid = sc.nextLine();
		
		Iterator<Customer> itr = customers.iterator();
		Customer temp;
		boolean found = false;
		
		while(itr.hasNext()) {
			temp = itr.next();
//			itr.next();
			if(temp.getCustid().equalsIgnoreCase(custid)) {
				customers.remove(temp);
				found = true;
				break;
			}
		}
		
		//Remove customer from policies
		Iterator<Policy> itr2 = policies.iterator();
		Policy temp2;
//		boolean found2 = false;
		
		while(itr2.hasNext()) {
			temp2 = itr2.next();
			for(int i = 0; i < temp2.customersTagged.size(); i++) {
				Iterator<Customer> it = temp2.customersTagged.iterator();
				Customer c;
//				boolean cb = false;
				
				while(it.hasNext()) {
					c = it.next();
					if(c.getCustid().equalsIgnoreCase(custid)) {
						temp2.customersTagged.remove(c);
						break;
					}
				}
			}
		}
		
		if(!found) {
			throw new CustomerNotFoundException(custid);
		}
	}
	
	/**
	 * Iterates through the list of policies and deletes it from the list if found
	 * @throws PolicyNotFoundException
	 */
	public void deletePolicy() throws PolicyNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter policy ID:");
		int policyId = sc.nextInt();
		
		Iterator<Policy> itr = policies.iterator();
		Policy temp;
		boolean found = false;
		
		while(itr.hasNext()) {
			temp = itr.next();
			if(temp.getPolicyId() == policyId) {
				policies.remove(temp);
				found = true;
				break;
			}
		}
		
		if(!found) {
			throw new PolicyNotFoundException(policyId);
		}
	}
}