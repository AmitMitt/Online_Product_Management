package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ExecDao;
import entity.Executive;

public class EditExecutiveAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("EditExecutiveAction invoked.");
		
		int eid=Integer.parseInt(ActionContext.getParameter("id"));
		ExecDao dao=new ExecDao();
		Executive exec=dao.findById(eid);
		
		ActionContext.setAttribute("executive", exec);
		
		return "editExec";
	}

}
