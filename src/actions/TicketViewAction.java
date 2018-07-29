package actions;

import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import entity.Ticket;
import entity.User;


public class TicketViewAction implements Action {

	@Override
	public String processRequest()	throws Exception {
	//Reading request data
	HttpSession session=ActionContext.getSession();
	User u=(User)ActionContext.getAttribute("user",ActionContext.SessionScope);
	TicketDao dao=new TicketDao();
	LinkedList<Ticket> list=dao.getOpenTicketListByCid(u.getId());
	ActionContext.setAttribute("tickets", list);
		
	return "ticketView";
	}
	
}


