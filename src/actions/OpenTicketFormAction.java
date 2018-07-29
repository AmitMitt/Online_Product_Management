package actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.User;
import entity.UserProduct;

public class OpenTicketFormAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("OpenTicketFormAction invoked.");
		User user=(User)ActionContext.getAttribute("user");
		ProductDao dao=new ProductDao();
		List<UserProduct> list=dao.getRegisteredProduct(user.getId());
		ActionContext.setAttribute("produts", list);
		return "openTicket";
	}

}
