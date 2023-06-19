package goods;

import java.util.Scanner;

public class ServicePart {
	public void part(String id, String pw) {
		Login login = new Login();
		Buyer buyer = new Buyer();

		Scanner scn = new Scanner(System.in);
		int selno = 0;
		String loginYn;
		while (true) {
			System.out.println("1관리자 2구매자");
			System.out.println("입력>");
			selno = scn.nextInt();

			if (selno == 1) {
				System.out.println("관리자로 로그인 해주세요");
				while (true) {
					System.out.println("===============상품등록===============");
					System.out.println("로그인 창입니다. 로그인 하시겠습니까? (Y/N)");
					System.out.println("로그인 (Y)(N)");
					loginYn = scn.next();

					if (loginYn.toUpperCase().equals("Y")) {
						System.out.println("관리자 로그인 창입니다");
						if (login.longin(id,pw)) {
							GoodMain main = new GoodMain();
							System.out.println("로그인 완료");
							main.start();
						} else {
							System.out.println("로그인 실패");
							continue;
						}
					} else {
						System.out.println("다음에 찾아와주세요");
						break;
					}
				}
				break;
			} else if (selno == 2) {
				while (true) {
					System.out.println("구매자 창입니다.");
					System.out.println("로그인 창입니다. 로그인 하시겠습니까? (Y/N)");
					System.out.println("Y로그인 : N회원가입");
					loginYn = scn.next();
					if (loginYn.toUpperCase().equals("Y")) {
						if (login.longin(id,pw)) {
							GoodMain main = new GoodMain();
							System.out.println("로그인 완료");
							buyer.BuyerMethod();
						}
					} else if (loginYn.toUpperCase().equals("N")) {
						System.out.println("회원가입 창입니다");
						UserInfo userinfo = new UserInfo();
						userinfo.UserInfo();
					} else {
						System.out.println("잘못입력");
						break;
					}
				}
			}

		}
	}
}
