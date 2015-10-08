package lotto;

import java.util.Scanner;

/**
 * @file_name : SBS.java
 * @author    : pheonix0717@naver.com
 * @date      : 2015. 10. 7.
 * @story     : 로또 추첨(스윙)
 */
public class LottoShop {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Lotto lt = new Lotto();
		int[][] arr = new int[5][5];
		int temp=0;
		System.out.println("행운의 로또");
		System.out.println("금액을 입력하세요.");
		
	

		lt.inputMoney(scan.nextInt());
		lt.extractNum();
		System.out.println(lt.printLotto());
	}
}
