package entities;

import java.sql.Date;

public class Lib_card {

	private String card_number;
	private Date date;
	private Date expiration_date;
	private String description;

	public Lib_card() {
		super();
	}

	public Lib_card(String card_number, Date date, Date expiration_date, String description) {
		super();
		this.card_number = card_number;
		this.date = date;
		this.expiration_date = expiration_date;
		this.description = description;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
