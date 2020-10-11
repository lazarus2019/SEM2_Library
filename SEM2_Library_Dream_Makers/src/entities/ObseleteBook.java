package entities;

import java.util.Date;

public class ObseleteBook {
	private String card_number;
	private String employee_name;
	private String title;
	private String invoice_ID;
	private Date return_date;
	private Date term_date;
	private double fee;

	public ObseleteBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObseleteBook(String card_number, String employee_name, String title, String invoice_ID, Date return_date,
			Date term_date, double fee) {
		super();
		this.card_number = card_number;
		this.employee_name = employee_name;
		this.title = title;
		this.invoice_ID = invoice_ID;
		this.return_date = return_date;
		this.term_date = term_date;
		this.fee = fee;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInvoice_ID() {
		return invoice_ID;
	}

	public void setInvoice_ID(String invoice_ID) {
		this.invoice_ID = invoice_ID;
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
