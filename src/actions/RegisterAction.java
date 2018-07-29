package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.UserDao;
import entity.User;

public class RegisterAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext
	String s=ActionContext.getParameter("name");
	User user=new User();
	user.setName(s);
	user.setMailId(
			ActionContext.getParameter("mailId"));
	user.setPassword(
			ActionContext.getParameter("password"));
	user.setRole(User.user);
	UserDao dao=new UserDao();
	dao.save(user);
	logger.info("user saved in the db.");
	//save the result of processing in ActionContext
	ActionContext.setAttribute("message","You are successfully registered.");
	return "registered";
	}

}
