package entities;

public class Publish_house {

	private int publish_ID;
	private String name;
	private String address;
	private String phone;
	public int getPublish_ID() {
		return publish_ID;
	}
	public void setPublish_ID(int publish_ID) {
		this.publish_ID = publish_ID;
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
	public Publish_house(int publish_ID, String name, String address, String phone) {
		super();
		this.publish_ID = publish_ID;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public Publish_house() {
		super();
	}

	
}
