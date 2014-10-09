package io3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	
	public static void main(String[] args) {
		
		InputStream in = null;
		OutputStream out = null;
		
		try{
			in = new FileInputStream("C:\\zzz\\sample.pdf");
			out = new FileOutputStream("C:\\zzz\\copy.pdf");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{		// close�� ����ó���� �ܵ������� ���־���Ѵ�.
			if(in != null){try{in.close();	}catch(Exception ee){}}
			// catch�ڿ� �극���� ����ִ� ���� : finally�� ���� �������� ����ó���ε� �׶��� ����ó���� �ؾ��ϴ� �ͱ��� ó�����ֱ� ����...
			// in�� ���� close�ϴ� ���� : �츮�� data�� in�� �� while �����鼭 -1�϶� üũ�ؼ� ������ ������ ���� �������� �Ͼ�� �۾��̹Ƿ� ���� ó����.
			if(out != null){try{out.close();}catch(Exception ee){}}
			
		}
		
	}

}
