package actions;

import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.User;
import entity.UserProduct;


public class ProductViewAction implements Action {

	@Override
	public String processRequest() 
			throws Exception {
	//Reading request data
	
	User u=(User)ActionContext.getAttribute("user",ActionContext.SessionScope);
	ProductDao dao=new ProductDao();
	List<UserProduct> list=dao.getRegisteredProduct(u.getId());
	ActionContext.setAttribute("regProduct", list);
		
	return "regProductView";
	}
	
}


