package entity;

public class TicketReply {
	int id,ticketId,execId;
	String processTime,replyDate,replyText,customerReplyText;
	String replyBy;
	Ticket ticket;
	Product product;
	public TicketReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketReply(int ticketId, int execId, String processTime,
			String replyDate, String replyText, String customerReplyText,
			String replyBy) {
		this.ticketId = ticketId;
		this.execId = execId;
		this.processTime = processTime;
		this.replyDate = replyDate;
		this.replyText = replyText;
		this.customerReplyText = customerReplyText;
		this.replyBy = replyBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getExecId() {
		return execId;
	}

	public void setExecId(int execId) {
		this.execId = execId;
	}

	public String getProcessTime() {
		return processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public String getReplyBy() {
		return replyBy;
	}

	public void setReplyBy(String replyBy) {
		this.replyBy = replyBy;
	}

	public String getCustomerReplyText() {
		return customerReplyText;
	}

	public void setCustomerReplyText(String customerReplyText) {
		this.customerReplyText = customerReplyText;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
	
}
