package entities;

import java.util.Date;

public class BookBorrow extends Borrow_bill {
	private String title;
	private String statusOk;
	private String memberName;

	public BookBorrow(String title, String statusOk, String memberName) {
		super();
		this.title = title;
		this.statusOk = statusOk;
		this.memberName = memberName;
	}

	public BookBorrow() {
		super();
	}

	public BookBorrow(int borrow_ID, String member_ID, String employee_ID, String description, boolean status,
			Date borrow_date, Date term_date, Date return_date, Double deposit_fee, Double late_fee,
			Double compensation_fee) {
		super(borrow_ID, member_ID, employee_ID, description, status, borrow_date, term_date, return_date, deposit_fee,
				late_fee, compensation_fee);
	}

	// GET & SET
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatusOk() {
		return statusOk;
	}

	public void setStatusOk(String statusOk) {
		this.statusOk = statusOk;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
