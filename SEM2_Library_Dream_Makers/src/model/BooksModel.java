package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sun.mail.imap.protocol.Status;

import connect.ConnectDB;
import entities.Author;
import entities.Books;
import entities.Bor_book;
import entities.Borrow_bill;
import entities.FamousBook;
import entities.ObseleteBook;

public class BooksModel {

	static String sql;

	public static List<Books> findAll() {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("SELECT * FROM books WHERE isDelete = false");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setPrice(resultSet.getDouble("price"));
				book.setIsDeleteBoolean(resultSet.getBoolean("isDelete"));
				books.add(book);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			books = null;
		}

		return books;
	}

	// Start NNHV
	public Books find(String id) {

		Books book = new Books();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("select * from books where book_ID = ?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setPrice(resultSet.getDouble("price"));
				book.setIsDeleteBoolean(resultSet.getBoolean("isDelete"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			book = null;
		}

		return book;

	}

	public List<Books> searchBooks(String keyword) {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from books where title like ? and isDelete = false");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setIsDeleteBoolean(resultSet.getBoolean("isDelete"));
				books.add(book);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}

	public List<Books> getTitleBook(int borrow_ID, int status) {
		try {
			List<Books> books = new ArrayList<Books>();
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(
					"select * from bor_book bo, books b where bo.borrow_ID = ? and bo.status = ? and bo.book_ID = b.book_ID");
			preparedStatement.setInt(1, borrow_ID);
			preparedStatement.setInt(2, status);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setTitle(resultSet.getString("title"));
				books.add(book);
			}
			return books;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public double getPrice(String idBook) {
		try {
			double price = 0;
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select price from books where book_ID = ?");
			preparedStatement.setString(1, idBook);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				price = resultSet.getDouble("price");
			}
			return price;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	public boolean updateBookLost(String book_ID) {
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("update books set quantity = quantity - 1 where book_ID = ?");
			preparedStatement.setString(1, book_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	// End NNHV

	// Start NVT
	public String findPublish(int publish_ID) {
		String name = null;
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" select * from publish_house where publish_ID = ?  ");
			preparedStatement.setInt(1, publish_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			name = null;
		}
		return name;

	}
	
	public static boolean create(Books book) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" insert into books(book_ID,call_number,isbn,title,category_ID,publish_ID,price,quantity,isDelete) values(?,?,?,?,?,?,?,?,?) ");

			preparedStatement.setString(1, book.getBook_ID());
			preparedStatement.setString(2, book.getCall_number());
			preparedStatement.setString(3, book.getIsbn());
			preparedStatement.setString(4, book.getTitle());
			preparedStatement.setInt(5, book.getCategory_ID());
			preparedStatement.setInt(6, book.getPublish_ID());
			preparedStatement.setDouble(7, book.getPrice());
			preparedStatement.setInt(8, book.getQuantity());
			preparedStatement.setBoolean(9, false);
			
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean updateIsDelete(int isDelete , String book_ID) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" update books set isDelete = ?  where book_ID = ?  ");

			preparedStatement.setInt(1, isDelete);
			preparedStatement.setString(2, book_ID);
			
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}
	public static boolean update(Books book, String book_ID) {

		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" update books set call_number = ? , isbn = ? , title = ? , category_ID = ? , publish_ID = ? , price = ? , quantity = ? where book_ID = ?  ");
			preparedStatement.setString(1, book.getCall_number());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setInt(4, book.getCategory_ID());
			preparedStatement.setInt(5, book.getPublish_ID());
			preparedStatement.setDouble(6, book.getPrice());
			preparedStatement.setInt(7, book.getQuantity());
			preparedStatement.setString(8, book_ID);
			
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean delete(String book_ID) {
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("delete from books where book_ID = ? ");
			preparedStatement.setString(1, book_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			return false;
		}

	}
	
	public static List<Books> findByBill(int borrow_ID ) {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement("SELECT borrow_bill.borrow_ID , books.* FROM bor_book , borrow_bill, books WHERE borrow_bill.borrow_ID = ? and borrow_bill.borrow_ID = bor_book.borrow_ID and bor_book.book_ID = books.book_ID");
			
			preparedStatement.setInt(1, borrow_ID );
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setPrice(resultSet.getDouble("price"));
				book.setIsDeleteBoolean(resultSet.getBoolean("isDelete"));
				books.add(book);

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			books = null;
		}

		return books;
	}

	public List<Author> findAuthor(String book_ID) {
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection().prepareStatement(
					" SELECT books.title as bookTitle , author.author_ID as authorID , author.name as authorName FROM author, books ,"
					+ "au_book WHERE author.author_ID = au_book.author_ID and au_book.book_ID = books.book_ID and books.book_ID = ?  ");
			preparedStatement.setString(1, book_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Author author = new Author();
				author.setAuthor_ID("authorID");
				author.setName(resultSet.getString("authorName"));
				authors.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			authors = null;
		}
		return authors;

	}

	public List<Books> searchBooksbyCate(int category_ID) {
		List<Books> books = new ArrayList<Books>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection()
					.prepareStatement("select * from books where category_ID = ?");
			preparedStatement.setInt(1, category_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Books book = new Books();
				book.setBook_ID(resultSet.getString("book_ID"));
				book.setCall_number(resultSet.getString("call_number"));
				book.setIsbn(resultSet.getString("isbn"));
				book.setTitle(resultSet.getString("title"));
				book.setCategory_ID(resultSet.getInt("category_ID"));
				book.setPublish_ID(resultSet.getInt("publish_ID"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setIsDeleteBoolean(resultSet.getBoolean("isDelete"));
				
				books.add(book);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}
	
	public String findCategory(int category_ID) {
		String name = null;
		try {
			PreparedStatement preparedStatement = new ConnectDB().getConnection()
					.prepareStatement(" select * from category where category_ID = ?  ");
			preparedStatement.setInt(1, category_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			name = null;
		}
		return name;
	}
	// End NVT

	// Get Obselete bills by month and year - NTS
	public static List<Borrow_bill> getBills(int month, int year, int op) {
		List<Borrow_bill> bills = new ArrayList<Borrow_bill>();

		// Switch condition
		switch (op) {
		case 1:
			sql = "SELECT * FROM borrow_bill b WHERE status = 1 AND YEAR(b.return_date) = ?";
			break;
		case 2:
			sql = "SELECT * FROM borrow_bill b WHERE status = 1 AND YEAR(b.return_date) = ? AND MONTH(b.return_date) = ?";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			switch (op) {
			case 1:
				preparedStatement.setInt(1, year);
				break;
			case 2:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				break;
			default:
				return null;
			}

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (checkBWDate(resultSet.getDate("term_date"), resultSet.getDate("return_date"))) {
					Borrow_bill bill = new Borrow_bill();
					bill.setBorrow_ID(resultSet.getInt("borrow_ID"));
					bill.setMember_ID(resultSet.getString("member_ID"));
					bill.setEmployee_ID(resultSet.getString("employee_ID"));
					bill.setTerm_date(resultSet.getDate("term_date"));
					bill.setReturn_date(resultSet.getDate("return_date"));
					bills.add(bill);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return bills;
		}
		return bills;
	}

	// Get Obselete book - NTS
	public static List<ObseleteBook> getObseleteBook(List<Borrow_bill> bills, int status) {
		List<ObseleteBook> books = new ArrayList<ObseleteBook>();
		MemberModel memberModel = new MemberModel();
		EmployeeModel employeeModel = new EmployeeModel();
		for (Borrow_bill bill : bills) {
			sql = "SELECT title AS tt FROM bor_book b, books bs WHERE status = ? AND borrow_ID = ? AND b.book_ID = bs.book_ID";
			try {
				PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
				preparedStatement.setInt(1, status);
				preparedStatement.setInt(2, bill.getBorrow_ID());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					ObseleteBook book = new ObseleteBook();
					book.setInvoice_ID(bill.getBorrow_ID());
					book.setReturn_date(bill.getReturn_date());
					book.setTerm_date(bill.getTerm_date());
					book.setEmployee_name(employeeModel.getNameById(bill.getEmployee_ID()));
					book.setTitle(resultSet.getString("tt"));
					book.setCard_number(memberModel.getCardNoById(bill.getMember_ID()));
					books.add(book);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		return books;
	}

	// Check between date - NTS
	public static boolean checkBWDate(Date dateOne, Date dateTwo) {
		return (dateOne.getTime() - dateTwo.getTime()) < 0;
	}

	// AMOUNT OF BOOK BY MONTH - NTS
	public static int getAmountBookByMonth(int month) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int amountBook = 0;
		sql = "SELECT COUNT(b.book_ID) AS amountB FROM bor_book b, borrow_bill bb WHERE MONTH(bb.borrow_date) = ? AND YEAR(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			amountBook = resultSet.getInt("amountB");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return amountBook;
	}

	// GET FAMOUS BOOKS - NTS
	public static List<FamousBook> getFamousBook(int day, int month, int year, int option) {
		List<FamousBook> books = new ArrayList<FamousBook>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT b.book_ID AS bookID, bs.title, COUNT(b.book_ID) AS 'amount' FROM bor_book b, borrow_bill bb, books bs WHERE YEAR(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID AND b.book_ID = bs.book_ID GROUP BY b.book_ID ORDER BY COUNT(b.book_ID) DESC LIMIT 5";
			break;
		case 1:
			sql = "SELECT b.book_ID AS bookID, bs.title, COUNT(b.book_ID) AS 'amount' FROM bor_book b, borrow_bill bb, books bs WHERE YEAR(bb.borrow_date) = ? AND MONTH(bb.borrow_date) = ? AND DAY(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID AND b.book_ID = bs.book_ID GROUP BY b.book_ID ORDER BY COUNT(b.book_ID) DESC LIMIT 5";
			break;
		case 2:
			sql = "SELECT b.book_ID AS bookID, bs.title, COUNT(b.book_ID) AS 'amount' FROM bor_book b, borrow_bill bb, books bs WHERE YEAR(bb.borrow_date) = ? AND MONTH(bb.borrow_date) = ? AND DAY(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID AND b.book_ID = bs.book_ID GROUP BY b.book_ID ORDER BY COUNT(b.book_ID) DESC LIMIT 5";
			break;
		case 3:
			sql = "SELECT b.book_ID AS bookID, bs.title, COUNT(b.book_ID) AS 'amount' FROM bor_book b, borrow_bill bb, books bs WHERE YEAR(bb.borrow_date) = ? AND MONTH(bb.borrow_date) = ? AND b.borrow_ID = bb.borrow_ID AND b.book_ID = bs.book_ID GROUP BY b.book_ID ORDER BY COUNT(b.book_ID) DESC LIMIT 5";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			switch (option) {
			case 0:
				preparedStatement.setInt(1, year);
				break;
			case 1:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				preparedStatement.setInt(3, day);
				break;
			case 2:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, Calendar.getInstance().get(Calendar.MONTH) + 1);
				preparedStatement.setInt(3, day);
				break;
			case 3:
				preparedStatement.setInt(1, year);
				preparedStatement.setInt(2, month);
				break;
			default:
				return null;
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				FamousBook book = new FamousBook();
				book.setAmount(resultSet.getInt("amount"));
				book.setBook_ID(resultSet.getString("bookID"));
				book.setTitle(resultSet.getString("title"));
				books.add(book);
			}
		} catch (Exception e) {
			return null;
		}
		return books;
	}

}