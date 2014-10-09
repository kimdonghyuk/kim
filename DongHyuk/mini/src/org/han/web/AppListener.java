package org.han.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.han.dao.TimeDAO;
import org.han.service.TimeService;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger("AppListener");
    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
        
    	ServletContext ctx = event.getServletContext();
    	
    	for(int i = 0; i < 10; i++){
    		
    		logger.info("......................" + i);
    		
    	}
    	
    	//ctx.setAttribute("timeDAO", new TimeDAO());
    	
    	TimeService service = new TimeService();
    	service.setDao(new TimeDAO());
    	
    	ctx.setAttribute("timeService", service);
    	
    	
    	
    }
	
}













