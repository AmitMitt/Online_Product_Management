package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;



public class UpdateProductAction implements Action {

	@Override
	public String processRequest() 
			throws Exception {
	//Reading request data
	int id=Integer.parseInt(ActionContext.getParameter("id"));
	String n=ActionContext.getParameter("name");	
	String w=ActionContext.getParameter("warranty");
	String wt=ActionContext.getParameter("wType");
	String c=ActionContext.getParameter("coverage");	
	String e=ActionContext.getParameter("exclusion");
	Product pro=new Product();
	pro.setId(id);
	pro.setName(n);
	pro.setWarranty(w);
	pro.setwType(wt);
	pro.setCoverage(c);
	pro.setExclusion(e);
	ProductDao dao=new ProductDao();
	dao.updateProduct(pro);
	//setting result in request scope.
	ActionContext.setAttribute("message","Product Updated Successfully");
	return "productUpdated";
	}

}
