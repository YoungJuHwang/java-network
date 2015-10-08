package lotto;

public class Lotto {
	//횟수별 6개의 로또 번호 저장을 위한 2차원 배열 선언
	private int[][] lottos; //5000원이면 5장 발급.
	private int money;
	
	public void inputMoney(int money) {
		this.money = money;
		lottos = new int[money/1000][6];
		
	}

	public void extractNum() {
		int count = 0;
		int i = 0;
		for (count = 0; count < lottos.length; count++) {
			while(true) {
				// 추출된 랜덤숫자 담음. 중복여부 체크
				// 중복로직 통과하면
				if (isDupl(count, vote())) {
					continue;
				} else {
					lottos[count][i] = vote(); // 그 숫자를 담아야함.
					i++;
				}
				
				if (i == lottos[count].length) {
					i = 0;
					break;
				}
			}
		}
		
	}

	public String printLotto() {
		System.out.println("++++++++++ 부자되세요 +++++++++");
		for (int i = 0; i < lottos.length; i++) {
			sort(null);
			for (int j = 0; j < lottos[0].length; j++) {
				System.out.print(lottos[i][j]+"\t");
			}
			System.out.println();
		}
		return null;
	}
	
	private int vote(){ //랜덤숫자 발생.
		return (int) (Math.random()*45+1);
	}
	/*
	 * 앞에서 추출된 숫자가 뒤에서 다시 추출되는 것을 막기위해
	 * 숫자 중복여부를 체크해야함.
	 * count => money/1000 개념으로 돈에 따른 로또 횟수
	 */
	private boolean isDupl(int count, int randomNum) {
		for (int i = 0; i < lottos[count].length; i++) { //로또 1회 (6번)
			if (lottos[count][i] == randomNum) { //lottos[1][i] == randomNum
				return true; //중복됬음.
			}
		}
		return false;
		
	}
	
	private void sort(int[] arr) {
		
	}
}
