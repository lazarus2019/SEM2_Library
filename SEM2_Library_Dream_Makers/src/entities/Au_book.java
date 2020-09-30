package entities;

public class Au_book {
	private String book_ID;
	private String author_ID;

	public Au_book() {
		super();
	}

	public Au_book(String book_ID, String author_ID) {
		super();
		this.book_ID = book_ID;
		this.author_ID = author_ID;
	}

	public String getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(String book_ID) {
		this.book_ID = book_ID;
	}

	public String getAuthor_ID() {
		return author_ID;
	}

	public void setAuthor_ID(String author_ID) {
		this.author_ID = author_ID;
	}

}
