package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;

public class AddProductFormAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("AddProductFormAction invoked.");
		return "addProductForm";
	}

}
