package thread;

public class SingleRunnable implements Runnable{

	private int[] temp;
	public SingleRunnable(){
		
		temp = new int[3];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	
	
	@Override
	public void run() {
		for(int start : temp) {
			try {
				Thread.sleep(1000); // 1ms 만큼 쉬어라
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("스레드 이름 : %s " ,Thread.currentThread().getName()); //current쓸수 있는 이유는 위에 Thread자체를 상속받아서.
			
		}
	}
	
}
