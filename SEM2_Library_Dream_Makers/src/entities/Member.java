package entities;

import java.util.Date;

public class Member {

	private String member_ID;
	private String name;
	private Date dob;
	private boolean gender;
	private String address;
	private String phone;
	private String card_number;
	private String photo;

	public Member() {
		super();
	}

	public Member(String member_ID, String name, Date dob, boolean gender, String address, String phone,
			String card_number, String photo) {
		super();
		this.member_ID = member_ID;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.card_number = card_number;
		this.photo = photo;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
