package util;

import java.util.Queue;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import dao.TicketDao;
import entity.Ticket;

public class QueueLoaderListener implements ServletContextListener {

	Logger logger = Logger.getRootLogger();

	public void contextDestroyed(ServletContextEvent e) {

	}

	public void contextInitialized(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();
		try {
			TicketDao dao = new TicketDao();
			Queue<Ticket> list = dao.getOpenTicketList();
			ctx.setAttribute("tQueue", list);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		logger.info("context initialized, listings are placed in app scope.");

	}

}