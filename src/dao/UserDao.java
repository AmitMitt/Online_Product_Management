package dao;

import java.sql.*;

import entity.User;

public class UserDao extends AbstractDao {

	//Method to save the user
	public void save(User user) throws Exception
	{
	//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
	PreparedStatement stmt=con.prepareStatement(
	"insert into UserMaster (name,mailid,password,role)"
	+ " values(?,?,?,?)");
	//set the value of parameters.
	stmt.setString(1,user.getName());
	stmt.setString(2,user.getMailId());
	stmt.setString(3,user.getPassword());
	stmt.setInt(4,user.getRole());
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
	
	//Method to update the user
	public void update(User user) throws Exception
		{
		//Connection is obtained.
Connection	con=getConnection();//super class method
	//Statement object is created to execute the query.
		PreparedStatement stmt=con.prepareStatement(
		"update UserMaster set name=?, mailId=?, "
		+ "password=?, role=? where id=?");
		//set the value of parameters.
		stmt.setString(1,user.getName());
		stmt.setString(2,user.getMailId());
		stmt.setString(3,user.getPassword());
		stmt.setInt(4, user.getRole());
		stmt.setInt(5, user.getId());
		//execute the query
		stmt.executeUpdate();
		//close the connection
		con.close();
		}
//Method to delete the user
public void delete(int userId) throws Exception
		{
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"delete from UserMaster where id=?");
	//set the value of parameters.
	stmt.setInt(1, userId);
	//execute the query
	stmt.executeUpdate();
	//close the connection
	con.close();
	}
		
//Method to load a user using id
public User getById(int userId) throws Exception
		{
	User user=null;
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from UserMaster where id=?");
	//set the value of parameters.
	stmt.setInt(1, userId);
	//execute the query
	ResultSet rset=stmt.executeQuery();
	//read the result of select query
	if(rset.next())//if user is found.
	{
		user=new User();
		//store record data in object
		user.setId(rset.getInt(1));
		user.setName(rset.getString(2));
		user.setMailId(rset.getString(3));
		user.setPassword(rset.getString(4));
		user.setRole(rset.getInt(5));
	}
	//close the connection
	con.close();
	//return the user object
	return user;
	}	

//Method to find user using mailId and password
public User findUser(User user) throws Exception
		{
	
//Connection is obtained.
Connection	con=getConnection();//super class method
//Statement object is created to execute the query.
PreparedStatement stmt=con.prepareStatement(
	"select * from UserMaster where mailId=? and password=?");
	//set the value of parameters.
	stmt.setString(1, user.getMailId());
	stmt.setString(2, user.getPassword());
	//execute the query
	ResultSet rset=stmt.executeQuery();
	user=null;
	//read the result of select query
	if(rset.next())//if user is found.
	{
		user=new User();
		//store record data in object
		user.setId(rset.getInt(1));
		user.setName(rset.getString(2));
		user.setMailId(rset.getString(3));
		user.setPassword(rset.getString(4));
		user.setRole(rset.getInt(5));
	}
	//close the connection
	con.close();
	//return the user object
	return user;
	}	

}









