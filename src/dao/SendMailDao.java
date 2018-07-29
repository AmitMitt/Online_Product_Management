package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Executive;
import entity.SendMail;
import entity.User;


public class SendMailDao extends AbstractDao
{
    public void saveMail(SendMail mail) throws Exception
    {
    	Connection con=getConnection();
    	PreparedStatement stmt=con.prepareStatement(
    "insert into MailMaster(cId,pId,message,replyOn) values(?,?,?,?)");
    	stmt.setInt(1, mail.getcId());
    	stmt.setInt(2, mail.getpId());
    	stmt.setString(3, mail.getMessage());
    	stmt.setInt(4, mail.getReplyOn());
    	stmt.executeUpdate();
    	con.close();
    }
    public List<SendMail> getMail() throws Exception
    {
    	Connection con=getConnection();
    	UserDao dao=new UserDao();
    	ProductDao pdao=new ProductDao();
    	PreparedStatement stmt=con.prepareStatement("select * from MailMaster where replyOn=?");
    	stmt.setInt(1, 0);
    	ResultSet rset=stmt.executeQuery();
    	List<SendMail> list=new ArrayList<SendMail>();
    	while(rset.next())
    	{
    	SendMail sm=new SendMail();
    	         sm.setId(rset.getInt(1));
    	         sm.setcId(rset.getInt(2));
    	         sm.setpId(rset.getInt(3));
    	         sm.setMessage(rset.getString(4));
    	         sm.setReplyOn(rset.getInt(5));
    	         sm.setUser(dao.getById(sm.getcId()));
    	         sm.setProduct(pdao.getByProductId(sm.getpId()));
    	         list.add(sm);
    	}
    	con.close();
    	return list;
    }
    
    public List<SendMail> getMail(int id) throws Exception
    {
    	Connection con=getConnection();
    	UserDao dao=new UserDao();
    	ProductDao pdao=new ProductDao();
    	PreparedStatement stmt=con.prepareStatement("select * from MailMaster where replyOn=?");
    	stmt.setInt(1, id);
    	ResultSet rset=stmt.executeQuery();
    	List<SendMail> list=new ArrayList<SendMail>();
    	while(rset.next())
    	{
    	SendMail sm=new SendMail();
    	         sm.setId(rset.getInt(1));
    	         sm.setcId(rset.getInt(2));
    	         sm.setpId(rset.getInt(3));
    	         sm.setMessage(rset.getString(4));
    	         sm.setReplyOn(rset.getInt(5));
    	         sm.setUser(dao.getById(sm.getcId()));
    	         sm.setProduct(pdao.getByProductId(sm.getpId()));
    	         list.add(sm);
    	}
    	con.close();
    	return list;
    }
    
    public SendMail getMailMessageById(int id , int cid) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from MailMaster where id=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		SendMail mp=null;
		if(rset.next())
		{	
			UserDao udao=new UserDao();
			User user=udao.getById(cid);
			mp=new SendMail(rset.getInt(1),rset.getInt(2), user, rset.getInt(3),rset.getString(4), rset.getInt(5));
		}
		con.close();
		return mp;
	}
    
    public SendMail getMailMessageById(int id) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from MailMaster where id=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		SendMail mp=null;
		if(rset.next())
		{	
			ExecDao udao=new ExecDao();
			ProductDao pdao=new ProductDao();
			Executive exec=udao.findById(rset.getInt(2));
			mp=new SendMail(rset.getInt(1),rset.getInt(2), null, rset.getInt(3),rset.getString(4), rset.getInt(5));
			mp.setProduct(pdao.getByProductId(rset.getInt(3)));
			mp.setExec(exec);
		}
		con.close();
		return mp;
	}
}
