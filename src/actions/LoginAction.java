package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.ExecDao;
import dao.UserDao;
import entity.Executive;
import entity.User;

public class LoginAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	//read request data from ActionContext	
	int userType=Integer.parseInt(ActionContext.getParameter("userType"));
	User user=new User();
	user.setMailId(ActionContext.getParameter("userId"));
	user.setPassword(ActionContext.getParameter("password"));
	
	if(userType==2){
		UserDao dao=new UserDao();		
		user=dao.findUser(user);
	}else if(userType==1){
		ExecDao dao=new ExecDao();
		Executive exec=dao.findByLoginIdPassword(user.getMailId(), user.getPassword());
		if(exec!=null){
		user.setId(exec.getId());
		user.setName(exec.getName());
		user.setMailId(exec.getLoginId());
		user.setPassword(exec.getPassword());
		user.setRole(2);
		}else{ user=null;}
	}
	
	if(user==null){
		ActionContext.setAttribute("message","Invalid MailId or Password!");
		return "invalidUser";
	}else{
		ActionContext.setAttribute("user",user,ActionContext.SessionScope);
		return "validUser";
	}
	
	}

}
