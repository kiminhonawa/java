package edu.java.jdbc4;

import static edu.java.jdbc.model.Blog.Entity.*;
import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain04 {

	public static void main(String[] args) {
		// 과제 JDBC delete:
		// delete from BLOGS where ID = ?
		
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = String.format("delete from Blogs where %s = ? ",
					COL_ID);
			System.out.println(sql);
			
			stmt = conn.prepareStatement(sql);
			
			System.out.print("삭제할 글 번호>>> ");
			Integer id =Integer.parseInt(scanner.nextLine());
			
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			System.out.println(result + "개 행이 삭제됐습니다.");		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
				
			}
		}

	}

}
