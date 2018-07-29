package entity;

import java.util.Set;


public class Ticket {

	int id,customerId,pId;
	String title,description,status;
	String ticketDate;
	int priority;
	Product pro;
	Set<Attachment> attachment;
	Set<TicketReply> reply;
	
	public static final int Low=1;
	public static final int Normal=2;
	public static final int High=3;
	
	public static final String Open="open";
	public static final String Close="close";
	
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(int customerId, String title, String description,
			String status, String ticketDate, int priority,
			Set<Attachment> attachment, Set<TicketReply> reply) {
		this.customerId = customerId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.ticketDate = ticketDate;
		this.priority = priority;
		this.attachment = attachment;
		this.reply = reply;
	}

	public Set<TicketReply> getReply() {
		return reply;
	}

	public void setReply(Set<TicketReply> reply) {
		this.reply = reply;
	}

	public Set<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachment = attachment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(String tDate) {
		this.ticketDate = tDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}
	
	
}
