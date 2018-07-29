package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.*;

import dao.ConfigDao;
import dao.UserDao;
import entity.User;

public class ConfigAction implements Action {

	//method to process request 
	public String processRequest() throws Exception 
	{
	Logger logger=Logger.getRootLogger();	
	logger.info("ConfigAction invoked.");
	ConfigDao dao=new ConfigDao();
	if(dao.isConfigured())
	ActionContext.setAttribute("page", "views/visitorHome.jsp");
	else
	ActionContext.getSession().setAttribute("page", "views/dbConfig.jsp");
		
	return "null";
	}

}
