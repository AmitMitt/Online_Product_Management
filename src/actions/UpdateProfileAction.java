package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.ExecDao;
import dao.UserDao;
import entity.Executive;
import entity.User;

public class UpdateProfileAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext
	User user=(User)ActionContext.getAttribute("user", 
			ActionContext.SessionScope);
	user.setName(ActionContext.getParameter("name"));
	user.setMailId(
			ActionContext.getParameter("mailId"));
	user.setPassword(
			ActionContext.getParameter("password"));
	if(user.getRole()==2){
		ExecDao dao=new ExecDao();
		Executive exec=new Executive();
		exec.setId(user.getId());
		exec.setName(user.getName());
		exec.setPassword(user.getPassword());
		exec.setLoginId(user.getMailId());
		dao.updateProfile(exec);
	}else{	
		UserDao dao=new UserDao();
		dao.update(user);
	}
	logger.info("user updated in the db.");
	//save the result of processing in ActionContext
	ActionContext.setAttribute("message","Your profile successfully updated.");
	return "updated";
	}

}
