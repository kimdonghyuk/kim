package org.han.mp32.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.Part;

public class UploadUtil {
	
	public static String upload(Part part, String saveDir)throws Exception{
		
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		
		String fileName = UUID.randomUUID().toString();	// 유니크한 아이디를 만드는데 사용하며 거의 꼬이는 일이 없어!
		

		for (String s : items) {
            if (s.trim().startsWith("filename")) {
                fileName += "_" + s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }

		
		part.write(saveDir + File.separator + fileName);
		
		return fileName;
	}

}
