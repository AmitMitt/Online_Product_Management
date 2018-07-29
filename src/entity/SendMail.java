package entity;

public class SendMail
{
      private int id,cId,pId,replyOn;
      private String message;
      private User user;
      private Product product;
      private Executive exec;
      
      public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SendMail(int id, int cId,User user, int pId, String message, int replyOn) {
		super();
		this.id = id;
		this.cId = cId;
		this.pId = pId;
		this.replyOn = replyOn;
		this.message = message;
		this.user = user;
	}
	
      
      public int getReplyOn() {
		return replyOn;
	}
	public void setReplyOn(int replyOn) {
		this.replyOn = replyOn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}


	public Executive getExec() {
		return exec;
	}


	public void setExec(Executive exec) {
		this.exec = exec;
	}
	
}
