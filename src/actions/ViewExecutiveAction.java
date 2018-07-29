package actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ExecDao;
import entity.Executive;

public class ViewExecutiveAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("ViewExecutiveAction invoked.");
		
		ExecDao dao=new ExecDao();
		List<Executive> list = dao.allExecutive();
		
		ActionContext.setAttribute("executives", list);
		return "viewExecutive";
	}

}
