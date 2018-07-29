package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;

public class EditProductAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("EditProductAction invoked.");
		
		int pid=Integer.parseInt(ActionContext.getParameter("id"));
		ProductDao dao=new ProductDao();
		Product product=dao.getByProductId(pid);
		
		ActionContext.setAttribute("product", product);
		
		return "editProduct";
	}

}
