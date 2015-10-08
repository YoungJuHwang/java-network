package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * @file_name : StreamNote.java
 * @author    : pheonix0717@naver.com
 * @date      : 2015. 10. 8.
 * @story     : stream 표준 문법(eclipse를 벗어나...)
 */
public class StreamNote {
	/* 모든 스르팀(데이터의 흐름 :) 2가지 종류가 있따.
	 * 	1. 바이트 스트림(튜프 지름 작고, 작지만 빠르다) 
	 *  2. 문자 스트림(튜브의 지름이 바이트 2배 크기. 용량이 큼
	 * InputStream = IS;
	 * 기본형타입(primitive) => P타입
	 * 객체형타입(referemce) => R타입
	 * DataIs(OS) : P 타입.
	 * ObjectIS(OS)
	 * BufferedIs(OS) : 바이트를 버퍼에 저징후 한꺼번에 입출력
	 * 문자 스트림은 Reader(Writer) => getter,setter를 클래스화 한 형상
	 *  
	 */
	public static void main(String[] args) {
		String fileName = "C:\\Users\\HB\\Desktop\\temp\\test.txt"; // 역슬레쉬는 2개씩 // 저장할 text파일 경로 지정.
		String buffer = ""; 
		BufferedWriter bw; //선언하는 것은 try에 걸리지 않게 하는 것이 좋음.
		BufferedReader br;
		try {
			bw = new BufferedWriter(new FileWriter(new File(fileName)));
			//BufferedWriter => 우리가 입력한 것들을 파일로 만들지 않고 일단 모아놈.
			bw.write("안녕"); //write는 파일 내부에서의 set 개념과 같음. 스캐너로 안녕 입력받는거랑 같음.
			bw.newLine(); // System.out.println();  줄바꿈(\n)
			bw.write("반갑다 자바야"); //L33~35 데이터들이 전부 BufferWriter에 저장되어짐.
			bw.close(); // 항상 달아 주어야 저장이 됨. (카톡에서 문자 쓰고 엔터누르는 것과 동일)
			
			br = new BufferedReader(new FileReader(new File(fileName))); //콘솔에 출력하기 위해 파일을 읽어들임.
			while ((buffer = br.readLine()) != null) { // 읽어들인 내용 끝까지.
				System.out.println(buffer);
			}
			br.close(); //버퍼를 닫아줘야함. 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}
}
