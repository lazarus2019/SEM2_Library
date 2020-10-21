package entities;

import java.sql.Blob;
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
	private Date start_date;
	private Date exp_date;
	private Blob src;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String member_ID, String name, Date dob, boolean gender, String address, String phone,
			String card_number, String photo, Date start_date, Date exp_date, Blob src) {
		super();
		this.member_ID = member_ID;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.card_number = card_number;
		this.photo = photo;
		this.start_date = start_date;
		this.exp_date = exp_date;
		this.src = src;
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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public Blob getSrc() {
		return src;
	}

	public void setSrc(Blob src) {
		this.src = src;
	}
	
	

}
