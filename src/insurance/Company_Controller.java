package insurance;

import java.util.Scanner;

public class Company_Controller {
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Company_Logic C = new Company_Logic();
		
		while(run) {
			System.out.println("Welcome to ABC Insurance Company. Please choose an option from" +
					" the list below:");
			System.out.println("1. View Policies" +
					"\n2. Register a Policy" + 
					"\n3. Register a Customer" +
					"\n4. Add policy to customer" +
					"\n5. Search Customers by policy ID" +
					"\n6. Search Policies by customer name" +
					"\n7. Delete a Customer" +
					"\n8. Delete a Policy" +
					"\n9. View Customers" + 
					"\n10. Quit");
			
			int option = sc.nextInt();
			
			switch(option) {
			//View Policies
			case 1:
				C.viewPolicies();
				System.out.println();
				break;
			//Register a policy
			case 2:
				C.addPolicy();
				System.out.println();
				break;
			//Register a Customer
			case 3:
				C.createCustomer();
				System.out.println();
				break;
			//Add policy to customer
			case 4:
				System.out.println("Please enter customer ID:");
				sc.nextLine();
				String custid = sc.nextLine();
				System.out.println("Please enter policy ID:");
				int policyId = sc.nextInt();
				
				try {
				C.addPolicyToCustomer(policyId, custid);
				} catch (CustomerNotFoundException e) {
					System.out.println(e);
				} catch (PolicyNotFoundException e) {
					System.out.println(e);
				}
				System.out.println();
				break;
			//Search customers by policy name
			case 5:
				System.out.println("Please enter policy ID:");
				sc.nextLine();
				int id = sc.nextInt();
				try {
					C.searchCustomers(id);
				} catch (PolicyNotFoundException e) {
					System.out.println(e);
				}
				System.out.println();
				break;
			//Search policies by customer name
			case 6:
				System.out.println("Please enter customer ID:");
				sc.nextLine();
				String custid2 = sc.nextLine();
				try {
					C.searchPolicies(custid2);
				} catch (CustomerNotFoundException e) {
					System.out.println(e);
				}
				System.out.println();
				break;
			//Delete a Customer
			case 7:
				try {
					C.deleteCustomer();
				} catch (CustomerNotFoundException e) {
					System.out.println(e);
				}
				System.out.println();
				break;
			//Delete a Policy
			case 8:
				try {
					C.deletePolicy();
				} catch (PolicyNotFoundException e) {
					System.out.println(e);
				}
				System.out.println();
				break;
			//View Customers
			case 9:
				C.viewCustomers();
				System.out.println();
				break;
			//Quit
			case 10:
				System.out.println("Goodbye!");
				sc.close();
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		Company_Controller system = new Company_Controller();
		system.run();
	}
}