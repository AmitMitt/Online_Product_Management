package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.SendMailDao;
import entity.SendMail;

public class MessageDetailsAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int id=Integer.parseInt(ActionContext.getParameter("id"));
		SendMailDao smd=new SendMailDao();
		           SendMail sm= smd.getMailMessageById(id);
		ActionContext.setAttribute("mailDetails",sm);
		return "messageDetail";
	}

}
