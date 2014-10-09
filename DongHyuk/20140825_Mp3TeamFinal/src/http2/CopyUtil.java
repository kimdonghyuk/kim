package http2;

import java.io.InputStream;
import java.io.OutputStream;

public class CopyUtil {

	public static void copy(InputStream in, OutputStream out, boolean inClose, boolean outClose)throws Exception{
		
		byte[] buffer = new byte[1024*8];
		
		while(true){
			
			int count = in.read(buffer);
			if(count == -1){ break; }
			out.write(buffer,0, count);
			
		}
		
		if(inClose){
			in.close();
		}
		
		if(outClose){
			out.close();
		}
		
		
	}
}