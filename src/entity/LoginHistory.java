package entity;

public class LoginHistory {
	int id;
	String loginDate,loginTime,logoutTime;
	int userId,userType;
	
	public LoginHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginHistory(String loginDate, String loginTime, String logoutTime,
			int userType, int userId) {
		this.loginDate = loginDate;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.userType = userType;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
