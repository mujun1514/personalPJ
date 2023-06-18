package goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String userid;
	private String userPw;
	private String userName;
	private String userPhone;
	private String userAddr;
	private String user_point;
	
	public UserVO(String id, String pw){
		this.userid = userid;
		this.userPw = userPw;
	}
}
