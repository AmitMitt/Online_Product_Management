package actions;

import org.apache.log4j.Logger;

import com.swinfosoft.mvc.web.Action;

public class CreateExecutiveFormAction implements Action {

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		Logger logger=Logger.getRootLogger();	
		logger.info("CreateExecutiveFormAction invoked.");
		return "createExecutiveForm";
	}

}
