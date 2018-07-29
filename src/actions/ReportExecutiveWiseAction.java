package actions;

import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ExecDao;
import entity.Executive;

public class ReportExecutiveWiseAction implements Action {

	@Override
	public String processRequest() throws Exception {
		ExecDao dao=new ExecDao();
		List<Executive> list=dao.allExecutive();
		ActionContext.setAttribute("executives", list);
		
		return "reportExecutiveWise";
	}

}
