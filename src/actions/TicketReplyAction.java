package actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.swinfosoft.mvc.web.Action;
import com.swinfosoft.mvc.web.ActionContext;

import dao.TicketDao;
import dao.TicketReplyDao;
import entity.Ticket;
import entity.TicketReply;
import entity.User;
import util.ProcessingTime;

public class TicketReplyAction implements Action{

	@Override
	public String processRequest() throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=ActionContext.getSession();
		User user=(User)session.getAttribute("user");
		ProcessingTime pTime=new ProcessingTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String rDate=dateFormat.format(date);
		String tDate=ActionContext.getParameter("tDate");		
		TicketReply reply=new TicketReply();
		reply.setTicketId(Integer.parseInt(ActionContext.getParameter("tid")));
		reply.setExecId(user.getId());
		reply.setReplyDate(rDate);
		reply.setReplyText(ActionContext.getParameter("reply"));
		reply.setReplyBy(user.getName());
		reply.setCustomerReplyText(null);
		reply.setProcessTime(pTime.processTime(tDate, rDate));
		TicketReplyDao dao=new TicketReplyDao();
		dao.save(reply);
		
		TicketDao tdao=new TicketDao();
		Queue<Ticket> tqueue=tdao.getOpenTicketList();
		ServletContext ctx = ActionContext.getServletContext();
		ctx.setAttribute("tQueue", tqueue);
		
		ActionContext.setAttribute("message", "Reply sent successfully.");
		return "message";
	}

}
