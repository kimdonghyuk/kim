package org.han.mp32.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaySong
 */
@WebServlet("/playSong")
public class PlaySong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaySong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ps진입");
		String songPath = "C:/zzz" + request.getParameter("song");
		System.out.println("재생파일 최종경로 : " + songPath);
		FileInputStream fin = new FileInputStream(songPath);
		OutputStream out = response.getOutputStream();
		
		
		byte[] buffer = new byte[1024*8];
		while(true){
			int count = fin.read(buffer);
			if(count == -1){
				break;
			}
			out.write(buffer,0,count);
		}
		
		fin.close();
		
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/player.jsp");
		dispatcher.forward(request, response);
	}

}
