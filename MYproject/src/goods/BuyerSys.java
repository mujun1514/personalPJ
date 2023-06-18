package goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyerSys {

	static Connection conn;
	static PreparedStatement psmt;
	static ResultSet rs;
	static String sql;
	
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
	
//	public String buySys(String name, String number) {
//		conn = Dao.getConnect();
//		sql = "update user_table set user_point - (good_name * user"
//		
//		return number;
//		
//	}
	
	public boolean pointPlus(String point, String id) {
		
		conn = Dao.getConnect();
		sql = "update user_table set user_point = ? "
				+ "where user_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, point);
			psmt.setString(2, id);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				System.out.println("충전");
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return false;
	}
}
