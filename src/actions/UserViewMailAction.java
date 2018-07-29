package actions;

import java.util.List;

import com.swinfosoft.mvc.web.*;

import dao.SendMailDao;
import entity.SendMail;
import entity.User;

public class UserViewMailAction implements Action {

	@Override
	public String processRequest() throws Exception {
		SendMailDao smd=new SendMailDao();
		User user=(User)ActionContext.getAttribute("user",ActionContext.SessionScope);
		  List<SendMail> list=smd.getMail(user.getId());
		  ActionContext.setAttribute("userViewMail", list);
		return "userViewMail";
	}

}
