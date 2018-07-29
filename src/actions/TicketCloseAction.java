package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;

public class TicketCloseAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("TicletCloseAction is processing..");
		int tid=Integer.parseInt(ActionContext.getParameter("tid"));
		TicketDao dao=new TicketDao();
		dao.closeTicket(tid);
		ActionContext.setAttribute("message", "Ticket closed successfully.");
		return "message";
	}

}
