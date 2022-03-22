package net.edupoll.kr.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	public boolean sendTestMail(String target) {
		// SimpleMessage : text
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[테스트]테스트메일입니다.");
		message.setText("테스트 메일입니다");
		message.setTo(target);
		message.setFrom("edupoll");
		
		try {
		mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean sendTestHTMLMail(String target) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		try {
			helper.setSubject("[테스트] 테스트");
			String text = "<h1>환영메일</h1><hr/>반갑습니다.";
			helper.setText(text, true);
			helper.setTo(target);
			
			mailSender.send(message);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}
}
