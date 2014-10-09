package org.han.mp32.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
	maxFileSize=1024*1024*10,      // 10MB
	maxRequestSize=1024*1024*50)   // 50MB
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// File�� ���� ���ε�ǵ��� �ϴ� �κ�
		
		
		Part filePart = request.getPart("filename");	// file�� parts�� ����
		try {
			String Fname = UploadUtil.upload(filePart, "C:\\zzz");
			System.out.println(Fname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String contentDisp = filePart.getHeader("content-disposition");
		// content-disposition���� ������ ������ �������.
		
//		filePart.write("C:\\zzz\\test.mp3");
		
//		MP3 mp3 = new MP3(request.getParameter("fileName"),request.getParameter("desc"));
//		
//		System.out.println(mp3);
//		
//		Mp3Service.instance.addMp3(mp3);
//		
		response.sendRedirect("list");
		// ������� URL��ü�� List�� ����Ű�� ��.
		
	}
}
