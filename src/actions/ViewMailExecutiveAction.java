package actions;

import java.util.*;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.SendMailDao;
import entity.SendMail;

public class ViewMailExecutiveAction implements Action
{
  public String processRequest() throws Exception
  {
	  SendMailDao smd=new SendMailDao();
	  List<SendMail> list=smd.getMail();
	  ActionContext.setAttribute("viewMail", list);
	  return "viewMailExecutive";
  }
}
