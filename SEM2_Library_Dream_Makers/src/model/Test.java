package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connect.ConnectDB;
import entities.Books;
import entities.Bor_book;
import entities.Borrow_bill;
import entities.ObseleteBook;

public class Test {
	static String sql;
	static SimpleDateFormat spdf = new SimpleDateFormat("dd/MM/yyyy");
	static String[] alls = null;

	public static void main(String[] args) {
		String[][] a = null;
//		String[] b 

		List<Borrow_bill> test = new ArrayList<Borrow_bill>();
//		test = getObseleteBill(11, 2020);
//		System.out.println(test);
//		List<ObseleteBook> ssss = getAll(11, 2020);
//		System.out.println(ssss.size());
//		for(ObseleteBook o : ssss) {
//			System.out.println(o.getTitle());
//		}

		List<Bor_book> hmm = getObseleteBook(10, 2020);

		List<ObseleteBook> okok = getAll(hmm);
		for(ObseleteBook o : okok) {
			System.out.println(o.getTitle());
		}

	}

//	public static List<ObseleteBook> getAll(int month, int year) {
//		List<ObseleteBook> alls = new ArrayList<ObseleteBook>();
//		sql = "SELECT "
//				+ "b.title AS book_title, "
//				+ "bbill.borrow_ID AS iv_ID, "
//				+ "bbill.member_ID AS me_ID, "
//				+ "bbill.employee_ID AS em_ID, "
//				+ "bbill.borrow_date AS bo_date, "
//				+ "bbill.term_date AS te_date, "
//				+ "bbill.return_date AS re_date, "
//				+ "bbill.late_fee AS fee "
//				+ "FROM borrow_bill bbill, bor_book bbook, books b "
//				+ "WHERE bbill.borrow_ID = bbook.borrow_ID "
//				+ "AND b.book_ID = bbook.book_ID "
//				+ "AND bbill.status = 1 "
//				+ "AND MONTH(bbill.return_date) = ? "
//				+ "AND YEAR(bbill.return_date) = ?";
//		try {
//			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
//			preparedStatement.setInt(1, month);
//			preparedStatement.setInt(2, year);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				if (checkBWDate(resultSet.getString("iv_ID"))) {
//					ObseleteBook obseleteBook = new ObseleteBook();
//					obseleteBook.setTitle(resultSet.getString("book_title"));
//					obseleteBook.setEmployee_ID(resultSet.getString("em_ID"));
//					obseleteBook.setInvoice_ID(resultSet.getString("iv_ID"));
//					obseleteBook.setMember_ID(resultSet.getString("me_ID"));
//					obseleteBook.setTerm_date(resultSet.getDate("te_date"));
//					obseleteBook.setReturn_date(resultSet.getDate("re_date"));
//					obseleteBook.setBorrow_date(resultSet.getDate("bo_date"));
//					obseleteBook.setFee(resultSet.getDouble("fee"));
//					alls.add(obseleteBook);
//				}
//			}
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
//		return alls;
//	}

	public static List<ObseleteBook> getAll(List<Bor_book> books) {
		List<ObseleteBook> alls = new ArrayList<ObseleteBook>();
		sql = "SELECT employee_ID, member_ID, title FROM borrow_bill, books WHERE borrow_ID = ? AND book_ID = ?";
		for (Bor_book book : books) {
			try {
				PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
				preparedStatement.setString(1, book.getBorrow_ID());
				preparedStatement.setString(2, book.getBook_ID());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					ObseleteBook all = new ObseleteBook();
					all.setFee(book.getFee());
					all.setInvoice_ID(book.getBorrow_ID());
					all.setTerm_date(book.getTerm_date());
					all.setReturn_date(book.getReturn_date());
					all.setTitle(resultSet.getString("title"));
					alls.add(all);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return alls;
	}

	public static Borrow_bill findBill(String borrow_ID) {
		sql = "SELECT * FROM borrow_bill WHERE borrow_ID = ?";
		Borrow_bill bill = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, borrow_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				bill = new Borrow_bill();
				bill.setBorrow_ID(resultSet.getString("borrow_ID "));
				bill.setMember_ID(resultSet.getString("member_ID"));
				bill.setEmployee_ID(resultSet.getString("employee_ID"));
				bill.setLate_fee(resultSet.getDouble("late_fee"));
				bill.setTerm_date(resultSet.getDate("term_date"));
				bill.setReturn_date(resultSet.getDate("return_date"));
				bill.setBorrow_date(resultSet.getDate("borrow_date"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return bill;
	}

	// Get Obselete bill by month and year
	public static List<Bor_book> getObseleteBook(int month, int year) {
		sql = "SELECT * FROM bor_book WHERE status = 1 AND MONTH(return_date) = ? AND YEAR(return_date) = ?";
		List<Bor_book> books = new ArrayList<Bor_book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (checkBWDate(resultSet.getDate("term_date"), resultSet.getDate("return_date"))) {
					Bor_book book = new Bor_book();
					book.setBorrow_ID(resultSet.getString("borrow_ID"));
					book.setBook_ID(resultSet.getString("book_ID"));
					book.setFee(resultSet.getDouble("late_fee"));
					book.setReturn_date(resultSet.getDate("return_date"));
					book.setTerm_date(resultSet.getDate("term_date"));
					book.setBorrow_date(resultSet.getDate("borrow_date"));
					books.add(book);
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return books;
	}

	public static boolean checkBWDate(Date dateOne, Date dateTwo) {
		return (dateOne.getTime() - dateTwo.getTime()) < 0;
	}

//	public static List<Books> getBooks(List<String> bills) {
//		
//	}
}
