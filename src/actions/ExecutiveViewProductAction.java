package actions;

import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.UserProduct;

public class ExecutiveViewProductAction implements Action {

	@Override
	public String processRequest() throws Exception {
		ProductDao dao=new ProductDao();
		List<UserProduct> list=dao.getAllRegisteredProduct();
		ActionContext.setAttribute("regProduct", list);
			
		return "viewProductExecutive";
	}

}
