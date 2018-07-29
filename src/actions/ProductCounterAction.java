package actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.UserProduct;

public class ProductCounterAction implements Action {

	@Override
	public String processRequest() throws Exception {
		int pid=Integer.parseInt(ActionContext.getParameter("pid"));
	    ProductDao dao=new ProductDao();
	    List<UserProduct> list=dao.getProductById(pid);
	    
	    JSONArray json=(JSONArray)JSONSerializer.toJSON(list);
	    ServletResponse response=ActionContext.getServletResponse();
	    response.setContentType("text/JSON");
	    PrintWriter out=response.getWriter();
	    out.print(json);
	    ActionContext.setAttribute("list", list);
	    out.close();
		return null;
	}

}
