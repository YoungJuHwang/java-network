package synch;
/**
 * @file_name : ATM.java
 * @author    : pheonix0717@naver.com
 * @date      : 2015. 10. 8.
 * @story     : 동기화 관련 예제
 */
public class ATmMain {
	/*
	 * 동기화(synchronized)
	 *  - 한개의 공유자원을 여러 개의 스레드가 이용할 때
	 *  - 해당 스레드만 제외하고, 나머지는 접근금지 시키는 것.
	 *  - 이 작업을 락(lock)이라 한다.
	 *  - 자바 동기화는 syschronized 키워드를 사용.
	 */
	public static void main(String[] args) {
		ATM atm = new ATM(); // ATM 객체 생성. 
		Runnable hong = new AtmUser(atm, "홍길동"); // hong이 atm 이 객체를 사용한다. 실제 이름은 홍길동
		Runnable kim = new AtmUser(atm, "김유신"); // kim 이 객체를 사용한다. 실제 이름은 홍길동
		Runnable hwang = new AtmUser(atm, "황희"); // hwang 이 atm 이 객체를 사용한다. 실제 이름은 홍길동
		
		Thread t1 = new Thread(hong);  //한 객체를 여러명이 사용하므로 줄을 세움.
		Thread t2 = new Thread(kim);
		Thread t3 = new Thread(hwang);
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
}
class ATM {
	public synchronized void withdraw(String name){
		System.out.println(name + "고객이 돈 인출을 요청함");
		for (int i = 0; i < 100000; i++) {
			if (i == 10000) {
				System.out.println(name + "님이 돈을 인출함");
			}
		}
		System.out.println(name + "님이 돈을 인출한 후 ATM을 나감");
	
	}
}
class AtmUser implements Runnable{
	ATM atm; //스레드가 특정 객체를 공유하는 모양.
	String name;

	public AtmUser(ATM atm, String name){
		super(); //부모 기능을 그대로 가져다 사용.
		this.atm = atm;
		this.name = name;
	}
	
	@Override
	public void run() {
		atm.withdraw(name);
	}
	
}