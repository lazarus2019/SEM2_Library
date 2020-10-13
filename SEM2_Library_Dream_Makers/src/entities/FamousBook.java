package entities;

public class FamousBook {
	private String book_ID;
	private String title;
	private int amount;

	public FamousBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FamousBook(String book_ID, String title, int amount) {
		super();
		this.book_ID = book_ID;
		this.title = title;
		this.amount = amount;
	}

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
