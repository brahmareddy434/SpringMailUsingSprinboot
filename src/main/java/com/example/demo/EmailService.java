package com.example.demo;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	public JavaMailSenderImpl javaMailSender;

	public void mailsend(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("bmmmnrvv434@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		javaMailSender.send(message);
		System.out.println("mail send...");
	}

	public void sentondate(String to, String text, MultipartFile file,Date date) throws Exception {
		file.transferTo(
				new File("C:\\\\Users\\\\softsuave\\\\Pictures\\\\Camera Roll\\\\" + file.getOriginalFilename()));
		File f = new File("C:\\\\Users\\\\softsuave\\\\Pictures\\\\Camera Roll\\\\" + file.getOriginalFilename());
		String path = f.getAbsolutePath();

		javaMailSender.setUsername("bmmmnrvv434@gmail.com");

		MimeMessage m = javaMailSender.createMimeMessage();
		MimeMessageHelper mm = new MimeMessageHelper(m, true);
		m.setFrom(new InternetAddress("softsuave@gmail.com", "king"));
		m.addHeader("SoftSuave", "king434");
		mm.setTo(to);
		mm.setSubject("softsuave");
		mm.setText(text);
		FileSystemResource fsr = new FileSystemResource(new File(path));
		mm.addAttachment(fsr.getFilename(), fsr);
		mm.setSentDate(date);
		javaMailSender.send(m);

	}

}
