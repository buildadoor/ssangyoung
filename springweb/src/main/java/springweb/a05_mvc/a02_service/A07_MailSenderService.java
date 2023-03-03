package springweb.a05_mvc.a02_service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import springweb.z01_vo.Mail;

@Service
public class A07_MailSenderService {
	// 컨테이너에 선언된 객체 호출.
	@Autowired(required=false)
	private JavaMailSender sender;
	
	public String sendMail(Mail email) {
		String resultMsg = "메일 발송 성공";
		// 1. 메일 데이터를 전송을 위한 객체 생성
		MimeMessage mmsg = sender.createMimeMessage();
		// 2. 입력된 메일정보 할당.
		try {
			// 1) 제목
			mmsg.setSubject(email.getTitle());
			// 2) 수신자
			mmsg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));
			// 3) 내용
			mmsg.setText(email.getContent());
		// 3. 발송처리
			sender.send(mmsg);
		} catch (MessagingException e) {
			System.out.println("메시지 전송 에러:"+e.getMessage());
			resultMsg="메시지 전송 에러:"+e.getMessage();
		}catch(Exception e) {
			System.out.println("기타 에러:"+e.getMessage());
			resultMsg="기타 에러:"+e.getMessage();
		}
		
		
		return resultMsg;
	}
	
}
