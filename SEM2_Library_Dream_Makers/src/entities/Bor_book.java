package entities;

import java.util.Date;

public class Bor_book {

	private String book_ID;
	private String borrow_ID;
	private Date borrow_date;
	private Date return_date;
	private Date term_date;
	private double fee;

	public Bor_book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bor_book(String book_ID, String borrow_ID, Date borrow_date, Date return_date, Date term_date, double fee) {
		super();
		this.book_ID = book_ID;
		this.borrow_ID = borrow_ID;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.term_date = term_date;
		this.fee = fee;
	}

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getBorrow_ID() {
		return borrow_ID;
	}

	public void setBorrow_ID(String borrow_ID) {
		this.borrow_ID = borrow_ID;
	}

	public Date getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public Date getTerm_date() {
		return term_date;
	}

	public void setTerm_date(Date term_date) {
		this.term_date = term_date;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	
}
