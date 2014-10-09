package io3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyBuffer {
	
	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();	// 0.001초 단위로 세는거
		
		InputStream in =
				new FileInputStream("C:\\zzz\\birdStory.mp3");
		OutputStream out =
				new FileOutputStream("C:\\zzz\\copyBird.mp3");
		
		byte[] buffer = new byte[1024*8];	// 크기 5의 바이트 배열
		
//		byte[] buffer = new byte[5];	// 크기 5의 바이트 배열
		
		while(true){
			int count = in.read(buffer);	// buffer = 바이트 배열을 저장하는 단위 변수
			//System.out.println(count);
						
			if(count == -1){
				break;
			}
			out.write(buffer,0,count);		// 
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}

}
