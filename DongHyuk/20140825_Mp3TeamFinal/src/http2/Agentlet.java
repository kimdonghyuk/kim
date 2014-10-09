package http2;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class Agentlet {
	
	static Map<String, String> mimeMap;
	
	static {
		mimeMap = new HashMap<String, String>();
		mimeMap.put("mp3","audio/mpeg3");
		mimeMap.put("jpg","image/jpeg");
		mimeMap.put("htm","text/html");
		
	}
	
	public void makeResponseHearder(String ext, int size,  ResponseOutputStream res)throws Exception{
		OutputStream out = res.getOut();
		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
		out.write(new String("Cache-Control: private\r\n").getBytes()); 
	    out.write(new String("Content-Length: "+size+"\r\n").getBytes()); 
	    out.write(new String("Content-Type: "+ mimeMap.get(ext)+"; charset=UTF-8\r\n\r\n").getBytes());
	}

	public abstract void doJob(
			RequestInputStream request, 
			ResponseOutputStream response)throws Exception;
	
}