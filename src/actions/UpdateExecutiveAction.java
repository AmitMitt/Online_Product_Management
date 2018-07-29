package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ExecDao;
import entity.Executive;

public class UpdateExecutiveAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		
		Executive exec=new Executive();
		exec.setId(Integer.parseInt(ActionContext.getParameter("id")));
		exec.setName(ActionContext.getParameter("name"));
		exec.setLoginId(ActionContext.getParameter("loginId"));
		exec.setTarget(Integer.parseInt(ActionContext.getParameter("target")));
		exec.setAcStatus(ActionContext.getParameter("acStatus"));
		exec.setLevel(Integer.parseInt(ActionContext.getParameter("level")));
		
		ExecDao dao=new ExecDao();
		dao.update(exec);
		
		ActionContext.setAttribute("message","Executive Updated Successfully");
		
		return "execUpdated";
	}

}
