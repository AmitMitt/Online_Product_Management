package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.ConfigDao;
import dao.UserDao;
import entity.User;

public class ConfigDBAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	logger.info("ConfigDBAction invoked.");
	
	//reading db configuration
	String user=ActionContext.getParameter("name");
	String password=ActionContext.getParameter("password");
	String db=ActionContext.getParameter("db");
	ConfigDao dao=new ConfigDao();
	dao.configure(user,password,db);
		
	return "configured";
	}

}
