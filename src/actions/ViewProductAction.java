package actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;
import entity.User;

public class ViewProductAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("ViewProductAction invoked.");
		
		ProductDao dao=new ProductDao();
		List<Product> list=dao.getProductNames();
		
		ActionContext.setAttribute("products", list);
		
		return "viewProduct";
	}

}
