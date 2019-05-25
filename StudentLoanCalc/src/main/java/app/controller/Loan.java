package app.controller;


public class Loan {

	public static double calculateTotalPayments(int loanTerm, double principle, double interestRate) {
		
		interestRate = interestRate/1200;
		int months = loanTerm * 12;
		double upper = principle*interestRate*months;
		double lower = 1 - (Math.pow(1+interestRate,-1*months));
		double totalPayments =  upper/lower;
		return Math.round(totalPayments*100)/100;
	}
}
