package entities;

import java.util.Date;

public class StatisticalBook {
	private String title;
	private String employee_ID;
	private String member_ID;
	private int status;

	public StatisticalBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticalBook(String title, String employee_ID, String member_ID, int status) {
		super();
		this.title = title;
		this.employee_ID = employee_ID;
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

	public String getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
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
