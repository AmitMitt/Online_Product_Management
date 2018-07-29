package actions;

import java.util.List;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;

public class ReportProductWiseAction implements Action {

	@Override
	public String processRequest() throws Exception {
		ProductDao dao=new ProductDao();
		List<Product> list=dao.getProductNames();
		ActionContext.setAttribute("products", list);
		
		return "reportProductWise";
	}

}
