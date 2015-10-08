package thread;

import java.util.Random;

public class SnailRace {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("경주 시작");
		System.out.println("달팽이들 출발 준비...");
		Snails s1 = new Snails("성한");
		Snails s2 = new Snails("준규");
		Snails s3 = new Snails("순환");
		Snails s4 = new Snails("혜숙");
		s1.setPriority(10);
		s2.setPriority(3);
		s3.setPriority(2);
		s4.setPriority(1);
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		// 달팽이들이 경기를 마치기 전까지 main() 스레드를
		// 종료시키면 안되기 때문에 블럭시켜야 하므로
		// join()을 호출한다.
		
		s1.join(); //throw에러 클릭 -> main에 throw Interrupted 생김.
		s2.join();
		s3.join();
		s4.join();
		
		System.out.println("달팽이 경주 종료");
	}
	
}
class Snails extends Thread{
	public Snails(String name) {
		super (name);
	}
	@Override
	public void run() {
		Random r = new Random();
		for (int i = 0; i <= 100; i++) {
			int randomNum = r.nextInt(501); //1~500까지 랜덤 숫자 발생.
			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName()+"달팽이"+i+"미터 전진");
		}
		System.out.println(getName()+"달팽이가 결승점 통과!");
	}
	
}