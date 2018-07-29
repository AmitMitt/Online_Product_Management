package actions;

import com.swinfosoft.mvc.web.*;

import dao.SendMailDao;
import entity.*;

public class SendMailAction implements Action
{
    public String processRequest() throws Exception
    {
        int pid=Integer.parseInt(ActionContext.getParameter("pid"));
        String msg=ActionContext.getParameter("message");
        User user=(User)ActionContext.getAttribute("user", ActionContext.SessionScope);
        SendMail mail=new SendMail();
                 mail.setpId(pid);
                 mail.setMessage(msg);
                 mail.setcId(user.getId());
                 mail.setReplyOn(0);
        SendMailDao smd=new SendMailDao();
                    smd.saveMail(mail);
        ActionContext.setAttribute("message", "Mail Successfully Send");
    	return "sendMail";
    }
}
