package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @file_name : MemberRegister.java
 * @author    : pheonix0717@naver.com
 * @date      : 2015. 10. 8.
 * @story     : 회원 등록 프로그램
 */
public class MemberRegister {
	/**
	 * 신규회원 가입 프로그램.
	 * 저장은 바탕화면 temp폴더에 아이디.txt로 저장.
	 * 기존에 등록된 회원이면 이미 등록된 회원이라고 띄움.
	 * 존재하지 않으면 해당아이디.txt 파일 생성.
	 * hong.txt 홍길동 파일
	 * 해당 회원이 가입한 날짜,시간까지 저장.
	 * [결과]
	 * hong.txt
	 * 아이디 : hong
	 * 비밀번호 : 1234
	 * 이름 : 홍길동
	 * 가입일 : 2015-10-08 4:18 오후
	 */
	 public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("ID, PASS, NAME 입력 : ");
		String id = scan.next();
		String pass = scan.next();
		String name = scan.next();
		String fileName = "C:\\Users\\HB\\Desktop\\temp\\"+id+".txt";
		//저장할 파일의 이름을 변수로 지정할 수 있음.
		String buf = ""; //파일 내용을 콘솔에 보여주기 위한 문자열.
		File file = new File(fileName);
		if (!file.exists()) {
			BufferedWriter bw;
			Date today = new Date();
			SimpleDateFormat asd;
			asd = new SimpleDateFormat("yyyy-MM-dd H:mm:ss a");
			try {
				bw = new BufferedWriter(new FileWriter(new File(fileName)));
				bw.write(id);
				bw.newLine();
				bw.write(pass);
				bw.newLine();
				bw.write(name);
				bw.newLine();
				bw.write(asd.format(today));
				bw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("만듬");
		} else {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				try {
					while ((buf = br.readLine()) != null) {
						System.out.println(buf);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class Member implements Serializable{ // 객체 직렬화p743
	private static final long serialVersionUID = 1L; //객체에서 해시값.
	private String id;
	private String pass;
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	
}









