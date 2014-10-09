package org.han.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LogTestServlet
 */
@WebServlet("/log")
public class LogTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LoggerFactory.getLogger("controller");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.debug("Debug...............");
		logger.info("info..................");
		logger.warn("warn...................");
		logger.error("error ................");
		
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";
            
            Connection con = DriverManager.getConnection(jdbcDriver);
            
            logger.info(con.getClass().getName());
            
            //¿ø·¡´Â finally 
            con.close();
            
		} catch (Exception e) {
			logger.error(e.getMessage());
			
		}
		

	}

}












