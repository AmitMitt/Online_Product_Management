package actions;

import java.util.*;

import com.swinfosoft.mvc.web.*;

import dao.ProductDao;
import entity.User;
import entity.UserProduct;

public class UserMailAction implements Action {

	@Override
	public String processRequest() throws Exception {
		
		User user=(User) ActionContext.getAttribute("user", ActionContext.SessionScope);
		ProductDao dao=new ProductDao();
		List<UserProduct> list=dao.getRegisteredProduct(user.getId());
		ActionContext.setAttribute("products", list);
		return "userMail";
	}

}
