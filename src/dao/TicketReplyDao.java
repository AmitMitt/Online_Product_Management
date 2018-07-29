package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.Ticket;
import entity.TicketReply;

public class TicketReplyDao extends AbstractDao{

	public void save(TicketReply reply) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("insert into TicketReplies (ticketId,execId,processTime,replyDate,replyText,customerReplyText,replyBy) values(?,?,?,?,?,?,?)");
		stmt.setInt(1, reply.getTicketId());
		stmt.setInt(2, reply.getExecId());
		stmt.setString(3, reply.getProcessTime());
		stmt.setString(4, reply.getReplyDate());
		stmt.setString(5, reply.getReplyText());
		stmt.setString(6, reply.getCustomerReplyText());
		stmt.setString(7, reply.getReplyBy());
		stmt.executeUpdate();
		con.close();
	}

	public ArrayList<TicketReply> byTicketId(int tid) throws Exception {
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from TicketReplies where ticketId=?");
		stmt.setInt(1, tid);
		ResultSet rset=stmt.executeQuery();
		ArrayList<TicketReply> list=new ArrayList<TicketReply>();
		while(rset.next())
		{
			TicketReply r=new TicketReply();
			r.setId(rset.getInt(1));
			r.setTicketId(rset.getInt(2));
			r.setExecId(rset.getInt(3));
			r.setProcessTime(rset.getString(4));
			r.setReplyDate(rset.getString(5));
			r.setReplyText(rset.getString(6));
			r.setCustomerReplyText(rset.getString(7));
			r.setReplyBy(rset.getString(8));
			list.add(r);
		}
		con.close();
		return list;
	}

	
	public List<TicketReply> getTicketReplayByEid(int eid) throws Exception {
		Connection con=getConnection();
		TicketDao tdao=new TicketDao();
		ProductDao pdao=new ProductDao();
		List<TicketReply> list=new ArrayList<TicketReply>();		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketReplies WHERE execId=?");
		stmt.setInt(1, eid);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			TicketReply r = new TicketReply();
			r.setId(rset.getInt(1));
			r.setTicketId(rset.getInt(2));
			r.setExecId(rset.getInt(3));
			r.setProcessTime(rset.getString(4));
			r.setReplyDate(rset.getString(5));
			r.setReplyText(rset.getString(6));
			r.setCustomerReplyText(rset.getString(7));
			r.setReplyBy(rset.getString(8));
			r.setTicket(tdao.getAllTicketById(r.getTicketId()));
			r.setProduct(pdao.getByProductId(r.getTicket().getpId()));
			list.add(r);
			
		}
		System.out.println("Queue size is: "+list.size());
		return list;
	}
	
	
	public void updateReply(int trid, String ctr) throws Exception {
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("update TicketReplies set customerReplyText=? where id=?");
		stmt.setString(1, ctr);
		stmt.setInt(2, trid);
		stmt.executeUpdate();
		con.close();
	}

}
