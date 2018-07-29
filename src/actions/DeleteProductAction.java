package actions;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;

public class DeleteProductAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int pid=Integer.parseInt(ActionContext.getParameter("id"));
		
		ProductDao dao=new ProductDao();
		dao.deleteProductById(pid);
		String msg="Product deleted successfully.";
		ActionContext.setAttribute("message", msg);
		return "productDeleted";
	}

}
