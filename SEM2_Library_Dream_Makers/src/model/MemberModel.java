package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hpsf.Blob;

import connect.ConnectDB;
import entities.Author;
import entities.FamousBook;
import entities.FriendlyMember;
import entities.Member;

public class MemberModel {
	static String sql;

	// Start NTA
	public List<Member> findAll() {
		Connection con = ConnectDB.getConnection();
		try {
			List<Member> members = new ArrayList<Member>();
			PreparedStatement preparedStatement = con.prepareStatement("select * from member");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setDob(resultSet.getDate("dob"));
				members.add(member);
			}
			return members;
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// Create - NTanh
	public static boolean Add(Member member) {
		sql = "INSERT into member(member_ID, name, dob, gender, address, phone, card_number, start_date, expiration_date, photo, src, isDelete) values(?,?,?,?,?,?,?, ?, ?, null, null, 0)";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, member.getMember_ID());
			preparedStatement.setString(2, member.getName());
			preparedStatement.setDate(3, new java.sql.Date(member.getDob().getTime()));
			preparedStatement.setBoolean(4, member.isGender());
			preparedStatement.setString(5, member.getAddress());
			preparedStatement.setString(6, member.getPhone());
			preparedStatement.setString(7, member.getCard_number());
			preparedStatement.setDate(8, new java.sql.Date(member.getStart_date().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(member.getExp_date().getTime()));
			return preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			return false;
		}

	}

	// Update - NTanh
	public static boolean update(Member member, String member_ID) {
		sql = " update member set member_ID = ? , name = ? , dob = ? , gender = ? , address = ? , phone = ? , card_number = ? , photo = ? where member_ID = ? ";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);

