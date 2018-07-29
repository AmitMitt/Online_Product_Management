package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import entity.Executive;

public class ExecDao extends AbstractDao
{
Logger logger=Logger.getRootLogger();
	public void save(Executive exec) throws Exception
	{
	Connection	con=getConnection();
	PreparedStatement stmt=con.prepareStatement(
	"insert into ExecutiveMaster (name,loginId,password,acStatus,acOpeningDate,target,level) values(?,?,?,?,?,?,?)");
	stmt.setString(1, exec.getName());
	stmt.setString(2,exec.getLoginId());
	stmt.setString(3, exec.getPassword());
	stmt.setString(4,exec.getAcStatus());
	stmt.setString(5,exec.getAcOpeningDate());
	stmt.setInt(6,exec.getTarget());
	stmt.setInt(7, exec.getLevel());
	stmt.executeUpdate();
	con.close();
	}
	
	public Executive findByLoginIdPassword(String u, String p) throws Exception {
		Executive exec=null;
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from ExecutiveMaster where loginId=? and password=?");
		stmt.setString(1, u);
		stmt.setString(2, p);
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			if(rset.getString(5).equals("Active")){
			exec=new Executive();
			exec.setId(rset.getInt(1));
			exec.setName(rset.getString(2));
			exec.setLoginId(rset.getString(3));
			exec.setPassword(rset.getString(4));
			exec.setAcStatus(rset.getString(5));
			exec.setAcOpeningDate(rset.getString(6));
			exec.setTarget(rset.getInt(7));
			exec.setLevel(rset.getInt(8));
			}
		}
		con.close();
		return exec;
	}
	
	public Executive findById(int id) throws Exception {
		Executive exec=null;
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from ExecutiveMaster where id=?");
		stmt.setInt(1, id);
		ResultSet rset=stmt.executeQuery();
		if(rset.next())
		{
			exec=new Executive();
			exec.setId(rset.getInt(1));
			exec.setName(rset.getString(2));
			exec.setLoginId(rset.getString(3));
			exec.setPassword(rset.getString(4));
			exec.setAcStatus(rset.getString(5));
			exec.setAcOpeningDate(rset.getString(6));
			exec.setTarget(rset.getInt(7));
			exec.setLevel(rset.getInt(8));
		}
		con.close();
		return exec;
	}
	
	public List<Executive> allExecutive() throws Exception {
		List<Executive> list=new ArrayList<Executive>();
		Connection con=getConnection();
		Statement stmt=con.createStatement();
		ResultSet rset=stmt.executeQuery("select * from ExecutiveMaster");
		while(rset.next())
		{
			Executive exec=new Executive();
			exec.setId(rset.getInt(1));
			exec.setName(rset.getString(2));
			exec.setLoginId(rset.getString(3));
			exec.setPassword(rset.getString(4));
			exec.setAcStatus(rset.getString(5));
			exec.setAcOpeningDate(rset.getString(6));
			exec.setTarget(rset.getInt(7));
			exec.setLevel(rset.getInt(8));
			list.add(exec);
		}
		con.close();
		return list;
	}
	
	public void update(Executive exec) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("update ExecutiveMaster set name=?,loginId=?,acStatus=?,target=?,level=? where id=?");
		
		stmt.setString(1,exec.getName());
		stmt.setString(2,exec.getLoginId());
		stmt.setString(3,exec.getAcStatus());
		stmt.setInt(4, exec.getTarget());
		stmt.setInt(5, exec.getLevel());
		stmt.setInt(6, exec.getId());
		stmt.executeUpdate();
		con.close();
	}
	
	public void updateProfile(Executive exec) throws Exception
	{
		Connection con=getConnection();
		PreparedStatement stmt=con.prepareStatement("update ExecutiveMaster set name=?,loginId=?,password=? where id=?");
		
		stmt.setString(1,exec.getName());
		stmt.setString(2,exec.getLoginId());
		stmt.setString(3,exec.getPassword());
		stmt.setInt(4, exec.getId());
		stmt.executeUpdate();
		con.close();
	}
		
}
