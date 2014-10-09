package io4;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class DataOutEx {

	// bad code
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("192.168.0.77", 5555);
		// Socket ∞≥º≥
		
		DataInputStream din =
				new DataInputStream(socket.getInputStream());
		// ª°¥Î∏¶ ≤»æ“¿∏∏Á ¿–¿∏∏È DataInø°º≠ title¿ª ª©¡·¿∏π«∑Œ title¿ª ª°æ∆µÈ¿Ã∞‘µ .
		
		String title = din.readUTF();
		System.out.println(title);
		// title¿ª ¿–æÓµÂ∏≤
		
		FileOutputStream fos
		= new FileOutputStream("C:\\zzz\\copy_" + title);
		// ∞Ê∑Œø° outputª°¥Î∏¶ ≤»¿Ω
		
		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = din.read(buffer);
			if(count == -1){break;}
			fos.write(buffer,0,count);
		}
		

	}
}
