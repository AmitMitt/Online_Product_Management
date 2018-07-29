package actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.ProductDao;
import entity.Product;
import entity.User;
import entity.UserProduct;
import util.DateDiffrence;

public class WarrantyDetailsAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(ActionContext.getParameter("id"));
		//User user=(User)ActionContext.getAttribute("user");
		ProductDao pdao=new ProductDao();
		UserProduct upro= pdao.getUserProductById(id);
		upro=pdao.getCustomerProductById(id, upro.getPid());
		
		Product pro=pdao.getByProductId(upro.getPid());
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String currentDate=dateFormat.format(date);
		
		String purchaseDate=upro.getpDate();
		int warranty=Integer.parseInt(pro.getWarranty());
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(dateFormat.parse(purchaseDate));
		cal.add(Calendar.MONTH,warranty);
		
		
		String str="";		
		if(dateFormat.parse(currentDate).before(cal.getTime()))
			
			str ="Warranty Remaining: "+DateDiffrence.getDateDiffrence(dateFormat.parse(currentDate),cal.getTime());
		else
			str ="Warranty Expired By: "+DateDiffrence.getDateDiffrence(cal.getTime(),dateFormat.parse(currentDate));
		
		pro.setWarranty(pro.getWarranty()+";"+str);
		
		ActionContext.setAttribute("product", pro);
		
		return "warrantyDetail";
	}

	
	
}
