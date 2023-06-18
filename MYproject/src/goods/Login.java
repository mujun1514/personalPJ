package goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {

	static Connection conn;
	static PreparedStatement psmt;
	static ResultSet rs;
	static String sql;
	static String pp;
	
	private static void close() {
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

	static boolean longin() {

		Scanner scn = new Scanner(System.in);
		GoodVO boardVo = new GoodVO();
		GoodMain main = new GoodMain();

		System.out.print("ID : ");
		String id = scn.nextLine();
		System.out.print("PASSWORD : ");
		String pw = scn.nextLine();
		pp =id;
		conn = Dao.getConnect();
		
		sql = "select * from user_table where user_id=? and user_pw=?";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
//				System.out.println(rs.getString(1));
				if (rs.getString(1).equals(id) && rs.getString(2).equals(pw)) {
					return true;
				} else if(!rs.getString(1).equals(id) && !rs.getString(2).equals(pw)){
					System.out.println("로그인 실패");
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

}
