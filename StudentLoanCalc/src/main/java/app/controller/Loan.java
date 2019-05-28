package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;
import java.time.LocalDate;
import java.util.LinkedList;


public class Loan {
	
	double interestRate;
	double loanAmount;
	double extraPmt;
	int termNumber;
	String startDate;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}
	
	public double getExtraPmt() {
		return extraPmt;
	}

	public void setExtraPmt(double extraPmt) {
		this.extraPmt = extraPmt;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Loan(int termNumber, double loanAmount, double interestRate, String startDate, double extraPmt){
		
		this.loanAmount = loanAmount;
		this.interestRate = interestRate / 1200;
		this.extraPmt = extraPmt;
		this.startDate = startDate;
		this.termNumber = termNumber * 12;

	}
	
}