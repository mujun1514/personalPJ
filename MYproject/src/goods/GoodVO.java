package goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodVO {
//필드: 아이디,비밀번호,상품명,가격,내용,작성일,조회수   
// 기능 : 등록,수정,삭제,조회,목록,
	// 디비 기능 :로그인 시 작성자이름으로 자동저장,작성일sysdate,조회수+1 보기,페이징
	private String good_no;
	private String good_name;
	private String good_price;
	private String good_content;
	private int goods_number;
	private String good_date;
	private String good_cnt;

	public GoodVO(String good_no, String good_name, String good_price, String good_content, int goods_number) {
		this.good_no = good_no;
		this.good_name = good_name;
		this.good_price = good_price;
		this.good_content = good_content;
		this.goods_number = goods_number;
	}
}
