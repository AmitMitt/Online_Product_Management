package entity;

public class Executive {

	int id;
	String name,loginId,password,acStatus,acOpeningDate;
	int target,level;
	
	public static final int Operator=1;
	public static final int Moderator=2;
	public static final int Manager=3;
	
	public static final String Active="Active";
	public static final String InActive="InActive";
	
	public Executive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Executive(String name,String loginId, String password, String acStatus,
			String acOpeningDate, int target, int level) {
		this.name=name;
		this.loginId = loginId;
		this.password = password;
		this.acStatus = acStatus;
		this.acOpeningDate = acOpeningDate;
		this.target = target;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcStatus() {
		return acStatus;
	}

	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}

	public String getAcOpeningDate() {
		return acOpeningDate;
	}

	public void setAcOpeningDate(String acOpeningDate) {
		this.acOpeningDate = acOpeningDate;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
