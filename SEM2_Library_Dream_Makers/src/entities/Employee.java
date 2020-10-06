package entities;

import java.util.Date;

public class Employee {

	private String employee_ID;
	private String username;
	private String password;
	private String name;
	private Date dob;
	private boolean gender;
	private String address;
	private String phone;
	private String email;
	private String photo;
	private String level;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employee_ID, String username, String password, String name, Date dob, boolean gender,
			String address, String phone, String email, String photo, String level) {
		super();
		this.employee_ID = employee_ID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.photo = photo;
		this.level = level;
	}

	public String getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}