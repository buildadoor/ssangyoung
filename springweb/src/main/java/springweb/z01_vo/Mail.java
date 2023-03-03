package springweb.z01_vo;

// 메일 발송 요청값 처리하는 vo
public class Mail {
	private String receiver; //수신자
	private String sender; //발신자
	private String title; //제목
	private String content; //내용
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
