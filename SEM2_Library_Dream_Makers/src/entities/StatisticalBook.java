package entities;

import java.util.Date;

public class StatisticalBook {
	private String title;
	private int bill_ID;
	private String member_ID;
	private int status;

	public StatisticalBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticalBook(String title, int bill_ID, String member_ID, int status) {
		super();
		this.title = title;
		this.bill_ID = bill_ID;
		this.member_ID = member_ID;
		this.status = status;
	}

	// GET & SET
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBill_ID() {
		return bill_ID;
	}

	public void setBill_ID(int bill_ID) {
		this.bill_ID = bill_ID;
	}

	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
