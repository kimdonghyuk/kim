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
		}finally{		// close의 예외처리는 단독적으로 해주어야한다.
			if(in != null){try{in.close();	}catch(Exception ee){}}
			// catch뒤에 브레스가 비어있는 이유 : finally는 거의 최종적인 예외처리인데 그때도 예외처리를 해야하는 것까지 처리해주기 난해...
			// in을 먼저 close하는 이유 : 우리가 data를 in할 때 while 돌리면서 -1일때 체크해서 끝내기 때문에 가장 마지막에 일어나는 작업이므로 먼저 처리함.
			if(out != null){try{out.close();}catch(Exception ee){}}
			
		}
		
	}

}
