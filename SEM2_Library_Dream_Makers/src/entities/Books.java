package entities;

public class Books {

	private String book_ID;
	private String call_number;
	private String isbn;
	private String title;
	private int category_ID;
	private int publish_ID;
	private int quantity;

	public Books() {
		super();
	}

	public Books(String book_ID, String call_number, String isbn, String title, int category_ID, int publish_ID,
			int quantity) {
		super();
		this.book_ID = book_ID;
		this.call_number = call_number;
		this.isbn = isbn;
		this.title = title;
		this.category_ID = category_ID;
		this.publish_ID = publish_ID;
		this.quantity = quantity;
	}

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getCall_number() {
		return call_number;
	}

	public void setCall_number(String call_number) {
		this.call_number = call_number;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory_ID() {
		return category_ID;
	}

	public void setCategory_ID(int category_ID) {
		this.category_ID = category_ID;
	}

	public int getPublish_ID() {
		return publish_ID;
	}

	public void setPublish_ID(int i) {
		this.publish_ID = i;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
