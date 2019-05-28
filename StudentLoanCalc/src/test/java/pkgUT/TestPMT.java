package pkgUT;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;
import app.controller.Loan;
import app.controller.Payment;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		double PMTExpected = 1162.95;
		assertEquals(PMTExpected, PMT, 0.01);
		Loan loanTest = new Loan(20, p , r*1200 , "Start date", 0);	
		Payment paymentTest = new Payment(loanTest);
		assertEquals(paymentTest.getActualPmt(), PMTExpected, 0.01);
		assertEquals(paymentTest.getFormerBalance(), p , 0.01);
	}
	
	@Test
	public void totalPaymentTest1() {
		double principle = 200000;
		int loanTerm = 15;
		double interestRate = 8;
		double expected = 344034;
		Loan loanTest1 = new Loan(loanTerm ,principle , interestRate , "Start date", 0);	
		Payment paymentTest1 = new Payment(loanTest1);
		assertEquals(expected, ((paymentTest1.getActualPmt())*(loanTerm*12)), 1);

	}

}


