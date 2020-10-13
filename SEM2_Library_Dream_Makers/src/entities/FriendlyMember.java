package entities;

import java.util.Date;

public class FriendlyMember {
	private String member_ID;
	private String name;
	private int amountB;

	public FriendlyMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendlyMember(String member_ID, String name, int amountB) {
		super();
		this.member_ID = member_ID;
		this.name = name;
		this.amountB = amountB;
	}

	public String getMember_ID() {
		return member_ID;
	}

	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountB() {
		return amountB;
	}

	public void setAmountB(int amountB) {
		this.amountB = amountB;
	}

}
