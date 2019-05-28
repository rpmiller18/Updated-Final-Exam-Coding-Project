package app.controller;

import app.StudentCalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class LoanCalcViewController implements Initializable  {
	private StudentCalc SC = null;
	@FXML
	private TextField LoanAmount;	
	@FXML
	private TextField InterestRate;
	@FXML
	private TextField Term;	
	@FXML
	private DatePicker PaymentStartDate;	
	@FXML
	private TextField AdditionalPayment;
	@FXML
	private Label lblTotalPayments;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		
		int iTerm = Integer.parseInt(Term.getText());
		System.out.println("Length of loan in years: " + iTerm);

		double doubleLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Loan Amount: " + doubleLoanAmount);
		
		LocalDate localDate = PaymentStartDate.getValue();
		System.out.println("Loan Start Date: " +localDate);
		
		lblTotalPayments.setText("123");
		
		double doubleAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		System.out.println("Extra Payment: " + doubleAdditionalPayment);
		
		double doubleInterestRate = Double.parseDouble(InterestRate.getText());
		System.out.println("Interest rate on loan is: " + doubleInterestRate);
		
		Loan newLoan = new Loan(iTerm, doubleLoanAmount, doubleInterestRate, "Start Date", 0);

	}
}
