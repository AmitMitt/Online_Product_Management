package entity;

public class Attachment {
	int attachmentId, ticketId;
	String filePath;
	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attachment(int ticketId, String filePath) {
		this.ticketId = ticketId;
		this.filePath = filePath;
	}
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
