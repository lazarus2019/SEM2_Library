package entities;

public class Bor_book {

	private int no;
	private String book_ID;
	private int borrow_ID;
	private int status;
	private String description;

	public Bor_book() {
		super();
	}

	public Bor_book(int no, String book_ID, int borrow_ID, int status, String description) {
		super();
		this.no = no;
		this.book_ID = book_ID;
		this.borrow_ID = borrow_ID;
		this.status = status;
		this.description = description;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public int getBorrow_ID() {
		return borrow_ID;
	}

	public void setBorrow_ID(int borrow_ID) {
		this.borrow_ID = borrow_ID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
