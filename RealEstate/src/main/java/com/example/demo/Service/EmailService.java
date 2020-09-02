package com.example.demo.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	
	public boolean sendMail(String toEmail,String sub,String msg)
	{
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		System.out.println("mail"+toEmail+"subject"+sub+"Message"+msg);
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(sub);
		mailMessage.setText(msg);
		mailMessage.setFrom("hefshine.abhimanyu@gmail.com");
		javaMailSender.send(mailMessage);
		return true;
	}
	
	
	
}
