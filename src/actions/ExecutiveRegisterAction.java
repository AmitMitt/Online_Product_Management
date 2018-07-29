package actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ExecDao;
import entity.Executive;

public class ExecutiveRegisterAction implements Action{

	@Override
	public String processRequest() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String eDate=dateFormat.format(date);
		
		Executive exec=new Executive();
		exec.setName(ActionContext.getParameter("name"));
		exec.setLoginId(ActionContext.getParameter("loginId"));
		exec.setPassword(ActionContext.getParameter("password"));
		exec.setAcStatus(Executive.InActive);
		exec.setAcOpeningDate(eDate);
		exec.setTarget(0);
		exec.setLevel(Integer.parseInt(ActionContext.getParameter("level")));
		ExecDao dao=new ExecDao();
		dao.save(exec);
		ActionContext.setAttribute("message","New executive successfully created.");
		return "execCreated";
	}

}
