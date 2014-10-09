package org.han.mp32.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.han.mp32.service.Mp3Service;
import org.han.mp32.vo.MP3;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<MP3> list = Mp3Service.instance.getFolderList("");
		
		request.setAttribute("mp3List", list); 		
		
		String dir = request.getParameter("dir");		
		if(dir == null){
			dir = "";
		}
		
		if(dir.length() > 1){
			request.setAttribute("path", dir.substring(0,dir.lastIndexOf("/")));
		}

		File root = new File("C:\\zzz\\" + dir);
		String[] fileList = root.list();
		
		request.setAttribute("fileList", Arrays.asList(fileList));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request,response);
		
	
	}

}
