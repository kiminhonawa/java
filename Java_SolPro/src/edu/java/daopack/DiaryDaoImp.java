package edu.java.daopack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.java.TableDiary.TableDiary;
import edu.java.post.model.Post;
import oracle.jdbc.OracleDriver;

import static edu.java.post.model.Post.Entity.*;
import static edu.java.post.ojdbc.OracleConnect.*;

public class DiaryDaoImp implements DiaryDao {
	private static DiaryDaoImp instance = null;

	private DiaryDaoImp() {
	}

	public static DiaryDaoImp getInstance() {
		if (instance == null) {
			instance = new DiaryDaoImp();
		}
		return instance;
	}

	// 오라클 DB에 접속한 Connection 객체를 리턴.
	private Connection getConnection() throws SQLException {
		// 오라클 JDBC 드라이버 (라이브러리)를 등록.
		DriverManager.registerDriver(new OracleDriver());
		// 오라클 DB에 접속.
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

		return conn;
	}

	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}

	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}

	// select * from contacts order by cid
	private static final String SQL_SELECT_ALL = "select * from " + TBL_NAME + " order by " + COl_DID;

	@Override
	public List<Post> read() {
		ArrayList<Post> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) { // select 결과에서 행 (row) 데이터가 있으면
				int did = rs.getInt(COl_DID);
				String title = rs.getString(COL_TITLE);
				String post1 = rs.getString(COL_POST1);
				String author = rs.getString(COL_AUTHOR);
				LocalDateTime createdTime = rs.getTimestamp(COL_TIME_CREATED).toLocalDateTime();

				Post post = new Post(did, title, post1, author, createdTime);
				list.add(post);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	// select * from contacts where cid = ?;
	private static final String SQL_SELECT_BY_ID = "select * from " + TBL_NAME + " where " + COl_DID + " = ?";

	@Override
	public Post read(Integer did) {
		Post post = null; // select 결과를 저장하고 리턴하기 위한 변수

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_ID);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, did);
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면
				int id = rs.getInt(COl_DID);
				String title = rs.getString(COL_TITLE);
				String post1 = rs.getString(COL_POST1);
				String author = rs.getString(COL_AUTHOR);
				LocalDateTime createdTime = rs.getTimestamp(COL_TIME_CREATED).toLocalDateTime();
				post = new Post(id, title, post1, author, createdTime);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return post;
	}

	private static final String SQL_SELECT_BY_KEYWORD = "select * from POST " + " where lower(TITLE) like lower (?) "
			+ " or lower(POST1) like lower (?) " + " or lower(AUTHOR) like lower (?) " + " order by DID";

	@Override
	public List<Post> read(String keyword) {
		ArrayList<Post> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			System.out.println(SQL_SELECT_BY_KEYWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);

			String key = "%" + keyword + "%";
			System.out.println("keyword=" + keyword + ", key=" + key);

			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key);

			rs = stmt.executeQuery();
			while (rs.next()) {
				int did = rs.getInt(COl_DID);
				String title = rs.getString(COL_TITLE);
				String post1 = rs.getString(COL_POST1);
				String author = rs.getString(COL_AUTHOR);

				LocalDateTime createdTime = rs.getTimestamp(COL_TIME_CREATED).toLocalDateTime();
				Post post = new Post(did, title, post1, author, createdTime);
				list.add(post);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// insert into contacts (name, phone, email) values (?, ?, ?);
	private static final String SQL_INSERT = "insert into " + TBL_NAME + " (" + COL_TITLE + ", " + COL_POST1 + ", "
			+ COL_AUTHOR + ") " + " values (?, ?, ?)";

	@Override
	public int create(Post post) {
		int result = 0; // insert 결과를 저장하고 리턴할 변수

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_INSERT);
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getPost1());
			stmt.setString(3, post.getAuthor());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// update contacts set name = ?, phone = ?, email = ? where cid = ?;
	private static final String SQL_UPDATE = "update " + TBL_NAME + " set " + COL_TITLE + " = ?, " + COL_POST1
			+ " = ?, " + COL_AUTHOR + " = ? " + " where " + COl_DID + " = ?";

	@Override
	public int update(Post post) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			System.out.println(SQL_UPDATE);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, post.getTitle());
			stmt.setString(2, post.getPost1());
			stmt.setString(3, post.getAuthor());
			stmt.setInt(4, post.getDid());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	// delete from contacts where cid = ?;
	private static final String SQL_DELETE = "delete from " + TBL_NAME + " where " + COl_DID + " =?";

	@Override
	public int delete(Integer cid) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = getConnection();
			System.out.println(SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cid);
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private static String sql_insert_td = "insert into users values (?, ?, ?, ?)";

	@Override
	public int create(TableDiary tablediary) {
		int result = 0; // insert 결과를 저장하고 리턴할 변수

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql_insert_td);
			stmt.setString(1, tablediary.getEmail());
			stmt.setString(2, tablediary.getSelectedemail());
			stmt.setString(3, tablediary.getId());
			stmt.setString(4, tablediary.getPassword());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private static String sql_select_td = "select * from users where id = ? and password = ?";

	@Override
	public TableDiary readTD(TableDiary tdi) {
		TableDiary td = null; // select 결과를 저장하고 리턴하기 위한 변수

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			System.out.println(sql_select_td);
			stmt = conn.prepareStatement(sql_select_td);
			stmt.setString(1, tdi.getId());
			stmt.setString(2, tdi.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면
				String username = rs.getString("id");
				String password = rs.getString("password");

				td = new TableDiary(username, password);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return td;
	}

	private static String sql_select_id = "select * from users where id = ? ";

	@Override
	public String readTDI(String id) {
		String idx = null; // select 결과를 저장하고 리턴하기 위한 변수

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql_select_id);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면
				String username = rs.getString("id");

				idx = username;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return idx;
	}

	// 아이디 찾기
	private static String findid = "select id, email, selectedemail, password from users where email = ? and selectedemail = ? and password = ? ";

	@Override
	public TableDiary readLostId(String email, String selectedemail, String password) {
		System.out.println(email + selectedemail + password);
		TableDiary lid = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(findid);
			System.out.println("findid:" + findid);
			stmt.setString(1, email);
			stmt.setString(2, selectedemail);
			stmt.setString(3, password);
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면
				String findId = rs.getString("ID");
				String findEmail = rs.getString("EMAIL");
				String findselectedEmail = rs.getString("SELECTEDEMAIL");
				String findPassword = rs.getString("PASSWORD");
				lid = new TableDiary(findId, findEmail, findselectedEmail, findPassword);
				System.out.println("lid:" + lid.toString());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("lid:" + lid.toString());
		return lid;

	}

	private static String findpassword = "select password, email, selectedemail, id from users where email = ? and selectedemail = ? and id = ? ";

	public TableDiary readLostPassword(String email, String selectedemail, String id) {
		TableDiary lpassword = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(findpassword);
			System.out.println("findid:" + findpassword);
			stmt.setString(1, email);
			stmt.setString(2, selectedemail);
			stmt.setString(3, id);
			rs = stmt.executeQuery();
			if (rs.next()) { // 검색된 행(row) 데이터가 있다면
				String findId = rs.getString("ID");
				String findEmail = rs.getString("EMAIL");
				String findselectedEmail = rs.getString("SELECTEDEMAIL");
				String findPassword = rs.getString("PASSWORD");
				lpassword = new TableDiary(findPassword, findEmail, findselectedEmail, findId);
				System.out.println("lid:" + lpassword.toString());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("lpassword:" + lpassword.toString());
		return lpassword;
	}

}
