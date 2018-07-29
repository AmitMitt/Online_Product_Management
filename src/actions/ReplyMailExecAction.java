package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.SendMailDao;
import entity.SendMail;
import entity.User;

public class ReplyMailExecAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int cid=Integer.parseInt(ActionContext.getParameter("cid"));
		int pid=Integer.parseInt(ActionContext.getParameter("pid"));
		String message=ActionContext.getParameter("message");
		User user=(User) ActionContext.getAttribute("user", ActionContext.SessionScope);
		SendMail sm=new SendMail();
		         sm.setcId(user.getId());
		         sm.setpId(pid);
		         sm.setReplyOn(cid);
		         sm.setMessage(message);
		SendMailDao dao=new SendMailDao();
		            dao.saveMail(sm);
		ActionContext.setAttribute("message", "Reply Successfully");
		return "replyMailExec";
	}

}
