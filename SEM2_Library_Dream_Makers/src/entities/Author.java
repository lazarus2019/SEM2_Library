package entities;

public class Author {
	private String author_ID;
	private String name;
	private String address;
	private String phone;

	public Author() {
		super();
	}

	public Author(String author_ID, String name, String address, String phone) {
		super();
		this.author_ID = author_ID;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getAuthor_ID() {
		return author_ID;
	}

	public void setAuthor_ID(String author_ID) {
		this.author_ID = author_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
