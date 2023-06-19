package goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfo {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	GoodMain main = new GoodMain(); 

	private void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void UserInfo() {
		Login login = new Login();
		Scanner scn = new Scanner(System.in);
		System.out.println("사용할 ID>");
		String id = scn.nextLine();
		System.out.println("사용할 PASSWORD>");
		String pw = scn.nextLine();
		System.out.println("이름을 입력>");
		String name = scn.nextLine();

		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into table_users (user_id, user_pw, user_name)"//
				+ " values('" + id + "','" + pw + "','" + name + "')";
		
		try {
			conn = Dao.getConnect();
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			// 중복 체크

			if (r > 0) {
				System.out.println("회원가입 완료");
				main.main(null);
			} else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception e) {
			System.out.println("아이디가 중복");
			UserInfo();
			
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
