package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.User;

public class RegProductAction implements Action {

	@Override
	public String processRequest() 
			throws Exception {
	//Reading request data	
	int pid=Integer.parseInt(ActionContext.getParameter("pid"));
	String pDate=ActionContext.getParameter("pDate");
	String pPrice=ActionContext.getParameter("pPrice");	
	String vendor=ActionContext.getParameter("vendor");
	User user=(User)ActionContext.getAttribute("user",ActionContext.SessionScope); 
	int cid=user.getId();
	ProductDao dao=new ProductDao();
	dao.registerProduct(pid,cid,pDate,pPrice,vendor);
	//setting result in request scope.
	ActionContext.setAttribute("message","Product Registered Successfully");
	return "productAdded";
	}

}
