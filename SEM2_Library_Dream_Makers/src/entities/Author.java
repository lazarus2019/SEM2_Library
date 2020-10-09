package entities;

public class Author {
	private String author_ID;
	private String name;
	private String nation;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String author_ID, String name, String nation) {
		super();
		this.author_ID = author_ID;
		this.name = name;
		this.nation = nation;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

}
