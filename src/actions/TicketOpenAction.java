package actions;

import java.util.Queue;

import javax.servlet.ServletContext;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import entity.Ticket;

public class TicketOpenAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int tid=Integer.parseInt(ActionContext.getParameter("tid"));
		TicketDao dao=new TicketDao();
		          dao.openStatus(tid);
		Queue<Ticket> tqueue=dao.getOpenTicketList();
		ServletContext ctx = ActionContext.getServletContext();
		ctx.setAttribute("tQueue", tqueue);
		 ActionContext.setAttribute("message", "Ticket Status Change To Open");
		return "message";
	}

}
