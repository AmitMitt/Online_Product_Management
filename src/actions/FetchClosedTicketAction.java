package actions;

import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import entity.Ticket;

public class FetchClosedTicketAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		
		TicketDao dao=new TicketDao();
		
		List<Ticket> tlist=dao.getCloseTicketList();
		ActionContext.setAttribute("tickets",tlist);
		return "viewCloseTicket";
	}

}
