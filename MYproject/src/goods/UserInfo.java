package goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInfo {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

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
		String sql = "insert into user_table (user_id, user_pw, user_name)"//
				+ " values('" + id + "','" + pw + "','" + name + "')";
		try {

			conn = Dao.getConnect();

			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				System.out.println("회원가입 완료");
				login.longin();
			} else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
