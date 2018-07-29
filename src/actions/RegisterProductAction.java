package actions;

import java.util.ArrayList;
import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;

public class RegisterProductAction implements Action {

	@Override
	public String processRequest() 
			throws Exception {
	//Reading request data
	
	ProductDao dao=new ProductDao();
	List<Product> list=dao.getProductNames();
	ActionContext.setAttribute("products", list);
	
	//setting result in request scope.
	return "registerProduct";
	}

}
