package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.SendMailDao;
import entity.SendMail;


public class MailReplyAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int id=Integer.parseInt(ActionContext.getParameter("id"));
		   int cid=Integer.parseInt(ActionContext.getParameter("cid"));
		   SendMailDao dao=new SendMailDao();
		   SendMail mail=dao.getMailMessageById(id, cid);
		   ActionContext.setAttribute("mail", mail);
		return "mailMessage";
	}

}
