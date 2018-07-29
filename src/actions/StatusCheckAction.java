package actions;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.swinfosoft.mvc.web.*;

import dao.TicketReplyDao;
import entity.TicketReply;

public class StatusCheckAction implements Action {

	@Override
	public String processRequest() throws Exception {
	     int eid=Integer.parseInt(ActionContext.getParameter("eid"));
	     TicketReplyDao dao=new TicketReplyDao();
	     List<TicketReply> list=dao.getTicketReplayByEid(eid);
	     
	        JSONArray json=(JSONArray)JSONSerializer.toJSON(list);
		    ServletResponse response=ActionContext.getServletResponse();
		    response.setContentType("text/JSON");
		    PrintWriter out=response.getWriter();
		    out.print(json);
		   // ActionContext.setAttribute("list", list);
		    out.close();
		return null;
	}

}
