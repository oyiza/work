package work;

import java.util.Scanner;

public class TaxCalc {
	public double income;
	public String province;
	public double tax = 0.0;
	
	//constructor takes the gross annual income and the province and calculates
	//the annual tax depending on province
	TaxCalc(double income, String province) {

		if(province.equalsIgnoreCase("AB") || province.equalsIgnoreCase("Alberta")) {
			tax = income * (22.42 / 100);
		} else if(province.equalsIgnoreCase("ON") || province.equalsIgnoreCase("Ontario")) {
			tax = income * (21.14 / 100);
		} else if(province.equalsIgnoreCase("NWT")) {
			tax = income * (20.90 / 100);
		} else if(province.equalsIgnoreCase("YT") || province.equalsIgnoreCase("Yukon")) {
			tax = income * (21.34 / 100);
		} else if(province.equalsIgnoreCase("NU") || province.equalsIgnoreCase("Nunavut")) {
			tax = income * (19.47 / 100);
		} else if(province.equalsIgnoreCase("BC")) {
			tax = income * (20.56 / 100);
		} else if(province.equalsIgnoreCase("SK")) {
			tax = income * (24.37 / 100);
		} else if(province.equalsIgnoreCase("MB") || province.equalsIgnoreCase("Manitoba")) {
			tax = income * (26.01 / 100);
		} else if(province.equalsIgnoreCase("QC") || province.equalsIgnoreCase("Quebec")) {
			tax = income * (27.09 / 100);
		} else if(province.equalsIgnoreCase("NB")) {
			tax = income * (25.67 / 100);
		} else if(province.equalsIgnoreCase("NS")) {
			tax = income * (26.77 / 100);
		} else if(province.equalsIgnoreCase("PEI")) {
			tax = income * (26.36 / 100);
		} else if(province.equalsIgnoreCase("NL")) {
			tax = income * (25.00 / 100);
		} else {
			System.out.println("Province format wrong or not found.");
		}
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(double newIncome) {
		this.income = newIncome;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	private double getTax() {
		return tax;
	}
	
	public static void main(String[] args) {
		double salary;
		String address;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your gross annual income: ");
		salary = sc.nextDouble();
		System.out.println("Please enter your province: ");
		address = sc.next();
		
		TaxCalc calculator = new TaxCalc(salary, address);
		if(calculator.getTax() != 0.0) {
			System.out.println("Your annual tax is: " + calculator.getTax());
		}
		
		sc.close();
	}
}