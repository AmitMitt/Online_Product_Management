package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import entity.Attachment;
import entity.Ticket;
import entity.TicketReply;

public class TicketDao extends AbstractDao{

	
	public void openTicket(Ticket t) throws Exception {
		int tid=0;
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
"insert into TicketMaster (customerId,pId,ticketDate,title,priority,description,status) values(?,?,?,?,?,?,?)");
		stmt.setInt(1, t.getCustomerId());
		stmt.setInt(2, t.getpId());
		stmt.setString(3, t.getTicketDate());
		stmt.setString(4, t.getTitle());
		stmt.setInt(5, t.getPriority());
		stmt.setString(6, t.getDescription());
		stmt.setString(7, t.getStatus());
		stmt.executeUpdate();
		Statement stmt1=con.createStatement();
		ResultSet rset=stmt1.executeQuery("Select max(id) from TicketMaster");
		if(rset.next())
		{
			tid=rset.getInt(1);
		}
		Set<Attachment> set=t.getAttachment();
		Iterator<Attachment> itr=set.iterator();
		while (itr.hasNext()) {
			Attachment a = (Attachment) itr.next();
			PreparedStatement stmt2=con.prepareStatement("insert into TicketAttachments (ticketId,filePath) values(?,?)");
			stmt2.setInt(1, tid);
			stmt2.setString(2,a.getFilePath() );
			stmt2.executeUpdate();
		}
		con.close();
	}

	public Ticket getOpenTicketById(int tid) throws Exception {
		Connection con=getConnection();
		Ticket t=null;		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketMaster WHERE status=? and id=?");
		stmt.setString(1, Ticket.Open);
		stmt.setInt(2, tid);
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			t=new Ticket();
			t.setId(rset.getInt(1));
			t.setCustomerId(rset.getInt(2));
			t.setpId(rset.getInt(3));
			t.setTicketDate(rset.getString(4));
			t.setTitle(rset.getString(5));
			t.setPriority(rset.getInt(6));
			t.setDescription(rset.getString(7));
			t.setStatus(rset.getString(8));
			t.setAttachment(attachmentsByTicketId(t.getId()));
			t.setReply(replyByTicketId(t.getId()));
		}
		return t;
	}
	
	public Ticket getAllTicketById(int tid) throws Exception {
		Connection con=getConnection();
		Ticket t=null;		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketMaster WHERE  id=?");
		stmt.setInt(1, tid);
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			t=new Ticket();
			t.setId(rset.getInt(1));
			t.setCustomerId(rset.getInt(2));
			t.setpId(rset.getInt(3));
			t.setTicketDate(rset.getString(4));
			t.setTitle(rset.getString(5));
			t.setPriority(rset.getInt(6));
			t.setDescription(rset.getString(7));
			t.setStatus(rset.getString(8));
			t.setAttachment(attachmentsByTicketId(t.getId()));
			t.setReply(replyByTicketId(t.getId()));
		}
		return t;
	}
	
	public LinkedList<Ticket> getOpenTicketList() throws Exception {
		Connection con=getConnection();
		LinkedList<Ticket> list=new LinkedList<Ticket>();		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketMaster WHERE status=?");
		stmt.setString(1, Ticket.Open);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			Ticket t=new Ticket();
			t.setId(rset.getInt(1));
			t.setCustomerId(rset.getInt(2));
			t.setpId(rset.getInt(3));
			t.setTicketDate(rset.getString(4));
			t.setTitle(rset.getString(5));
			t.setPriority(rset.getInt(6));
			t.setDescription(rset.getString(7));
			t.setStatus(rset.getString(8));
			t.setAttachment(attachmentsByTicketId(t.getId()));
			t.setReply(replyByTicketId(t.getId()));
			list.add(t);
		}
		System.out.println("Queue size is: "+list.size());
		return list;
	}
	
	public LinkedList<Ticket> getCloseTicketList() throws Exception {
		Connection con=getConnection();
		LinkedList<Ticket> list=new LinkedList<Ticket>();		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketMaster WHERE status=?");
		stmt.setString(1, Ticket.Close);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			Ticket t=new Ticket();
			t.setId(rset.getInt(1));
			t.setCustomerId(rset.getInt(2));
			t.setpId(rset.getInt(3));
			t.setTicketDate(rset.getString(4));
			t.setTitle(rset.getString(5));
			t.setPriority(rset.getInt(6));
			t.setDescription(rset.getString(7));
			t.setStatus(rset.getString(8));
			t.setAttachment(attachmentsByTicketId(t.getId()));
			t.setReply(replyByTicketId(t.getId()));
			list.add(t);
		}
		System.out.println("Queue size is: "+list.size());
		return list;
	}


	HashSet<Attachment> attachmentsByTicketId(int tid) throws Exception
	{
		HashSet<Attachment> set=new HashSet<Attachment>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketAttachments WHERE ticketId=?");
		stmt.setInt(1, tid);
		ResultSet rset=stmt.executeQuery();
		while (rset.next()) {
			Attachment a = new Attachment();
			a.setAttachmentId(rset.getInt(1));
			a.setTicketId(rset.getInt(2));
			a.setFilePath(rset.getString(3));
			set.add(a);
		}
		System.out.println("Attachment Size is: "+set.size());
		return set;
	}
	
	public Attachment attachmentById(int aid) throws Exception
	{	Attachment a = null;
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketAttachments WHERE attachmentId=?");
		stmt.setInt(1, aid);
		ResultSet rset=stmt.executeQuery();
		while (rset.next()) {
			a = new Attachment();
			a.setAttachmentId(rset.getInt(1));
			a.setTicketId(rset.getInt(2));
			a.setFilePath(rset.getString(3));
		}
		return a;
	}
	
	HashSet<TicketReply> replyByTicketId(int tid) throws Exception
	{
		HashSet<TicketReply> set=new HashSet<TicketReply>();
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketReplies WHERE ticketId=?");
		stmt.setInt(1, tid);
		ResultSet rset=stmt.executeQuery();
		while (rset.next()) {
			TicketReply r = new TicketReply();
			r.setId(rset.getInt(1));
			r.setTicketId(rset.getInt(2));
			r.setExecId(rset.getInt(3));
			r.setProcessTime(rset.getString(4));
			r.setReplyDate(rset.getString(5));
			r.setReplyText(rset.getString(6));
			r.setCustomerReplyText(rset.getString(7));
			r.setReplyBy(rset.getString(8));
			set.add(r);
		}
		return set;
	}

	public LinkedList<Ticket> getOpenTicketListByCid(int cid) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		ProductDao dao=new ProductDao();
		LinkedList<Ticket> list=new LinkedList<Ticket>();		
		PreparedStatement stmt=con.prepareStatement("SELECT * FROM TicketMaster WHERE status=? and customerId=?");
		stmt.setString(1, Ticket.Open);
		stmt.setInt(2, cid);
		ResultSet rset=stmt.executeQuery();
		while(rset.next())
		{
			Ticket t=new Ticket();
			t.setId(rset.getInt(1));
			t.setCustomerId(rset.getInt(2));
			t.setpId(rset.getInt(3));
			t.setTicketDate(rset.getString(4));
			t.setTitle(rset.getString(5));
			t.setPriority(rset.getInt(6));
			t.setDescription(rset.getString(7));
			t.setStatus(rset.getString(8));
			t.setAttachment(attachmentsByTicketId(t.getId()));
			t.setPro(dao.getByProductId(t.getpId()));
			list.add(t);
		}
		System.out.println("Queue size is: "+list.size());
		return list;
	}
	
	
	
	public void closeTicket(int tid)throws Exception{
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("update TicketMaster set status=? WHERE id=?");
		stmt.setString(1, Ticket.Close);
		stmt.setInt(2, tid);
		stmt.executeUpdate();
		con.close();		
	}
	public void openStatus(int tid)throws Exception{
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("update TicketMaster set status=? WHERE id=?");
		stmt.setString(1, Ticket.Open);
		stmt.setInt(2, tid);
		stmt.executeUpdate();
		con.close();		
	}

}


