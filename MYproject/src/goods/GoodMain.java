package goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GoodMain {
	private static GoodVO gv;
	private GoodDao dao = new GoodDao();
	private static SysList lsy = new SysList();
	private static Scanner scn = new Scanner(System.in);
	private String id;

	public static void main(String[] args) {
//		boolean a = true;
//
//		Login login = new Login();
//
//		ServicePart Part = new ServicePart();
//		Part.part();
		
		Login login = new Login();
		
		String loginYn;
		
		while (true) {
			GoodMain main = new GoodMain();
			System.out.println("=============상품관리===============");
			System.out.println("로그인 창입니다. 로그인 하시겠습니까? (Y/N)");
			System.out.println("Y로그인 : N회원가입");
			System.out.print(">");
			loginYn = scn.next();
			if (loginYn.toUpperCase().equals("Y")) {
				if (login.longin()) {
					System.out.println("로그인 완료");
					main.start();
				}
			} else if (loginYn.toUpperCase().equals("N")) {
				System.out.println("회원가입 창입니다");
				UserInfo userinfo = new UserInfo();
				userinfo.UserInfo();
				main.start();
			} else {
				System.out.println("잘못입력");
				break;
			}
		}
		
	}

	public void start() {
		while (true) {
			GoodDao dao = new GoodDao();
			int selNum = 0;
			System.out.println("===================================================================");
			System.out.println("1상품등록 || 2상품입,출고 || 3상품삭제 || 4상품조회 || 5상품목록 || 6프로그램 종료");
			System.out.println("===================================================================");
			System.out.println("번호를 선택해주세요>:");
			selNum = scn.nextInt();
			// 등록
			if (selNum == 1) {
				lsy.registerStart();
				// 수정
			} else if (selNum == 2) {
				System.out.println("===============================");
				// 조회
				lsy.listStart();
				// 수정
				lsy.updateStart();
				

			} else if (selNum == 3) {
				// 제거
				lsy.removeStart();

			} else if (selNum == 4) {
				// 선택조회
				lsy.searchStart();

			} else if (selNum == 5) {
				System.out.println("===============================");
				System.out.println("목록 창 입니다.");

				lsy.listStart();

			} else if (selNum == 6) {
				System.out.println("프로그램 종료.");
				System.out.println("===============================");
				break;
			}
		}

	}
}
