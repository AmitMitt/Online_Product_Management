package actions;
import java.util.List;

import com.swinfosoft.mvc.web.*;

import dao.ProductDao;
import entity.UserProduct;
public class ReportMonthlyWiseAction implements Action {

	@Override
	public String processRequest() throws Exception {
		
		String fDate=ActionContext.getParameter("fDate");
		String tDate=ActionContext.getParameter("tDate");
		ProductDao dao=new ProductDao();
		List<UserProduct> list =dao.dateDifferenc(fDate, tDate);
		ActionContext.setAttribute("list", list);
		ActionContext.setAttribute("from", fDate);
		ActionContext.setAttribute("to", tDate);
		return "reportMonthlyWise";
	}

}
