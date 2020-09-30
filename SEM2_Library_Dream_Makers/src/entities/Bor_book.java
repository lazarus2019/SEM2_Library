package entities;

public class Bor_book {

	private String book_ID;
	private String borrow_ID;

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getBorrow_ID() {
		return borrow_ID;
	}

	public void setBorrow_ID(String borrow_ID) {
		this.borrow_ID = borrow_ID;
	}

	public Bor_book() {
		super();
	}

	public Bor_book(String book_ID, String borrow_ID) {
		super();
		this.book_ID = book_ID;
		this.borrow_ID = borrow_ID;
	}

}