			preparedStatement.setString(1, member.getMember_ID());
			preparedStatement.setString(2, member.getName());
			preparedStatement.setDate(3, new java.sql.Date(member.getDob().getTime()));
			preparedStatement.setBoolean(4, member.isGender());
			preparedStatement.setString(5, member.getAddress());
			preparedStatement.setString(6, member.getPhone());
			preparedStatement.setString(7, member.getCard_number());
			preparedStatement.setString(8, member.getPhoto());
			preparedStatement.setString(9, member_ID);
			return preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}

	// Delete - NTanh

	public static boolean delete(String member_ID) {

		sql = "DELETE FROM member WHERE member_ID = ?";
		try {
			PreparedStatement preparedStatement = ConnectDB.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			return preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}

	}
	// Search Member

	public List<Member> searchMember(String keyword) {
		Connection con = ConnectDB.getConnection();
		List<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from member where name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setDob(resultSet.getDate("dob"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
				members.add(member);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return members;
	}

	public List<Member> searchMemberGender(int keyword) {
		Connection con = ConnectDB.getConnection();
		List<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from member where gender like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setDob(resultSet.getDate("dob"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
				members.add(member);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return members;
	}

	public List<Author> findAuthor(String book_ID) {
		Connection con = ConnectDB.getConnection();
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(
					" SELECT books.title as bookTitle , author.name as authorName FROM author, books ,"
							+ "au_book WHERE author.author_ID = au_book.author_ID and au_book.book_ID = books.book_ID and books.book_ID = ?  ");
			preparedStatement.setString(1, book_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Author author = new Author();
				author.setName(resultSet.getString("authorName"));
				authors.add(author);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			authors = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return authors;

	}
	// End NTA

	// Start NNHV
	public Member find(String idCard) {
		Connection con = ConnectDB.getConnection();
		Member member = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from member where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			member = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return member;
	}

	public String getMemberID(String idCard) {
		Connection con = ConnectDB.getConnection();
		String member_ID = null;
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement("select member_ID from member where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				member_ID = resultSet.getString("member_ID");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return member_ID;
	}
	
	public static Date getCreatedByIDCard(String ID_Card) {
		Connection con = ConnectDB.getConnection();
		Date created = new Date();
		sql = "SELECT start_date FROM member WHERE card_number = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ID_Card);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				created = resultSet.getDate("start_date");
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return created;
	}

	public Date getExpirationDate(String idCard) {
		Connection con = ConnectDB.getConnection();
		try {
			Date expiration_date = null;
			PreparedStatement preparedStatement = con
					.prepareStatement("select expiration_date from member where card_number = ?");
			preparedStatement.setString(1, idCard);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				expiration_date = resultSet.getDate("expiration_date");
			}
			return expiration_date;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	// End NNHV

	// Start NVT - NTA
	public Member findByID(String member_ID) {
		Connection con = ConnectDB.getConnection();
		Member member = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement("select * from member where member_ID = ?");
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				member = new Member();
				member.setMember_ID(resultSet.getString("member_ID"));
				member.setName(resultSet.getString("name"));
				member.setDob(resultSet.getDate("dob"));
				member.setGender(resultSet.getBoolean("gender"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setCard_number(resultSet.getString("card_number"));
				member.setPhoto(resultSet.getString("photo"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			member = null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return member;
	}
	// End NVT

	// Get card number by id - NTS
	public static String getCardNoById(String member_ID) {
		Connection con = ConnectDB.getConnection();
		sql = "SELECT * FROM member WHERE member_ID = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("card_number");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// GET NEW MEMBER BY MONTH - NTS
	public static int getNewMember(int month) {
		Connection con = ConnectDB.getConnection();
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int memberAM = 0;
		sql = "SELECT COUNT(member_ID) AS 'amount' FROM member WHERE MONTH(start_date) = ? AND YEAR(start_date) = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, month);
			preparedStatement.setInt(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			memberAM = resultSet.getInt("amount");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return 0;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return memberAM;
	}

	// GET FRIENDLY MEMBER - NTS
	public static List<FriendlyMember> getFriendlyMember(int day, int month, int year, int option) {
		Connection con = ConnectDB.getConnection();
		List<FriendlyMember> members = new ArrayList<FriendlyMember>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.member_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 1:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND DAY(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.member_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 2:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND DAY(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.member_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		case 3:
			sql = "SELECT br.member_ID AS memberID,m.name AS mbname, COUNT(bb.book_ID) AS 'amount' FROM bor_book bb, borrow_bill br, member m WHERE bb.borrow_ID = br.borrow_ID AND YEAR(br.borrow_date) = ? AND MONTH(br.borrow_date) = ? AND br.member_ID = m.member_ID GROUP BY br.member_ID ORDER BY COUNT(bb.book_ID) DESC LIMIT 5";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
				FriendlyMember member = new FriendlyMember();
				member.setMember_ID(resultSet.getString("memberID"));
				member.setName(resultSet.getString("mbname"));
				member.setAmountB(resultSet.getInt("amount"));
				members.add(member);
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return members;
	}

	// GET NEW MEMBER - NTS
	public static List<Member> getAllNewMember(int day, int month, int year, int option) {
		Connection con = ConnectDB.getConnection();
		List<Member> newMembers = new ArrayList<Member>();

		// Switch condition
		switch (option) {
		case 0:
			sql = "SELECT * FROM member WHERE YEAR(start_date) = ?";
			break;
		case 1:
			sql = "SELECT * FROM member WHERE  YEAR(start_date) = ? AND MONTH(start_date) = ? AND DAY(start_date) = ?";
			break;
		case 2:
			sql = "SELECT * FROM member WHERE  YEAR(start_date) = ? AND MONTH(start_date) = ? AND DAY(start_date) = ?";
			break;
		case 3:
			sql = "SELECT * FROM member WHERE  YEAR(start_date) = ? AND MONTH(start_date) = ?";
			break;
		default:
			return null;
		}

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
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
				Member newMember = new Member();
				newMember.setMember_ID(resultSet.getString("member_ID"));
				newMember.setCard_number(resultSet.getString("card_number"));
				newMember.setName(resultSet.getString("name"));
				newMembers.add(newMember);
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return newMembers;
	}

	// GET START DATE CARD - NTS
	public static Date getStartDateCard(String member_ID) {
		Date start_date = null;
		Connection con = ConnectDB.getConnection();

		sql = "SELECT * FROM member WHERE member_ID = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				start_date = resultSet.getDate("start_date");
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return start_date;
	}
	
	// GET MEMBER NAME BY MEMBER ID
	public static String getNameByID(String member_ID) {
		String memberName = null;
		Connection con = ConnectDB.getConnection();
		sql = "SELECT name FROM member WHERE member_ID = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, member_ID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				memberName = resultSet.getString("name");
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return memberName;
	}
}
