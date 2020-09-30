package entities;

import java.sql.Date;

public class Borrow_bill {

	private String borrow_ID;
	private String member_ID;
	private String employee_ID;
	private String description;
	private boolean status;
	private Date borrow_date;
	private Date term_date;
	private Date return_date;
	private Double deposit_fee;
	private Double late_fee;

	public Borrow_bill() {
		super();
	}

	public Borrow_bill(String borrow_ID, String member_ID, String employee_ID, String description, boolean status,
			Date borrow_date, Date term_date, Date return_date, Double deposit_fee, Double late_fee) {
		super();
		this.borrow_ID = borrow_ID;
		this.member_ID = member_ID;
		this.employee_ID = employee_ID;
		this.description = description;
		this.status = status;
		this.borrow_date = borrow_date;
		this.term_date = term_date;
		this.return_date = return_date;
		this.deposit_fee = deposit_fee;
		this.late_fee = late_fee;
	}

	public String getBorrow_ID() {
		return borrow_ID;
	}

	public void setBorrow_ID(String borrow_ID) {
		this.borrow_ID = borrow_ID;
	}

	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getBorrow_date() {
		return borrow_date;
	}

	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}

	public Date getTerm_date() {
		return term_date;
	}

	public void setTerm_date(Date term_date) {
		this.term_date = term_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public Double getDeposit_fee() {
		return deposit_fee;
	}

	public void setDeposit_fee(Double deposit_fee) {
		this.deposit_fee = deposit_fee;
	}

	public Double getLate_fee() {
		return late_fee;
	}

	public void setLate_fee(Double late_fee) {
		this.late_fee = late_fee;
	}

}
