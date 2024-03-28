package 과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Youngjoongbookmarketv2 {
	static final int NUM_MENU = 4;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		displayWelcome();

		main: for (;;) {
			displayMainmenu();
			do {
				input = br.readLine();
				if (Integer.parseInt(input) < 0 || Integer.parseInt(input) > 4)
					System.out.printf("없는 메뉴입니다. 0번부터 %d번까지의 메뉴 중에서 선택하세요.\n", NUM_MENU);
			} while (!(0 <= Integer.parseInt(input) && Integer.parseInt(input) <= 4));// 0~4인 경우만 탈출

			switch (Integer.parseInt(input)) {

			case 1 -> showBooklist();

			case 2 -> showCart();

			case 3 -> addCart();

			case 4 -> cleanCart();

			case 0 -> {
				break main;
			}

//                default -> System.out.printf("");//위에서 걸러지는데 굳이? hoxy?
			}
		}
		System.out.printf("Youngjoong Book Market을 종료합니다.");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void displayWelcome() {
		System.out.printf("*************************************\n");// 환영인사
		System.out.printf("* Welcome to Youngjoong Book Market *\n");
		System.out.printf("*************************************\n");
	}

	static void displayMainmenu() {
		System.out.printf("=====================================\n");// 메인메뉴
		System.out.printf("1. 도서 목록 보기\n2. 장바구니 보기\n3. 장바구니에 도서 추가\n4. 장바구니 비우기\n0. 종료\n");
		System.out.printf("=====================================\n");
	}

	static int idTobooklist(String id) {// 입력값 ID -> 출력값 bookList행번호
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i][0].substring(2, 6).equals(id)) {
				return i;
			}
		}
		return 99;// 리스트에 없다는 의미로 99반환. 오류코드로 사용
	}

	static void showBooklist() {// 북리스트를 보여준다
		System.out.printf(">> 도서 목록\n");
		System.out.printf("--------------------------------------------------------------------\n");
		for (int i = 0; i < bookList.length; i++) {
			System.out.printf("%s %s %s %s %s\n", bookList[i][0], bookList[i][1], bookList[i][2], bookList[i][3],
					bookList[i][4]);
		}
		System.out.printf("--------------------------------------------------------------------\n");
	}

	static void showCart() {
		if (numCartItem == 0)
			System.out.printf("장바구니가 비어있습니다.\n");

		System.out.printf("--------------------------------------------------------------------\n");
		for (int i = 0; i < numCartItem; i++) {
			System.out.printf("%d권, %s %s %s %s %s\n", i + 1, bookList[cartList[i]][0], bookList[cartList[i]][1],
					bookList[cartList[i]][2], bookList[cartList[i]][3], bookList[cartList[i]][4]);
		}
		System.out.printf("--------------------------------------------------------------------\n");
	}

	static void cleanCart() {
		for (int i = 0; i < cartList.length - 1; i++) {
			cartList[i] = 0;
			numCartItem = 0;
		}
		System.out.printf(">> 장바구니에 있는 아이템을 모두 삭제하였습니다.\n");
	}

	static void addCart() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		if (cartList.length <= numCartItem) {
			System.out.printf("장바구니에 더 이상 담을 수 없습니다.\n장바구니를 비운 후 이용해주세요.\n");
			return;
		}
		showBooklist();
		System.out.printf(">> 추가할 도서 ID 입력 : ");
		input = br.readLine();// 예외처리 할 수 있게 개선해야함
		if (input.length() > 4 || idTobooklist(input) == 99) {// 4자리 이상 or 리턴값99이상
			System.out.printf("ID를 제외한 숫자 4자리를 정확히 입력해주세요.\n");
		}
		cartList[numCartItem] = idTobooklist(input);
		System.out.printf(">> 장바구니 추가 : %s\n", bookList[idTobooklist(input)][1]);
		numCartItem++;
	}

	static String[][] bookList = { { "ID2401", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", "20,000원" },
			{ "ID2402", "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", "30,000원" },
			{ "ID2403", "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스 퍼블리싱", "25,000원" } };
	static int[] cartList = { 0, 0, 0 };

	static int numCartItem = 0;
}