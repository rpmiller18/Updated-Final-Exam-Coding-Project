package app.controller;


import java.util.LinkedList;

public class Payment {
	
	String dueDate;
	int ID;
	double interestRate;
	double interestPmt;
	double principlePmt;
	double actualPmt;
	double extraPmt;
	double formerBalance;
	double updatedBalance;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public double getActualPmt() {
		return actualPmt;
	}
	public void setActualPmt(double actualPmt) {
		this.actualPmt = actualPmt;
	}
	public double getExtraPmt() {
		return extraPmt;
	}
	public void setExtraPmt(double extraPmt) {
		this.extraPmt = extraPmt;
	}
	public double getInterestPmt() {
		return interestPmt;
	}
	public void setInterestPmt(double interestPmt) {
		this.interestPmt = interestPmt;
	}
	public double getPrinciplePmt() {
		return principlePmt;
	}
	public void setPrinciplePmt(double principlePmt) {
		this.principlePmt = principlePmt;
	}
	
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	public double getFormerBalance() {
		return formerBalance;
	}
	public void setFormerBalance(double formerBalance) {
		this.formerBalance = formerBalance;
	}
	
	
	// Handles first payment
	public Payment(Loan loan) {
		
		this.ID = 1;
		this.dueDate = loan.getStartDate();
		this.actualPmt = (loan.getLoanAmount() * loan.getInterestRate() * Math.pow((1 + loan.getInterestRate()), loan.getTermNumber())) 
				/ (Math.pow(1+ loan.getInterestRate(), loan.getTermNumber()) -1);
		this.extraPmt = loan.getExtraPmt();
		this.interestPmt = loan.getLoanAmount() * loan.getInterestRate();
		this.principlePmt = this.actualPmt + this.extraPmt - this.interestPmt;
		this.formerBalance = loan.getLoanAmount();
		this.updatedBalance = this.formerBalance - this.principlePmt;
		this.interestRate = loan.getInterestRate();
		
	}
	
	//Handles all middle payment
	public Payment(Payment prior) {
		
		this.ID = prior.getID() + 1;
		this.dueDate = prior.getDueDate();
		this.actualPmt = prior.getActualPmt();
		this.extraPmt = prior.getExtraPmt();
		this.interestRate = prior.getInterestRate();
		this.formerBalance = prior.getUpdatedBalance();
		this.interestPmt = this.formerBalance * this.interestRate;
		this.principlePmt = this.actualPmt + this.extraPmt - this.interestPmt;
		this.updatedBalance = this.formerBalance - this.principlePmt;
	}
	
	//Creates payments using loan 
	public static LinkedList<Payment> createPayments(Loan loan) {
		
		Payment initialPayment = new Payment(loan);
		LinkedList<Payment> totalPayments = new LinkedList<Payment>();
		totalPayments.add(initialPayment);	
		Payment initial = initialPayment;
		while (totalPayments.size() < loan.getTermNumber() && totalPayments.getLast().getUpdatedBalance() >
			initialPayment.getActualPmt() + initialPayment.getExtraPmt()) {	
			Payment a = new Payment(initial);
			totalPayments.add(a);
			initial = a;
		}
		Payment Last = new Payment(totalPayments.getLast());
		double balanceRemaining = totalPayments.getLast().getUpdatedBalance();
		
		if (balanceRemaining > totalPayments.getLast().getActualPmt()) {
			Last.setExtraPmt(balanceRemaining - totalPayments.getLast().getActualPmt());
		}
		else {
			Last.setExtraPmt(0);
			Last.setInterestPmt(Last.getFormerBalance() * Last.getInterestRate());
			Last.setPrinciplePmt(Last.getFormerBalance());
			Last.setActualPmt(Last.getPrinciplePmt() + Last.getInterestPmt());
		}
		Last.setUpdatedBalance(0);
		totalPayments.add(Last);
		return totalPayments;
	}
}