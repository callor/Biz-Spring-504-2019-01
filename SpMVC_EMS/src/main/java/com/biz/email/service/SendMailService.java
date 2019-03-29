package com.biz.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.soap.MimeHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.biz.email.model.MailVO;

@Service
public class SendMailService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendMail(MailVO mailVO) {
		
		String from_email = mailVO.getFrom_email() ; // 보내는사람 E-mail
		String to_email = mailVO.getTo_email() ;	// 받는사람 E-mail
		String subject = mailVO.getS_subject();
		String content= mailVO.getS_content();
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mHelper ;
		try {
			mHelper 
			= new MimeMessageHelper(message,true,"UTF-8");
			
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			mHelper.setText(content);
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
