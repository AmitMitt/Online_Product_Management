package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;



public class AddProductAction implements Action {

	@Override
	public String processRequest() 
			throws Exception {
	//Reading request data
	String n=ActionContext.getParameter("name");	
	String w=ActionContext.getParameter("warranty");
	String wt=ActionContext.getParameter("wType");
	String c=ActionContext.getParameter("coverage");	
	String e=ActionContext.getParameter("exclusion");
	Product pro=new Product();
	pro.setName(n);
	pro.setWarranty(w);
	pro.setwType(wt);
	pro.setCoverage(c);
	pro.setExclusion(e);
	ProductDao dao=new ProductDao();
	dao.addProduct(pro);
	//setting result in request scope.
	ActionContext.setAttribute("message","Product Added Successfully");
	return "productAdded";
	}

}
