package z03_kurlyproject.vo;

public class QnA {
	private int callno;
	private int userno;
	private String question;
	private String answer;
	public QnA() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnA(int callno, int userno, String question, String answer) {
		this.callno = callno;
		this.userno = userno;
		this.question = question;
		this.answer = answer;
	}
	public QnA(int callno, String answer) {
		this.callno = callno;
		this.answer = answer;
	}
	public int getCallno() {
		return callno;
	}
	public void setCallno(int callno) {
		this.callno = callno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
