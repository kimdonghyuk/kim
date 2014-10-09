package io3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyBuffer {
	
	public static void main(String[] args) throws Exception {
		
		long start = System.currentTimeMillis();	// 0.001�� ������ ���°�
		
		InputStream in =
				new FileInputStream("C:\\zzz\\birdStory.mp3");
		OutputStream out =
				new FileOutputStream("C:\\zzz\\copyBird.mp3");
		
		byte[] buffer = new byte[1024*8];	// ũ�� 5�� ����Ʈ �迭
		
//		byte[] buffer = new byte[5];	// ũ�� 5�� ����Ʈ �迭
		
		while(true){
			int count = in.read(buffer);	// buffer = ����Ʈ �迭�� �����ϴ� ���� ����
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
