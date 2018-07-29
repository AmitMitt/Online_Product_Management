package actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletContext;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import entity.Attachment;
import entity.Ticket;
import entity.TicketReply;

public class FetchTicketAction implements Action {

	@Override
	public String processRequest()throws Exception {
		Ticket t=null;
		Queue<Ticket> queue =(Queue<Ticket>) ActionContext.getServletContext().getAttribute("tQueue");
		List<Attachment> list=new ArrayList<Attachment>();
		List<Attachment> list1=new ArrayList<Attachment>();
		List<TicketReply> rlist=new ArrayList<TicketReply>();
		if(queue!=null)
		{
			t=queue.poll();
			if(t!=null){
			list.addAll(t.getAttachment());
			rlist.addAll(t.getReply());
			}
		}
		if((list.size())>0){
		Iterator<Attachment> itr=list.iterator();
		while (itr.hasNext()) {
			Attachment a = (Attachment) itr.next();
			String file=a.getFilePath();
			ServletContext ac=ActionContext.getServletContext();			        
			String basePath=ac.getRealPath("/WEB-INF/attachments\\/");
			file=file.replace(basePath, "");
			a.setFilePath(file);
			list1.add(a);
		}
		}
		if(t!=null){
			ActionContext.setAttribute("ticket", t);
			ActionContext.setAttribute("attachment", list1);
			ActionContext.setAttribute("trlist", rlist);
			return "fetchTicket";
		}else{
			ActionContext.setAttribute("message", "Ticket Queue is empty .......................");
			return "message";
		}
	}

}
