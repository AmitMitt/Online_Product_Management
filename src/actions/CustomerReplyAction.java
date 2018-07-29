package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketReplyDao;

public class CustomerReplyAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int trid=Integer.parseInt(ActionContext.getParameter("trId"));
		String ctr=ActionContext.getParameter("customerReplyText");
		TicketReplyDao dao=new TicketReplyDao();
		dao.updateReply(trid, ctr);
		ActionContext.setAttribute("message", "Customer reply sent successfully.");
		return "message";
	}

}
