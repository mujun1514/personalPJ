package goods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.LongToIntFunction;

public class Buyer {
	private BuyerSys sys = new BuyerSys();
	private Login log;
	public void BuyerMethod() {
		int selno = 0;
		SysList syl = new SysList();
		Scanner scn = new Scanner(System.in);
		Login logg =new Login();
		while (true) {
			System.out.println("=========================================");
			System.out.println("1상품조회 & 구매 || 2포인트충전 || 3프로그램 종료");
			System.out.println("=========================================");
			selno = scn.nextInt();

			if (selno == 1) {
				syl.listStart();

				System.out.println("구매할 음식의 이름을 입력해주세요");
				String good_name = scn.next();
				System.out.println("구매할 개수를 입력해주세요");
				String goods_number = scn.next();
				
//				sys.buySys(good_name,goods_number);
				//현재포인트 - 개수 * 가격 = result
				//이름 개수 저장후 메서드보내기
				
				//if(성공)
			} else if (selno == 2) {
				UserVO user = new UserVO();
				System.out.println("얼마를 충전하시겠습니까?");
				String point = scn.next();
				String id = logg.pp;
				
				sys.pointPlus(point,id);
				
				//현재 포인트 
				System.out.println("현재 포인트는 : "+user.getUser_point());
				
			}else if(selno == 3) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
