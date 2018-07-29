package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.LoginHistory;

public class LogHistoryDao extends AbstractDao{

	public void logIn(LoginHistory login) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"insert into LoginHistory (loginDate,loginTime,logoutTime,userType,userId) values(?,?,?,?,?)");
		stmt.setString(1,login.getLoginDate());
		stmt.setString(2,login.getLoginTime());
		stmt.setString(3,login.getLogoutTime());
		stmt.setInt(4,login.getUserType());
		stmt.setInt(5,login.getUserId());
		stmt.executeUpdate();
		con.close();
	}

	public void logOut(LoginHistory logout) throws Exception {
		Connection	con=getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"update LoginHistory set logoutTime=? where loginDate=? and loginTime=? and userId=?");
		stmt.setString(1, logout.getLogoutTime());
		stmt.setString(2,logout.getLoginDate());
		stmt.setString(3, logout.getLoginTime());
		stmt.setInt(4, logout.getUserId());
		stmt.executeUpdate();
		con.close();
	}

}
