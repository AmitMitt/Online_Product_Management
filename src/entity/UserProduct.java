package entity;

public class UserProduct {

	int id,pid,cid;
	String pname,pDate,pPrice,vendor;
	User user;
	Product product;
	public UserProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserProduct(int id, int pid, String pname, String pDate,
			String pPrice, String vendor) {
		super();
		this.id = id;
		this.pid = pid;
		this.pname = pname;
		this.pDate = pDate;
		this.pPrice = pPrice;
		this.vendor = vendor;
	}
	
	

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getpPrice() {
		return pPrice;
	}
	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
