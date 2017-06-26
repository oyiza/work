package insurance;

@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception {
	
	int policyId;
	
	PolicyNotFoundException(int policyId) {
		this.policyId = policyId;
	}
	
	public String toString() {
		return "Error: Policy with ID = " + policyId + " was not found in the system...";
	}
}